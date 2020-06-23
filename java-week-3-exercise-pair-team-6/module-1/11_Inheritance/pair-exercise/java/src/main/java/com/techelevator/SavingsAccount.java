package com.techelevator;

import java.math.BigDecimal;

public class SavingsAccount extends BankAccount {

    //Subclasses must redefine parent Constructors
    public SavingsAccount() {
        super();
    }

    public SavingsAccount(BigDecimal balance, String accountNumber) {
        super(balance, accountNumber);
    }


    @Override
    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        //   BigDecimal tempBalance = getBalance().subtract(amountToWithdraw);
        BigDecimal savOdpLimit = new BigDecimal("150.00");
        BigDecimal savOdpFee = new BigDecimal("2.00");


        if (((getBalance()).subtract(amountToWithdraw)).compareTo(BigDecimal.ZERO) >= 0) {

            if ((getBalance().compareTo(savOdpLimit) >= 0)) {
                super.withdraw(amountToWithdraw);
            }

            if (getBalance().compareTo(savOdpLimit) < 0) {
                super.withdraw(amountToWithdraw.add(savOdpFee));            }
        }
    return getBalance();
    }
}
