package com.techelevator.resourceintegration;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VendLoader {

  //  private Map<String, Product> product;
  //  VendLoader product;

    public VendLoader() {
    }

    public VendLoader(Map<String, Product> mapOfProducts) {
}

  //  VendingMachine vendingMachine = new VendingMachine();


    public static VendingMachine fileLoader() {
        Map<String, Product> product = new HashMap<>();

        String line;
        try (Scanner scanner = new Scanner(new File("src/main/java/com/techelevator/resources/vendingmachine.csv"))) {

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] lineArray = line.split("\\|");

                if (lineArray[3].equals("Chip")) {
                    product.put(lineArray[0], new Chip(lineArray[1], new BigDecimal(lineArray[2])));
                } else if (lineArray[3].equals("Candy")) {
                    product.put(lineArray[0], new Candy(lineArray[1], new BigDecimal(lineArray[2])));
                } else if (lineArray[3].equals("Drink")) {
                    product.put(lineArray[0], new Drink(lineArray[1], new BigDecimal(lineArray[2])));
                } else if (lineArray[3].equals("Gum")) {
                    product.put(lineArray[0], new Gum(lineArray[1], new BigDecimal(lineArray[2])));
                }
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
       return new VendingMachine(product);



    }




}
