package com.techelevator;

import org.junit.*;

import static org.junit.Assert.*;

public class KataStringCalculatorTest {

    private KataStringCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new KataStringCalculator();
    }

    @Test
    public void addNull() {
        String numbers = "";
        int actual = calculator.add(numbers);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void addOne() {
        String numbers = "1";
        int actual = calculator.add(numbers);
        int expected = 1;
        assertEquals(expected, actual);
    }


    @Test
    public void addOnePlusTwo() {
        String numbers = "1,2";
        int actual = calculator.add(numbers);
        int expected = 3;
        assertEquals(expected, actual);
    }


    @Test
    public void addOnePlusTwoDelimterNewLine() {
        String numbers = "1\n2";
        int actual = calculator.add(numbers);
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void addOnePlusTwoDelimiterNlAndComma() {
        String numbers = "1,2\n3";
        int actual = calculator.add(numbers);
        int expected = 6;
        assertEquals(expected, actual);
    }



    @Test
    public void addMany() {
        String numbers = "0,1,2,3,4,5,6,7,8,9";
        int actual = calculator.add(numbers);
        int expected = 45;
        assertEquals(expected, actual);
    }

    @Test
    public void bonusDelimiters() {
        String numbers = "//;\\n1;2";
        int actual = calculator.add(numbers);
        int expected = 3;
        assertEquals(expected, actual);
    }
    @Test
    public void bonusDelimitersTwo() {
        String numbers = "//!\\n4!9";
        int actual = calculator.add(numbers);
        int expected = 13;
        assertEquals(expected, actual);
    }

}
