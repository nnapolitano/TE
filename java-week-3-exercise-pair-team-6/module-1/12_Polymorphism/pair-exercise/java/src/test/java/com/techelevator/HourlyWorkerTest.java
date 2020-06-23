package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HourlyWorkerTest {

    @Test
    public void calculateWeeklyPay() {
        HourlyWorker schmuck = new HourlyWorker("Ronald", "Weasly", 10);
        int rand= 50;
        Assert.assertEquals( "you fail",550, schmuck.calculateWeeklyPay(50), 0 );

    }



    @Test
    public void calculateWeeklyPay_Under_40() {
        HourlyWorker schmuck = new HourlyWorker("Ronald", "Weasly", 10);
        int rand= 10;
        Assert.assertEquals( "you fail",100, schmuck.calculateWeeklyPay(10),0 );

    }
}