package com.techelevator.resourceintegration;

import java.math.BigDecimal;

public class Chip extends Product {


    public Chip() {
    }

    public Chip(String itemName, BigDecimal itemPrice) {
        super(itemName, itemPrice);
    }

    @Override
    public BigDecimal getItemPrice() {
        return super.getItemPrice();
    }

    @Override
    public String getItemName() {
        return super.getItemName();
    }

    @Override
    public String getItemMessage() {
        return "Crunch Crunch, Yum!";
    }

    @Override
    public String getItemCode() {
        return super.getItemCode();
    }

    @Override
    public int getItemQuantity() {
        return super.getItemQuantity();
    }



}
