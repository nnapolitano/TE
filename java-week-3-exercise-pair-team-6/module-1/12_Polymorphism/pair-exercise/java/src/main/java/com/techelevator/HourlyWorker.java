package com.techelevator;

public class HourlyWorker implements Worker {

    private double hourlyRate;
    private String firstName;
    private String lastName;


    public double getHourlyRate() {
        return hourlyRate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public HourlyWorker(String firstName, String lastName, double hourlyRate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
    }


    public double calculateWeeklyPay(int hoursWorked) {
        if (hoursWorked <= 40) {
            double basePay = hourlyRate * hoursWorked;
            return basePay;
        } else {
            double basePayHardWorker = (40 * hourlyRate);
            double otHours = (hoursWorked - 40);
            double otRate = hourlyRate * 1.5;
            double otPay = otRate * otHours;
            double totalPay = (otPay + basePayHardWorker);
            return totalPay;
        }

    }
}


