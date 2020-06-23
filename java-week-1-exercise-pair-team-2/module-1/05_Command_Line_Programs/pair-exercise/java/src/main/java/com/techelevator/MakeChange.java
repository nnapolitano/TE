package com.techelevator;

import java.util.*;
/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 $ java MakeChange
 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */


public class MakeChange {
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
MakeChange makeChange = new MakeChange();
makeChange.ChangeAmount();

    }

    public void ChangeAmount() {
        String billAmount;
        String tenderedAmount;
        double returnedChange;

        System.out.print("Please enter the amount of the bill: $");
        billAmount = scanner.nextLine();
        double billPrice = Double.parseDouble(billAmount);

        System.out.print("Please enter the amount tendered: $");
        tenderedAmount = scanner.nextLine();
        double tenderedMoney = Double.parseDouble(tenderedAmount);

        returnedChange = tenderedMoney - billPrice;

        System.out.println("The change required is $" + returnedChange);


    }


}
