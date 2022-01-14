package com.techelevator.Console;

import java.util.Scanner;

public class Input {

    Scanner input = new Scanner(System.in);

    public String getString() {
        return input.nextLine();
    }

    public int getInt() {
        int intInput = 0;
        try {
            intInput = Integer.parseInt(input.nextLine());
            return intInput;
        } catch (NumberFormatException e) {
            return 999; // This will be sent back to reload main menu
        }

    }

    public double getDouble() {
        double doubInput = 0.0;
        while (true) {
            try {
                doubInput = Double.parseDouble(input.nextLine());
                return doubInput;
            } catch (NumberFormatException e) {
                System.out.printf("Invalid entry! Please re-enter! ");
            }
        }
    }
}
