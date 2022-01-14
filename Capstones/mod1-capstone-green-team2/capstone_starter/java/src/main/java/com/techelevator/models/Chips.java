package com.techelevator.models;

import java.math.BigDecimal;

public class Chips extends Food{

    //constructor

    public Chips(String slot, String item, BigDecimal price) {
        super(slot, item, price);
    }

    @Override
    public String getSound(){
        return "Crunch Crunch, Yum!";
    }
}
