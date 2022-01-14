package com.techelevator.models;

import java.math.BigDecimal;

public class Gum extends Food{

    public Gum(String slot, String item, BigDecimal price) {
        super(slot, item, price);
    }

    //getter
    public String getSound(){
        return "Chew Chew, Yum!";
    }
}
