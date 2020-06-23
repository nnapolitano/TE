package com.techelevator.view;

import com.techelevator.bizrules.DollarBills;
import com.techelevator.bizrules.VendingMgr;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.techelevator.bizrules.DollarBills.*;



public class Customer {
    VendingMgr vendingMgr = new VendingMgr();
    BigDecimal moneyInMachine = new BigDecimal("0.00");


   public BigDecimal getMoneyInMachine(){
       return moneyInMachine;
    }



    public void setMoneyInMachine() {
       moneyInMachine=vendingMgr.loadedFunds(moneyInMachine);
    }

    public void setMoneyInMachine(BigDecimal itemSelectedPrice){

       moneyInMachine =   vendingMgr.subtractPurchasePrice(moneyInMachine, itemSelectedPrice);
        System.out.println("You have $"+ moneyInMachine +" remaining");

   }

    public void printMoneyInMachine() {
        System.out.println("There is $"+moneyInMachine);
    }

//hello
    }




