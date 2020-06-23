package com.techelevator.resourceintegration;

import java.io.File;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {

    // VendLoader vendLoader = new VendLoader().product;

    //    private Map<String, Product> itemsMap = (Map<String, Product>) vendLoader.fileLoader();

    private Map<String, Product> itemsMap = new LinkedHashMap<>();

    public VendingMachine(Map<String, Product> itemsMap) {
        this.itemsMap = itemsMap;
    }



    public Map<String, Product> getProductMap() {
        this.LoadMap();
        return productMap;
    }

    //
    public VendingMachine() {
        Map<String, Product> itemsMap = new LinkedHashMap<>();

    }

    //
    private Map<String, Product> productMap = new LinkedHashMap<>();

    public void LoadMap() {

        VendingMachine vendingMachine = new VendingMachine() {
        };
        String line;
        try (Scanner scanner = new Scanner(new File("src/main/java/com/techelevator/resources/vendingmachine.csv"))) {

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] lineArray = line.split("\\|");

                if (lineArray[3].equals("Chip")) {
                    productMap.put(lineArray[0], (new Chip(lineArray[1], new BigDecimal(lineArray[2]))));
                } else if (lineArray[3].equals("Candy")) {
                    productMap.put(lineArray[0], (new Candy(lineArray[1], new BigDecimal(lineArray[2]))));
                } else if (lineArray[3].equals("Drink")) {
                    productMap.put(lineArray[0], new Drink(lineArray[1], new BigDecimal(lineArray[2])));
                } else if (lineArray[3].equals("Gum")) {
                    productMap.put(lineArray[0], new Gum(lineArray[1], new BigDecimal(lineArray[2])));
                }
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

    }

    public void printMap() {

        this.LoadMap();

        Iterator<Map.Entry<String, Product>> itr = productMap.entrySet().iterator();

        while (itr.hasNext()) {
            Map.Entry<String, Product> entry = itr.next();
            System.out.println("Position: " + entry.getKey() +
                    " =" + entry.getValue());
        }


    }
}
