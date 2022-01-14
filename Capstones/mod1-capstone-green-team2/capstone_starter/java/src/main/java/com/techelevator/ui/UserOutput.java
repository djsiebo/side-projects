package com.techelevator.ui;

import com.techelevator.models.Food;


import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage(String message)
    {
        System.out.println(message);
    }

    public static void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();

        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("1) Display Vending Machine Items");
        System.out.println("2) Purchase");
        System.out.println("3) Exit");

        System.out.println();
        System.out.print("Please select an option: ");
    }

    public static void inventory(List<Food> foods)
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Inventory");
        System.out.println("***************************************************");
        System.out.println();
        System.out.format("%-6s%-25s%-15s%-15s\n", "Slot", "Item", "Price", "Stock");
        System.out.println("___________________________________________________");
        for(Food food : foods){
            System.out.format("%-6s%-25s%-15s%-15s\n", food.getSlot(), food.getItem(),
                    returnMoney(food.getPrice()), food.getQuantity());
        }
    }

    public static void purchaseScreen(BigDecimal currentTotal) {

        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Purchasing");
        System.out.println("***************************************************");
        System.out.println();

        System.out.println("1) Feed Money");
        System.out.println("2) Select Product");
        System.out.println("3) Finish Transaction");
        System.out.println();
        reportCurrentTotal(currentTotal);

    }

    public static void feedMoney() {

        System.out.println();
        System.out.println("***************************************************");
        System.out.println("          Feed Money Into Vending Machine");
        System.out.println("***************************************************");
        System.out.println();

            System.out.println("How much money would you like to input?");
            System.out.println("This vending machine accepts $1.00, $2.00, $5.00, and $10.00 bills.");

            System.out.println("1) $1.00");
            System.out.println("2) $2.00");
            System.out.println("3) $5.00");
            System.out.println("4) $10.00");
    }

    public static void itemSelection() {
        System.out.println("Please select a slot with an item you would like to vend: ");

    }

    public static String returnMoney(BigDecimal money) {
        return NumberFormat.getCurrencyInstance().format(money);
    }

    public static void purchaseMessage(Food food, BigDecimal currentTotal){
        System.out.println("You purchased " + food.getItem()+ "! It costs " + UserOutput.returnMoney(food.getPrice()) + "!");
        System.out.println(food.getSound());
        reportCurrentTotal(currentTotal);
    }

    public static void noMoneyMessage(){
        System.out.println("You don't have enough money!");
    }

    public static void reportCurrentTotal(BigDecimal currentTotal){
        System.out.println("Your new total is " + UserOutput.returnMoney(currentTotal) + ".\n");
    }

    public static void reportCurrentChange(BigDecimal currentTotal){
        System.out.println("Your total change is " + UserOutput.returnMoney(currentTotal) + ".");
    }

    public static void returnCoins(int numberOfQuarters, int numberOfDimes, int numberOfNickels){
        if (numberOfDimes != 0 || numberOfNickels != 0 || numberOfQuarters != 0) {

            System.out.println("You have received: ");
            if (numberOfQuarters > 0) {
                System.out.println(numberOfQuarters + " quarter(s)");
            }
            if (numberOfDimes > 0) {
                System.out.println(numberOfDimes + " dime(s)");
            }
            if (numberOfNickels > 0) {
                System.out.println(numberOfNickels + " nickel(s)");
            }

        } else {
            System.out.println("No change has been dispensed!");
        }
        System.out.println("Have a great day!");
    }

    public static void purchaseImpossible(){
        System.out.println("Purchase was not possible!");
    }

    public static void areYouFinished(){
        System.out.println("Are you finished? (y/n) ");
    }

    public static void printSalesReport() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("              PRINTING SALES REPORT");
        System.out.println("***************************************************");
        System.out.println();
    }
}
