package com.techelevator;

import java.math.BigDecimal;

public class CheckingAccount extends BankAccount {

    //Subclasses must redefine parent Constructors
    public CheckingAccount() {
        super();
    }

    public CheckingAccount(BigDecimal balance, String accountNumber) {
        super(balance, accountNumber);
    }


    @Override
    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        BigDecimal tempBalance = getBalance().subtract(amountToWithdraw);
        BigDecimal odpLimit = new BigDecimal("-100.00");
        BigDecimal odpFee = new BigDecimal("10.00");

        //perhaps a useful function for us to use later on:
        //The java.math.BigDecimal.doubleValue() is an in-built function
        // which converts the BigDecimal object to a double.
        // Thus we don't need to use compareTo(), for example:
        // if(getBalance().doubleValue >= amountToWithdraw.doubleValue()) {

        if(getBalance().compareTo(amountToWithdraw) > 0.0) {
            super.withdraw(amountToWithdraw);
        }
        else if(tempBalance.compareTo(odpLimit) >= 0) {
            return (tempBalance.subtract(odpFee));
        }
            return getBalance();
    }

}
