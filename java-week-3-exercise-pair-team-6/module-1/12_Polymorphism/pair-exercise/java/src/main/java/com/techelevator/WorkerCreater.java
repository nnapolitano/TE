package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class WorkerCreater {
    public static void main(String[] args) {

/*
      SalaryWorker manager = new SalaryWorker("Bob", "Ross", 50000);
      HourlyWorker schmuck = new HourlyWorker("Ronald", "Weasly", 10);
      VolunteerWorker helper = new VolunteerWorker("Ash","Ketchum");

        employeeList.add(manager);
        employeeList.add(schmuck);
        employeeList.add(helper);
*/

        List<Worker> employeeList  = new ArrayList<>();

        System.out.println("Employee                                              Hours Worked                 Pay");
        System.out.println("======================================================================================");
        int payCounter=0;
        int hourCounter=0;
        int workerHoursWorked=0;

        for(Worker i: employeeList) {
            System.out.print(i.getLastName() + ", " + i.getFirstName() + "  " + workerHoursWorked);
            System.out.println("     "   +  i.calculateWeeklyPay(workerHoursWorked));
            payCounter+=i.calculateWeeklyPay(workerHoursWorked);
            hourCounter+=workerHoursWorked;
        }
        System.out.println("total pay: "+ payCounter);
        System.out.println("total hours: "+ hourCounter);

    }
}
