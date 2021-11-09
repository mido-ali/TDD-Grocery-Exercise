package com.henery.grocery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

public class BasketTest {

    private static final LocalDate TODAY = LocalDate.now();
    private static final double DELTA = 0.01;
    private Basket basket;

    @Before
    public void setUp() {
        basket = new Basket();
    }

    @Test
    public void coastOfBasketContainingThreeTinsOfSoupTwoLoavesOfBreadBoughtToday() {
        Assert.assertEquals(3.15, basket.totalPrice(3, 2, 0, 0, TODAY), DELTA);

    }

    @Test
    public void coastOfBasketContainingSixApplesOneBottleOfMilkBoughtToday() {
        Assert.assertEquals(1.90, basket.totalPrice(0, 0, 6, 1, TODAY), DELTA);
    }

    @Test
    public void coastOfBasketContainingSixApplesOneBottleOfMilkBoughtInFiveDays() {
        Assert.assertEquals(1.84, basket.totalPrice(0, 0, 6, 1, TODAY.plusDays(5)), DELTA);
    }

    @Test
    public void coastOfBasketContainingThreeApplesTwoTinsOfSoupLoafOfBreadBoughtInFiveDays() {
        Assert.assertEquals(1.97, basket.totalPrice(2, 1, 3, 0, TODAY.plusDays(5)), DELTA);
    }

    @Test
    public void coastOfBasketContainingThreeTinsOfSoupTwoLoavesOfBreadBoughtYesterday() {
        Assert.assertEquals(3.15, basket.totalPrice(3, 2, 0, 0, TODAY.minusDays(1)), DELTA);

    }
}
