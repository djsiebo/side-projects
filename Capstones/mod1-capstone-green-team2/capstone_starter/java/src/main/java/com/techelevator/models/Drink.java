package com.techelevator.models;

import java.math.BigDecimal;

public class Drink extends Food{

    public Drink(String slot, String item, BigDecimal price) {
        super(slot, item, price);
    }

    //getter
    public String getSound(){
        return "Glug Glug, Yum!";
    }
}
