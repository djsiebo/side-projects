package com.techelevator.Model;

public class Conversion {

    private double valueConvertFrom;
    private double valueConvertTo;
    private String typeConvertFrom;
    private String typeConvertTo;

    public double getValueConvertFrom() {
        return valueConvertFrom;
    }

    public void setValueConvertFrom(double valueConvertFrom) {
        this.valueConvertFrom = valueConvertFrom;
    }

    public double getValueConvertTo() {
        return valueConvertTo;
    }

    public void setValueConvertTo(double valueConvertTo) {
        this.valueConvertTo = valueConvertTo;
    }

    public String getTypeConvertFrom() {
        return typeConvertFrom;
    }

    public void setTypeConvertFrom(String typeConvertFrom) {
        this.typeConvertFrom = typeConvertFrom;
    }

    public String getTypeConvertTo() {
        return typeConvertTo;
    }

    public void setTypeConvertTo(String typeConvertTo) {
        this.typeConvertTo = typeConvertTo;
    }

    @Override
    public String toString() {
        return "You converted " + valueConvertFrom + " " + typeConvertFrom + " to " + valueConvertTo + " " + typeConvertTo + "!";
    }
}
