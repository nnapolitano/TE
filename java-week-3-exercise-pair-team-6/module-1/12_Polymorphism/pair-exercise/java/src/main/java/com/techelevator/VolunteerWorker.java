package com.techelevator;

public class VolunteerWorker implements Worker {

  //  private double hourlyRate;
    private String firstName;
    private String lastName;



    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public VolunteerWorker(String firstName, String lastName) {
        this.firstName=firstName;
        this.lastName=lastName;

    }


    public double calculateWeeklyPay(int hoursWorked) {
return 0;
    }

}
