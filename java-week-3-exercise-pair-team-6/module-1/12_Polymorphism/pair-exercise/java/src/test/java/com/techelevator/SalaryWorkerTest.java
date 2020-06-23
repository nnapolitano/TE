package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalaryWorkerTest {

    @Test
    public void calculateWeeklyPay() {
        SalaryWorker manager = new SalaryWorker("Bob", "Ross", 50000);
        int rand= 50;
        double weeklyPay = (50000/52);
        Assert.assertEquals( "you fail",weeklyPay, manager.calculateWeeklyPay(50), 1 );

    }
}