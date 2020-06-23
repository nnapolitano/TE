package com.techelevator.biz;

import com.techelevator.entity.Campground;
import com.techelevator.entity.Park;
import com.techelevator.biz.jdbc.JDBCCampgroundDAO;
import com.techelevator.biz.jdbc.JDBCParkDAO;
import com.techelevator.biz.jdbc.JDBCReservationDAO;
import com.techelevator.biz.jdbc.JDBCSiteDAO;
import com.techelevator.entity.*;
import javax.sql.DataSource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ReservationManager {

    private ParkDAO parkDAO;
    private CampgroundDAO campgroundDAO;
    private ReservationDAO reservationDAO;
    private SiteDAO siteDAO;
    private List<Park> parks;
    private Park chosenPark;
    private List<Campground> campgrounds;
    private Campground chosenCampground;
    private List<Site> availableSites;
    private LocalDate fromDate;
    private LocalDate toDate;


public ReservationManager(DataSource dataSource) {
    parkDAO = new JDBCParkDAO(dataSource);
    reservationDAO = new JDBCReservationDAO(dataSource);
    campgroundDAO = new JDBCCampgroundDAO(dataSource);
    siteDAO = new JDBCSiteDAO(dataSource);

    parks = parkDAO.getAllParks();
}

    public List<Park> getParks() {
        return parks;
    }

    public List<Campground> getCampgrounds() {
        campgrounds = campgroundDAO.getCampgroundByParkId(chosenPark.getParkId());
        return campgrounds;
    }

    public Park getChosenPark() {
        return chosenPark;
    }

    public void setChosenPark(String choice) {
        for (Park value : parks) {
            if (value.getName().equals(choice))
                this.chosenPark = value;
        }
    }

    public void setChosenCampground(Campground chosenCampground) {
        this.chosenCampground = chosenCampground;
    }

    public List<Site> getAvailableSites(LocalDate fromDate, LocalDate toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        availableSites = reservationDAO.getAvailableSites(chosenCampground.getCampgroundId(), fromDate, toDate);
        return availableSites;
    }

    public long getChosenSite(String selectedSite) {
    long siteId = 0;
    for(Site value : availableSites) {
        if(selectedSite.equals(String.valueOf(value.getSiteNumber()))) {
            siteId = value.getSiteId();
        }
    }
    return siteId;
    }

    public String saveReservation(String reservationName, Long siteId) {
        Reservation reservation = new Reservation();
        reservation.setSiteId(siteId);
        reservation.setName(reservationName);
        reservation.setFromDate(fromDate);
        reservation.setToDate(toDate);
        reservation.setDateCreated(LocalDate.now());
        reservationDAO.makeReservation(reservation);

        return "\nThe reservation has been made and the confirmation id is " + reservation.getReservationId();
    }

    public LocalDate getDateFromUser(String prompt) {
        LocalDate dateFromUser = null;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
        while (dateFromUser == null) {
            try {
                String date = getUserInput(prompt);
                dateFromUser = LocalDate.parse(date, dateFormat);
            } catch (DateTimeParseException er) {
                System.out.println("Invalid date");
            }
        }
        return dateFromUser;
    }

    public String getUserInput(String prompt) {
        String userInput = "";
        Scanner scanner = new Scanner(System.in);
        while (userInput.isEmpty()) {
            System.out.print(prompt + " >>> ");
            userInput = scanner.nextLine();
        }
        return userInput;
    }
}
