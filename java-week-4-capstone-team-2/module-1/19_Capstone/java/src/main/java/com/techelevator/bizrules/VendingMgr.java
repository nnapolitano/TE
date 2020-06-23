package com.techelevator.bizrules;

import com.techelevator.resourceintegration.Product;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class VendingMgr {

    Scanner scanner = new Scanner(System.in);

    //Map that contains the products from file
    private Map<String, Product> inventoryMap;


    //return item from map
    Product getProduct(String slot) {
        return inventoryMap.get(slot);
    }


    //Adding funds to customers wallet
    public BigDecimal loadedFunds(BigDecimal existingFunds) {

        System.out.println("Insert money (This machine ONLY accepts $1, $2, $5 and $10 bills.)");
        String moneyIn = scanner.nextLine();
        DollarBills custDollarBills = DollarBills.valueOf(moneyIn.toUpperCase());
        BigDecimal loadedFunds;


        switch (custDollarBills) {

            case ONE:
                loadedFunds = BigDecimal.ONE;
                loadedFunds = existingFunds.add(loadedFunds);
                return loadedFunds;

            case TWO:
                loadedFunds = new BigDecimal("2.00");
                loadedFunds = existingFunds.add(loadedFunds);
                return loadedFunds;


            case FIVE:
                loadedFunds = new BigDecimal("5.00");
                loadedFunds = existingFunds.add(loadedFunds);
                return loadedFunds;
            case TEN:
                loadedFunds = BigDecimal.TEN;
                loadedFunds = existingFunds.add(loadedFunds);
                return loadedFunds;
            default:
                System.out.println("Invalid amount entered - Please try again");
                break;
        }

        return existingFunds;

    }

    public BigDecimal subtractPurchasePrice(BigDecimal existingFunds, BigDecimal purchasePrice){
        BigDecimal balAfterPurch;
        balAfterPurch = existingFunds.subtract(purchasePrice);
        return balAfterPurch;

    }




}
