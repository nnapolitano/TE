package com.techelevator.bizrules;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class LogWriterTest {
LogWriter logWriter;
    Scanner scanner = new Scanner(
            new File("src/main/java/com/techelevator/resources/log.txt"));

    public LogWriterTest() throws FileNotFoundException {
    }

    @Before
    public void setUp() throws Exception {
        logWriter = new LogWriter("Test Confirmed");

    }

    @Test
    public void logWriter() {
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }
}