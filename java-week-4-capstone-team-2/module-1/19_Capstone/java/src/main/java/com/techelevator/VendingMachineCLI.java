package com.techelevator;

import com.techelevator.bizrules.Purchase;
import com.techelevator.resourceintegration.Product;
import com.techelevator.resourceintegration.VendLoader;
import com.techelevator.resourceintegration.VendingMachine;
import com.techelevator.view.Customer;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.math.BigDecimal;


public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String FEED_MONEY = "Feed Money";
    private static final String SELECT_PRODUCT = "Select Product";
    private static final String FINISH_TRANSACTION = "Finish Transaction";

    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private static final String[] PURCHASE_MENU_OPTIONS = {FEED_MONEY, SELECT_PRODUCT, FINISH_TRANSACTION};

    private BigDecimal remainingFunds;

    VendingMachine vendingMachine = new VendingMachine();
    Customer customer = new Customer();
    Purchase purchase = new Purchase();

    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }


    public void run() throws FileNotFoundException {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                vendingMachine.printMap();


            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {

                purchaseOptions();

            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                System.exit(0);
            }
        }
    }


    public void purchaseOptions () throws FileNotFoundException {

        while (true) {
            String choice = (String) menu.getPurchaseChoiceFromOptions(PURCHASE_MENU_OPTIONS);


            if (choice.equals(FEED_MONEY)) {
                customer.setMoneyInMachine();
                customer.getMoneyInMachine();


            } else if (choice.equals(SELECT_PRODUCT)) {
                Product itemSelected = purchase.purchaseItems();


                BigDecimal itemPrice = (itemSelected.getItemPrice());
                customer.setMoneyInMachine(itemPrice);


            }

//
            if (choice.equals(FINISH_TRANSACTION)) {
                break;
            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu(System.in, System.out);
        Customer customer = new Customer();
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        VendLoader.fileLoader();

        cli.run();

    }
}

