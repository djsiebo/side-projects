package com.techelevator.application;

import com.techelevator.models.Food;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Math {


    private static boolean isDone;
    private static Scanner scannerInput = new Scanner(System.in);
    private static boolean purchasePossible = false;
    private static Logger logger = new Logger("log.txt");

    public static BigDecimal addFeedMoney(BigDecimal currentTotal, BigDecimal addMoney) {

            currentTotal = currentTotal.add(addMoney);

            UserOutput.reportCurrentTotal(currentTotal);
            logger.write(logger.getDateTime() + " FEED MONEY " + UserOutput.returnMoney(addMoney) + " " + UserOutput.returnMoney(currentTotal));

        return currentTotal;
    }

    public static BigDecimal purchaseMath(BigDecimal currentTotal, BigDecimal localPrice) {
        BigDecimal tempTotal = currentTotal;
        if (localPrice.compareTo(currentTotal) == 1) {
            UserOutput.noMoneyMessage();
            purchasePossible = false;
        } else {
            if (!localPrice.equals(0)) {
                purchasePossible = true;
                currentTotal = currentTotal.subtract(localPrice);

                logger.write(logger.getDateTime() + " " + UserInput.getItemName() + " " + UserInput.getItemID().toUpperCase()  + " " + UserOutput.returnMoney(tempTotal) + " " + UserOutput.returnMoney(currentTotal));
            }
        }
        return currentTotal;
    }

    public static int itemDecrement(BigDecimal currentTotal, List<Food> foods,String itemID, boolean purchasePossible) {
       int quant = 0;
        if (purchasePossible) {
            for (Food food : foods) {
                if (food.getSlot().toLowerCase().equals(itemID.toLowerCase())) {
                    if (food.getQuantity() != "SOLD OUT") {
                        int newQuantity = Integer.parseInt(food.getQuantity());
                        newQuantity--;
                        quant = newQuantity;
                        UserOutput.purchaseMessage(food, currentTotal);
                         if (newQuantity == 0) {
                            food.setQuantity("SOLD OUT");
                        } else {
                            food.setQuantity(String.valueOf(newQuantity));
                        }
                    }
                }
            }
        } else {
            UserOutput.purchaseImpossible();
        }
        return quant;
    }

    public static BigDecimal giveChange(BigDecimal currentTotal) {
        UserOutput.reportCurrentChange(currentTotal);
        BigDecimal totalChange = currentTotal;
        double quarters = currentTotal.divide(BigDecimal.valueOf(0.25)).doubleValue();
        int numberOfQuarters = (int) (quarters);

        currentTotal = currentTotal.subtract((BigDecimal.valueOf(numberOfQuarters * 0.25)));
        double dimes = currentTotal.divide(BigDecimal.valueOf(0.10)).doubleValue();
        int numberOfDimes = (int) (dimes);

        currentTotal = currentTotal.subtract(BigDecimal.valueOf(numberOfDimes * 0.10));
        double nickels = currentTotal.divide(BigDecimal.valueOf(0.05)).doubleValue();
        int numberOfNickels = (int) (nickels);
        currentTotal = currentTotal.subtract(BigDecimal.valueOf(numberOfNickels * 0.05));

        logger.write(logger.getDateTime() + " GIVE CHANGE " + UserOutput.returnMoney(totalChange) + " " + UserOutput.returnMoney(currentTotal));

        UserOutput.returnCoins(numberOfQuarters,numberOfDimes, numberOfNickels);
        try {
            logger.close();
        } catch (IOException e) {
            System.out.println("Failed to write to log!");
        }
        return currentTotal;
    }

    public static boolean isPurchasePossible() {
        return purchasePossible;
    }
}
