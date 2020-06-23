package com.techelevator.resourceintegration;

import java.math.BigDecimal;

public abstract class Product {

    private String itemCode;
    private String itemName;
    private String itemMessage;
    private BigDecimal itemPrice;
    private int itemQuantity=5;




    public Product() {
    }

    public  Product(String itemName, BigDecimal itemPrice) {
     //  this.itemCode = getItemCode();
        this.itemName=itemName;
        this.itemPrice = itemPrice;

    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemMessage() {
        return itemMessage;
    }

    public void setItemMessage(String itemMessage) {
        this.itemMessage = itemMessage;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity-1;
    }

    @Override
    public String toString() {
        return
            " "+ itemName +
                ", Price:   $" + itemPrice +
                ", Amount Remaining:" + itemQuantity;
    }
}





