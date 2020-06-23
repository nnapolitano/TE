package com.techelevator;

import java.math.BigDecimal;

public class BankAccount {

    private BigDecimal balance;
    private String accountNumber;

    public BankAccount(BigDecimal balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public BankAccount() {
        balance = BigDecimal.ZERO;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal deposit(BigDecimal amountToDeposit) {
        balance = balance.add(amountToDeposit);
        return balance;
    }


    public BigDecimal withdraw(BigDecimal amountToWithdraw) {
        balance = balance.subtract(amountToWithdraw);
        return balance;
    }

    public void transfer(BankAccount destinationAccount, BigDecimal transferAmount) {
        // if (balance.compareTo(transferAmount) >= 0) {} // ****how about this?*****
    withdraw(transferAmount);
    destinationAccount.deposit(transferAmount);
    }


    @Override
    public String toString() {
        return "BankAccount{" +
                "balance=" + balance +
                ", accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
