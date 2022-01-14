package com.techelevator.models;

import java.math.BigDecimal;

public class Candy extends Food{

    //constructor

    public Candy(String slot, String item, BigDecimal price) {
        super(slot, item, price);
    }

    //getters
    public String getSound(){
        return "Munch Munch, Yum!";
    }
}
