package com.techelevator.bizrules;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogWriter {

    public LogWriter(String action) throws IOException {

        try (
                PrintWriter pw = new PrintWriter(
                        new FileWriter("src/main/java/com/techelevator/resources/log.txt", true));
        ) {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
            Date date = new Date(System.currentTimeMillis());
            pw.println("Accessed on " + formatter.format(date) + " "+action);
        }


    }
}
