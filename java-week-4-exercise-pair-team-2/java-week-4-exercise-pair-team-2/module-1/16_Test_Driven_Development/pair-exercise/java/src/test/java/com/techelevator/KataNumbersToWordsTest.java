package com.techelevator;

import org.junit.*;

import static org.junit.Assert.*;

public class KataNumbersToWordsTest {
    private KataNumbersToWords words;

    @Before
    public void setUp() throws Exception {
        words = new KataNumbersToWords();
    }
    @Test
    public void numberNegativeDigitNumber() {
        String expected = "negative one";
        String actual = words.kataNumbers(-1);
        assertEquals(expected, actual);
    }

    @Test
    public void numberOneDigitNumber() {
        String expected = "zero";
        String actual = words.kataNumbers(0);
        assertEquals(expected, actual);
    }

    @Test
    public void numberTwoDigitNumber() {
        String expected = "fourteen";
        String actual = words.kataNumbers(14);
        assertEquals(expected, actual);
    }

    @Test
    public void numberThreeDigitNumber() {
        String expected = "one hundred nine";
        String actual = words.kataNumbers(109);
        assertEquals(expected, actual);
    }

    @Test
    public void numberFourDigitEZNumber() {
        String expected = "one thousand";
        String actual = words.kataNumbers(1000);
        assertEquals(expected, actual);
    }

    @Test
    public void numberFourDigitNumber() {
        String expected = "one thousand two hundred six";
        String actual = words.kataNumbers(1206);
        assertEquals(expected, actual);
    }

    @Test
    public void numberFiveDigitNumber() {
        String expected = "fourteen thousand";
        String actual = words.kataNumbers(14000);
        assertEquals(expected, actual);
    }

    @Test
    public void numberSixDigitNumber() {
        String expected = "one hundred thousand";
        String actual = words.kataNumbers(100000);
        assertEquals(expected, actual);
    }

    @Test
    public void numberBig() {
        String expected = "one hundred thousand three hundred twelve";
        String actual = words.kataNumbers(100312);
        assertEquals(expected, actual);
    }


}
