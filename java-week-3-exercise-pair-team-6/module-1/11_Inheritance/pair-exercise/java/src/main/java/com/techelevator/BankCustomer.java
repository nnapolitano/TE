package com.techelevator;

import java.math.BigDecimal;
import java.util.List;

public class BankCustomer {

    private String name;
    private String address;
    private String phoneNumber;
    private List <BankAccount> listOfBankAccounts;
   private boolean isVip;

    public BankCustomer(String name, String address, String phoneNumber, List<BankAccount> listOfBankAccounts) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.listOfBankAccounts = listOfBankAccounts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BankAccount[] getAccounts() {

        return (BankAccount[]) listOfBankAccounts.toArray();
    }


    public void addAccount(BankAccount newAccount) {
        listOfBankAccounts.add(newAccount);
    }

    public boolean isVip() {
        BigDecimal totalBal= BigDecimal.ZERO;
        for (BankAccount value: listOfBankAccounts) {
            totalBal = totalBal.add(value.getBalance());
        }
        if (totalBal.compareTo(new BigDecimal("25000.00"))>= 0) {
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return "BankCustomer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", listOfBankAccounts=" + listOfBankAccounts +
                ", isVip=" + isVip +
                '}';
    }
}
