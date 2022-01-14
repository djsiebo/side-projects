package com.techelevator.Console;

public class Output {

    public static void print(String string) {
        System.out.println(string);
    }
    public static void welcome() {
        br();
        System.out.println("**************************************************************");
        System.out.println("*******  Welcome to the Mediocre Conversion Software!  *******");
        System.out.println("**************************************************************");
        br();
        System.out.println("What type of conversion do you need to do?");
        System.out.println("------------------------------------------");
        System.out.println("| 1) Temperature                         |");
        System.out.println("| 2) Weight                              |");
        System.out.println("| 3) Currency                            |");
        System.out.println("| 4) Liquid                              |");
        System.out.println("| 0) Stop                                |");
        System.out.println("------------------------------------------");
        System.out.printf("To select, enter the number corresponding to your choice: ");

    }

    public static void temperature() {
        br();
        System.out.println("**************************************************************");
        System.out.println("*******         Mediocre Temperature Conversion        *******");
        System.out.println("**************************************************************");
        br();
        System.out.println("What is your starting unit of measurement?");
        System.out.println("------------------------------------------");
        System.out.println("| 1) Fahrenheit (F)                      |");
        System.out.println("| 2) Celsius (C)                         |");
        System.out.println("| 3) Kelvin (K)                          |");
        System.out.println("| 0) Stop                                |");
        System.out.println("------------------------------------------");
        System.out.printf("To select, enter the number corresponding to your choice: ");
    }

    public static void br() {
        System.out.println("");
    }

    public static void invalidInput() {
        System.out.printf("\nInvalid input! Please try again!");
    }
}
