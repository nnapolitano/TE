package com.techelevator;

import com.techelevator.biz.*;
import com.techelevator.entity.*;
import com.techelevator.view.Menu;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class CampgroundCLI {

    //main menu
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    //campground
    private static final String SUB_MENU_OPTION_VIEW_CAMPGROUNDS = "View Campgrounds";
    private static final String SUB_MENU_OPTION_SEARCH_RESERVATIONS = "Search for Reservation";
    private static final String SUB_MENU_OPTION_RETURN_TO_PREVIOUS = "Return to Previous Screen";
    private static final String[] SUB_MENU_OPTIONS = new String[]{
            SUB_MENU_OPTION_VIEW_CAMPGROUNDS,
            SUB_MENU_OPTION_SEARCH_RESERVATIONS,
            SUB_MENU_OPTION_RETURN_TO_PREVIOUS};
    //reservation
    private static final String SUB_MENU_OPTION_AVAILABLE_RESERVATION = "Search for Available Reservation";
    private static final String[] SUB_MENU_OPTIONS_RESERVATIONS = new String[]{
            SUB_MENU_OPTION_AVAILABLE_RESERVATION,
            SUB_MENU_OPTION_RETURN_TO_PREVIOUS};

    private Menu menu;
    private ReservationManager rm;
    private List<Campground> campgrounds;
    private List<Park> parks;

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/campground");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        CampgroundCLI application = new CampgroundCLI(dataSource);
        application.run();
    }

    public CampgroundCLI(DataSource dataSource) {
        this.menu = new Menu(System.in, System.out);
        this.rm = new ReservationManager(dataSource);
    }

    public void run() {
        displayApplicationBanner();
        mainMenu();
        return;
    }

    private void mainMenu() {
        while (true) {
            printHeading("Select a Park for Further Details");
            String choice = (String) menu.getChoiceFromOptions(getMainMenuOptions());
            if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                System.exit(0);
            } else {
                rm.setChosenPark(choice);
                campgrounds = rm.getCampgrounds();
                handleParks();
            }
        }
    }

    private String[] getMainMenuOptions() {
        parks = rm.getParks();
        String[] menuOptions = new String[parks.size() + 1];
        for (int i = 0; i < parks.size(); i++) {
            menuOptions[i] = parks.get(i).getName();
        }
        menuOptions[menuOptions.length - 1] = MAIN_MENU_OPTION_EXIT;
        return menuOptions;
    }

    private void handleParks() {
        Park selected = rm.getChosenPark();
        printHeading(selected.getName());
        System.out.println(selected.toString());
        String choice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS);
        if (choice.equals(SUB_MENU_OPTION_VIEW_CAMPGROUNDS)) {
            handleCampground();
            String newChoice = (String) menu.getChoiceFromOptions(SUB_MENU_OPTIONS_RESERVATIONS);
            if (newChoice.equals(SUB_MENU_OPTION_AVAILABLE_RESERVATION)) {
                printHeading("Search for Campground Reservation");
                handleCampground();
                handleMakeReservation();
            }
        } else if (choice.equals(SUB_MENU_OPTION_SEARCH_RESERVATIONS)) {
            //TODO this is a bonus item and not required
        } else if (choice.equals(SUB_MENU_OPTION_RETURN_TO_PREVIOUS)) {
            return;
        }
    }

    private void handleCampground() {
        printHeading(rm.getChosenPark().getName() + " Campgrounds");
        System.out.println(String.format("%-4s%-32s%-10s%-12s%s", " ", "Name", "Open", "Close", "Daily Fee"));
        for (int i = 0; i < campgrounds.size(); i++) {
            System.out.println("#" + (i + 1) + "  " + campgrounds.get(i).toString());
        }
    }

    private void handleMakeReservation() {
        String choice = rm.getUserInput("\nWhich campground (enter 0 to cancel)? ");
        int userChoice = Integer.parseInt(choice);
        if (userChoice == 0) {
            mainMenu();
        } else {
            Campground selected = campgrounds.get(userChoice - 1);
            rm.setChosenCampground(selected);
            LocalDate arrival = rm.getDateFromUser("What is the arrival date? (MM/DD/YYYY) ");
            LocalDate departure = rm.getDateFromUser("What is the departure date? (MM/DD/YYYY) ");
            long stay = ChronoUnit.DAYS.between(arrival, departure);
            if (stay <= 0 || arrival == departure) {
                System.out.println("Invalid date range, please try again.");
                handleCampground();
                handleMakeReservation();
            } else {
                List<Site> availableSites = rm.getAvailableSites(arrival, departure);
                if (availableSites.size() == 0) {
                    String[] usrOptions = new String[]{"Yes", "No"};
                    System.out.println("No available sites. Would you like to try again.");
                    String userResponse = (String) menu.getChoiceFromOptions(usrOptions);
                    if (userResponse.equalsIgnoreCase("yes")) {
                        handleCampground();
                        handleMakeReservation();
                    } else {
                        mainMenu();
                    }
                }
                printHeading("Results Matching Your Search Criteria");
                System.out.println(String.format("%-15s %-11s %-14s %-14s %-12s %-2s", "Site No.", "Max Occup.", "Accessible?", "Max RV Length", "Utility", "Cost"));

                for (Site value : availableSites) {
                    BigDecimal amount = new BigDecimal(BigInteger.ZERO, 2);
                    BigDecimal totalCost = value.getDailyFee().multiply(new BigDecimal(stay));
                    amount = amount.add(totalCost);
                    System.out.println(value.toString() + NumberFormat.getCurrencyInstance().format(amount) + "");
                }
                choice = rm.getUserInput("\nWhich site should be reserved (enter 0 to cancel)? ");
                userChoice = Integer.parseInt(choice);
                if (userChoice == 0) {
                    mainMenu();
                } else {
                    long selectedSite = rm.getChosenSite(choice);
                    handleSaveReservation(selectedSite);
                }
            }
        }
    }

    private void handleSaveReservation(long id) {
        String reservationName = rm.getUserInput("What name should the reservation be made under? ");
        System.out.println(rm.saveReservation(reservationName, id));
    }

    private void printHeading(String headingText) {
        System.out.println("\n" + headingText);
        for (int i = 0; i < headingText.length(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private void displayApplicationBanner() {
        System.out.println(" #####                                                                 ######                                       ");
        System.out.println("#     #   ##   #    # #####   ####  #####   ####  #    # #    # #####  #     #  ####   ####  #    # # #    #  #### ");
        System.out.println("#        #  #  ##  ## #    # #    # #    # #    # #    # ##   # #    # #     # #    # #    # #   #  # ##   # #    # ");
        System.out.println("#       #    # # ## # #    # #      #    # #    # #    # # #  # #    # ######  #    # #    # ####   # # #  # #      ");
        System.out.println("#       ###### #    # #####  #  ### #####  #    # #    # #  # # #    # #     # #    # #    # #  #   # #  # # #  ### ");
        System.out.println("#     # #    # #    # #      #    # #   #  #    # #    # #   ## #    # #     # #    # #    # #   #  # #   ## #    # ");
        System.out.println(" #####  #    # #    # #       ####  #    #  ####   ####  #    # #####  ######   ####   ####  #    # # #    #  ####  ");
        System.out.println();
    }
}

