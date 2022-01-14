package com.techelevator.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sales {

    private String name;
    private int quantitySold;

    public Sales(String name, int quantitySold) {
        this.name = name;
        this.quantitySold = quantitySold;
    }

    public String getName() {
        return name;
    }

    public int getQuantitySold() {
        return quantitySold;
    }

    public void setQuantitySold(int quantitySold) {
        this.quantitySold = quantitySold;
    }
}
