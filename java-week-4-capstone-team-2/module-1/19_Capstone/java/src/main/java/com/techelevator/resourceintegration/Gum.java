package com.techelevator.resourceintegration;

import java.math.BigDecimal;

public class Gum extends Product {
    public Gum() {
    }

    public Gum(String itemName, BigDecimal itemPrice) {
        super( itemName, itemPrice);
    }

    @Override
    public String getItemMessage() {
        return "Chew Chew, Yum!";
    }


    public String getItemCode() {
        return null;
    }

    public String getItemName() {
        return null;
    }

    public BigDecimal getItemPrice() {
        return null;
    }

    public int getItemQuantity() {
        return 0;
    }
}
