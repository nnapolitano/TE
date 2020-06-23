package com.techelevator;

public class SalaryWorker implements Worker {

    private double annualSalary;
    private String firstName;
    private String lastName;


    public double getAnnualSalary() {
        return annualSalary;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public SalaryWorker(String firstName, String lastName, double annualSalary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
    }


    public double calculateWeeklyPay(int hoursWorked) {
        return annualSalary / 52;
    }
}
