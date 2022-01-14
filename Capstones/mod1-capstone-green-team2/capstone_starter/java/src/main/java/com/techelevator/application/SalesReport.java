package com.techelevator.application;

import com.techelevator.models.Food;
import com.techelevator.models.Sales;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SalesReport {

    public static void adjustSalesReport(List<Sales> localSalesReport, BigDecimal totalSales) {

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy HH.mm.ss");
        String fileName = "sales report " + now.format(formatter) + ".txt";
        File writeFile = new File(fileName);
        UserOutput.printSalesReport();

        try (PrintWriter writer = new PrintWriter(writeFile)) {
            for (Sales sale : localSalesReport) {
                writer.println(sale.getName() + "|" + sale.getQuantitySold());
            }
            writer.println("\nThe total amount spent is: " + UserOutput.returnMoney(totalSales));
        } catch (FileNotFoundException e) {
            System.out.println("Failed to write to file.");
        }
    }
}