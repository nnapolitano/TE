package com.techelevator.resourceintegration;

import java.math.BigDecimal;

public class Drink extends Product {

    public Drink() {

    }

    public Drink( String itemName, BigDecimal itemPrice) {
        super(itemName, itemPrice);
    }

    @Override
    public int getItemQuantity() {
        return super.getItemQuantity();
    }

    @Override
    public String getItemCode() {
        return super.getItemCode();
    }

    @Override
    public String getItemMessage() {
        return "Glug Glug, Yum!";
    }

    @Override
    public String getItemName() {
        return super.getItemName();
    }

    @Override
    public BigDecimal getItemPrice() {
        return super.getItemPrice();
    }


}