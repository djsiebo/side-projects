package com.techelevator.application;

import com.techelevator.models.Chips;
import com.techelevator.models.Food;
import com.techelevator.models.Gum;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MathTest {

    @Test
    public void purchaseMath_buy_2_75_return_2_25(){
    Math math = new Math();
    BigDecimal expected = BigDecimal.valueOf(2.25);
    BigDecimal actual = math.purchaseMath(BigDecimal.valueOf(5), BigDecimal.valueOf(2.75));

    Assert.assertEquals(expected, actual);
    }

    @Test
    public void purchaseMath_buy_0_return_5(){
        Math math = new Math();
        BigDecimal expected = BigDecimal.valueOf(5);
        BigDecimal actual = math.purchaseMath(BigDecimal.valueOf(5), BigDecimal.valueOf(0));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void purchaseMath_buy_10_return_0(){
        Math math = new Math();
        BigDecimal expected = BigDecimal.valueOf(0);
        BigDecimal actual = math.purchaseMath(BigDecimal.valueOf(10), BigDecimal.valueOf(10));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void purchaseMath_buy_10_return_5_purchase_not_possible(){
        Math math = new Math();
        BigDecimal expected = BigDecimal.valueOf(5);
        BigDecimal actual = math.purchaseMath(BigDecimal.valueOf(5), BigDecimal.valueOf(10));

        Assert.assertEquals(expected, actual);
    }

      @Test
    public void addFeedMoney_pass_in_5_return_5() {
        Math math = new Math();
        BigDecimal expected = BigDecimal.valueOf(5);
        BigDecimal actual = math.addFeedMoney(BigDecimal.valueOf(0), BigDecimal.valueOf(5));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addFeedMoney_pass_in_2_return_7() {
        Math math = new Math();

        BigDecimal expected = BigDecimal.valueOf(7);
        BigDecimal actual = math.addFeedMoney(BigDecimal.valueOf(2), BigDecimal.valueOf(5));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addFeedMoney_pass_in_4_11_return_7_75() {
        Math math = new Math();
        BigDecimal expected = BigDecimal.valueOf(7.75);
        BigDecimal actual = math.addFeedMoney(BigDecimal.valueOf(3.64), BigDecimal.valueOf(4.11));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void itemDecrement_buy_an_item_decrease_quantity_by_1() {
        List<Food> foods = new ArrayList<>();
        Chips chips = new Chips("A1", "Potato Crisps", BigDecimal.valueOf(3.05));
        Math math = new Math();
        foods.add(chips);
        int expected = 4;
        int actual = math.itemDecrement(BigDecimal.valueOf(6), foods, "A1", true);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void itemDecrement_buy_an_item_from_larger_list_decrease_quantity_by_1() {
        List<Food> foods = new ArrayList<>();
        Chips chips = new Chips("A1", "Potato Crisps", BigDecimal.valueOf(3.05));
        Gum gum = new Gum("A2", "Wrigley's", BigDecimal.valueOf(0.95));
        Math math = new Math();
        foods.add(chips);
        foods.add(gum);
        int expected = 4;
        int actual = math.itemDecrement(BigDecimal.valueOf(6), foods, "A2", true);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void giveChange_pass_in_6_return_0() {
        Math math = new Math();
        BigDecimal expected = BigDecimal.valueOf(0.0);
        BigDecimal actual = math.giveChange(BigDecimal.valueOf(6.00));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void giveChange_pass_in_3_75_return_0() {
        Math math = new Math();
        String expected = UserOutput.returnMoney(BigDecimal.valueOf(0.00));
        String actual = UserOutput.returnMoney(math.giveChange(BigDecimal.valueOf(3.75)));

        Assert.assertEquals(expected, actual);
    }

    // No test for negative value with giveChange because
    // other methods protect against this

}