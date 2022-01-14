package com.techelevator.Application;

import com.techelevator.Console.Output;
import com.techelevator.Console.Input;
import com.techelevator.Math.TempMath;

import java.util.concurrent.TimeUnit;

public class Converter {

    Input input = new Input();
    Output display = new Output();

    public void run() {
        double doubInput = 0;
        int mainMenuInput = 0;

        while (true) {
            display.welcome();
            mainMenuInput = input.getInt();
            switch (mainMenuInput) {
                case 1:
                    // Temperature
                    int tempOption = 0;
                    display.temperature();
                    tempOption = input.getInt();
                    String tempType = "";
                    switch(tempOption) {
                        case 1:
                            tempType = "fahr";
                        case 2:
                            tempType = "cel";
                        case 3:
                            tempType = "kel";
                        default:
                            display.print("\nInvalid entry! Reloading temperature menu!");
                            try {
                                TimeUnit.SECONDS.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                    }

                    doubInput = input.getDouble();
                    System.out.println(TempMath.farToCel(doubInput));

                    break;
                case 2:
                    // Weight
                    display.print("I bet you'd like to do that, huh?");
                    break;
                case 3:
                    // Currency
                    display.print("I bet you'd like to do that, huh?");
                    break;
                case 4:
                    // Liquids
                    display.print("I bet you'd like to do that, huh?");
                    break;
                case 0:
                    // Stop
                    System.out.println("\nThanks! Have a great day.");
                    System.exit(0);
                default:
                    display.print("\nInvalid entry! Reloading main menu!");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

            }
        }
    }
}
