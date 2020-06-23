package com.techelevator.resourceintegration;

import java.math.BigDecimal;

public class Candy extends Product {

      public Candy() {
    }

    public Candy( String itemName, BigDecimal itemPrice) {
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
        return
                ("Munch Munch, Yum!");
    }

    @Override
    public String getItemName() {
        return super.getItemName();
    }

    @Override
    public BigDecimal getItemPrice() {
        return super.getItemPrice();
    }

    @Override
    public void setItemPrice(BigDecimal itemPrice) {
        super.setItemPrice(itemPrice);
    }
}
