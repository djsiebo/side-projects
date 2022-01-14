package com.techelevator.application;

import com.techelevator.models.*;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class VendingMachine {
    public BigDecimal currentTotal = BigDecimal.valueOf(0);
    public static BigDecimal totalSales = BigDecimal.valueOf(0);

    public void run() {
        boolean isDone = false;


        //creating a data structure and scanner for our item list
        List<Food> foods = readFromFile();

        while (true) {

            boolean isFinishedPurchasing = false;
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if (choice.equals("display")) {
                // display the vending machine slots
                UserOutput.inventory(foods);
            } else if (choice.equals("purchase")) {
                while (!isFinishedPurchasing) {
                    String purchaseChoice = UserInput.getPurchaseScreenOption(currentTotal);
                    if (purchaseChoice.equals("feed")) {
                        boolean isDoneMoney = false;
                        while (!isDoneMoney) {
                            BigDecimal addMoney = UserInput.getFeedMoney();
                            currentTotal = Math.addFeedMoney(currentTotal, addMoney);
                            UserOutput.areYouFinished();
                            String doneMoneyChoice = UserInput.getUserInput();
                            if (doneMoneyChoice.trim().toLowerCase().contains("y")) {
                                isDoneMoney = true;
                            }
                        }
                    } else if (purchaseChoice.equals("select")) {

                        //UserInput.select;
                        // Build logic for item selection by slot number and make adjustments to quantity
                        // Build logic for changing current money value
                        // 0 quantity has display SOLD OUT
                        // Log each time product is selected date, time, product name, product slot, amount, new amount
                        UserOutput.inventory(foods);
                        BigDecimal localPrice = UserInput.getPurchaseItem(foods);
                        System.out.println();
                        currentTotal = Math.purchaseMath(currentTotal, localPrice);
                        String itemID = UserInput.getItemID();
                        boolean purchasePossible = Math.isPurchasePossible();

                        Math.itemDecrement(currentTotal, foods, itemID, purchasePossible);


                    } else if (purchaseChoice.equals("finish")) {

                        // UserOutput.finish;
                        // Build logic for UserOutput and calculations
                        // Return coins using lower number of coins
                        // Create log entry date, time, give change, amount, $0.00
                        isFinishedPurchasing = true;
                        currentTotal = Math.giveChange(currentTotal);
                    }

                }
            } else if (choice.equals("salesreport")) {
                SalesReport.adjustSalesReport(generateSalesReport(foods), totalSales);
            } else if (choice.equals("exit")) {
                UserOutput.displayMessage("Goodbye!");
                break;
            }
        }
    }

    private List<Food> readFromFile() {
        List<Food> localFoods = new ArrayList<>();
        File file = new File("vendingmachine.csv");
        try (Scanner fileScanner = new Scanner(file)) {

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split("\\|");
                String slot = lineArray[0];
                String item = lineArray[1];
                BigDecimal price = new BigDecimal(lineArray[2]);


                String type = lineArray[3];

                if (type.toLowerCase().startsWith("chi")) {
                    Chips chips = new Chips(slot, item, price);
                    localFoods.add(chips);
                } else if (type.toLowerCase().startsWith("can")) {
                    Candy candy = new Candy(slot, item, price);
                    localFoods.add(candy);
                } else if (type.toLowerCase().startsWith("dri")) {
                    Drink drink = new Drink(slot, item, price);
                    localFoods.add(drink);
                } else if (type.toLowerCase().startsWith("gum")) {
                    Gum gum = new Gum(slot, item, price);
                    localFoods.add(gum);
                } else {
                    UserOutput.displayMessage("We don't sell that item in this vending machine!");
                    System.exit(1);
                }
            }
        } catch (FileNotFoundException e) {
            UserOutput.displayMessage("Error writing file!");
        }
        return localFoods;
    }

    public static List<Sales> generateSalesReport(List<Food> foods) {
        List<Sales> localSalesReport = new ArrayList<>();
        for (Food food : foods) {
            Sales sale = new Sales(food.getItem(), 0);
            localSalesReport.add(sale);
        }
            for (Food food : foods) {
                int quantitySold = 0;
                if (!food.getQuantity().contains("5") && !food.getQuantity().contains("SOLD OUT")) {
                    quantitySold = 5 - Integer.parseInt(food.getQuantity());

                } else if (food.getQuantity().contains("SOLD OUT")) {
                    quantitySold = 5;
                }
                totalSales = totalSales.add((food.getPrice().multiply(BigDecimal.valueOf(quantitySold))));

                for (Sales sale : localSalesReport) {
                    if (sale.getName().contains(food.getItem()) && quantitySold != 0) {
                        int newQuantitySold = sale.getQuantitySold() + quantitySold;
                        sale.setQuantitySold(newQuantitySold);
                    }
                }
            }
        return localSalesReport;
    }
}





