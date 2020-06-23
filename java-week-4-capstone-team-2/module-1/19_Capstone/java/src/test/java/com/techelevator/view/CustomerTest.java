//package com.techelevator.view;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import java.math.BigDecimal;
//
//import static org.junit.Assert.*;
//
//public class CustomerTest {
//Customer customer;
//    @Before
//    public void setUp() throws Exception {
//        customer = new Customer();
//        customer.existingFunds = new BigDecimal("5.00");
//      //  customer. = "five";
//
//    }
//
//
//
//    @Test
//    public void getLoadedFunds() {
//        BigDecimal actual = customer.getLoadedFunds();
//        BigDecimal expected = new BigDecimal("5.00");
//        assertEquals("Customer added $5, should return 10.00", expected, actual);
//
//    }
//
//    @Test
//    public void getExistingFunds() {
//        BigDecimal actual = customer.getExistingFunds();
//        BigDecimal expected = new BigDecimal("5.00");
//        assertEquals("Customer previously added $5, should return 5.00", expected, actual);
//
//    }
//
//
//}
