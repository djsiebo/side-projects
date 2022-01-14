package com.techelevator.Math;

public class TempMath {

    public static double farToCel(double temp) {
        double convertedTemp = (temp - 32) * (5.0/9.0);
        return convertedTemp;
    }
}
