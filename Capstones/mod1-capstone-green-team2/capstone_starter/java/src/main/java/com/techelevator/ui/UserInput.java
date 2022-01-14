package com.techelevator.ui;

import com.techelevator.models.Food;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * <p>
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);
    private static String itemID = "";
    private static String foodName = "";

    public static String getHomeScreenOption() {


        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        switch (option) {
            case "1":
                return "display";
            case "2":
                return "purchase";
            case "3":
                return "exit";
            case "4":
                return "salesreport";
            default:
                return "";
        }

    }

    public static String getPurchaseScreenOption(BigDecimal currentTotal) {
        UserOutput.purchaseScreen(currentTotal);
        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        switch (option) {
            case "1":
                return "feed";
            case "2":
                return "select";
            case "3":
                return "finish";
            default:
                return "";

        }
    }

    public static BigDecimal getFeedMoney() {
        UserOutput.feedMoney();
        String selectedOption = scanner.nextLine().trim().toLowerCase();

        switch (selectedOption) {
            case "1":
                return BigDecimal.valueOf(1.00);
            case "2":
                return BigDecimal.valueOf(2.00);
            case "3":
                return BigDecimal.valueOf(5.00);
            case "4":
                return BigDecimal.valueOf(10.00);
            default:
                System.out.println("Please input valid amount.");
                return BigDecimal.valueOf(0.00);
        }
    }

    public static BigDecimal getPurchaseItem(List<Food> foods){
        UserOutput.itemSelection();
        BigDecimal itemPrice = new BigDecimal(0);
        String input = scanner.nextLine().toLowerCase();
        boolean foundItem = false;
        boolean soldOut = false;

        for(Food food : foods){
            if (food.getSlot().toLowerCase().equals(input)){
                if(!food.getQuantity().contains("SOLD OUT")){
                itemPrice = food.getPrice();
                foundItem = true;
                itemID = food.getSlot();
                foodName = food.getItem();
                }
                else{
                    UserOutput.displayMessage("Item is SOLD OUT!");
                    soldOut = true;
                }
            }
        }
        if(!foundItem && !soldOut){
            UserOutput.displayMessage("Item not found, returning to previous menu.");
        }
        return itemPrice;
    }

    public static String getItemID(){
        return itemID.toLowerCase();
    }
    public static String getItemName() { return foodName;}

    public static String getUserInput(){

        return scanner.nextLine();
    }
}
