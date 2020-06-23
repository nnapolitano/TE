package com.techelevator.bizrules;

import com.techelevator.resourceintegration.*;
import com.techelevator.view.*;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Purchase {
    VendingMachine vendingMachine = new VendingMachine();
    Customer customer = new Customer();

    Scanner scanner = new Scanner(System.in);

    public Purchase() {

    }

    public Product purchaseItems() throws FileNotFoundException {

        vendingMachine.printMap();
        System.out.println(customer.getMoneyInMachine());
        System.out.println("Please select a product: ");
        String custSelection = scanner.nextLine().toUpperCase();
        Product itemSelected = vendingMachine.getProductMap().get(custSelection);

        System.out.println("You selected " + itemSelected.getItemName() + ". $" + itemSelected.getItemPrice() + " has been deducted from your funds.");
     //   customer.setMoneyInMachine(itemSelected.getItemPrice());

        return itemSelected;
    }


}








