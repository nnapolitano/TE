package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VolunteerWorkerTest {
    private VolunteerWorker helper;

    @Before
    public void setUp() throws Exception {
        helper = new VolunteerWorker("Ash", "Ketchum");
    }


    @Test
    public void calculateWeeklyPay() {
        int rand= 50;
        assertEquals("you fail", 0, helper.calculateWeeklyPay(50), 0.0);
    }
}