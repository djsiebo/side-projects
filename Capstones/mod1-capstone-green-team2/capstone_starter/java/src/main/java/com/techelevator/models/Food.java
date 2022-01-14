package com.techelevator.models;

import java.math.BigDecimal;

public abstract class Food {

    private String slot;
    private String item;
    private BigDecimal price;
    private String quantity;

    //constructor
    public Food(String slot, String item, BigDecimal price) {
        this.slot = slot;
        this.item = item;
        this.price = price;
        this.quantity = "5";
    }

    //Getters
    public String getSlot() {
        return slot;
    }

    public String getItem() {
        return item;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public abstract String getSound();

    //Setter
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }


}
