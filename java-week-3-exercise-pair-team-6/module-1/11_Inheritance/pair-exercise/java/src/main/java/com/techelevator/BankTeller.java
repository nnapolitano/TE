package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankTeller {

    public static void main(String[] args) {
        BankTeller teller = new BankTeller();
        System.out.println(teller.testCustomer());

    }

    public BankCustomer testCustomer() {

        BankAccount ba1 = new BankAccount();
        BankAccount ba2 = new BankAccount(new BigDecimal("10.0"), "123");

        CheckingAccount ca1 = new CheckingAccount();
        CheckingAccount ca2 = new CheckingAccount(new BigDecimal("20"), "456");

        SavingsAccount sav1 = new SavingsAccount();
        SavingsAccount sav2 = new SavingsAccount(new BigDecimal("140"), "789");

        //this tests withdrawl methods:
/*
        ba2.withdraw(new BigDecimal(5));
        ca2.withdraw(new BigDecimal(5));
        sav2.withdraw(new BigDecimal(5));*/

//this tests deposit methods
//        ba2.deposit(new BigDecimal(5));
//////        ca2.deposit(new BigDecimal(5));
//////        sav2.deposit(new BigDecimal(5));


// this tests the transfer method:

        ba2.transfer(ba1, new BigDecimal("3"));
        ca2.transfer(ca1, new BigDecimal("3"));
        sav2.transfer(sav1, new BigDecimal("3"));


        List<BankAccount> custOneAccts = new ArrayList<>();
        custOneAccts.add(ba1);
        custOneAccts.add(ba2);
        custOneAccts.add(ca1);
        custOneAccts.add(ca2);
        custOneAccts.add(sav1);
        custOneAccts.add(sav2);


        BankCustomer cust1 = new BankCustomer("bob", "123 main st",
                "5555555555", custOneAccts);


        return cust1;


    }


}
