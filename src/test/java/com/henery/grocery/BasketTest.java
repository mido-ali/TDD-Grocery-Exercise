package com.henery.grocery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

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
    public void coastOfBasketContainingThreeTinsOfSoupTwoLoavesOfBreadBoughtYesterday() {
        Assert.assertEquals(3.15, basket.totalPrice(3, 2, 0, 0, TODAY.minusDays(1)), DELTA);

    }

    @Test
    public void coastOfBasketContainingThreeTinsOfSoupTwoLoavesOfBreadBoughtTwoDaysAgo() {
        Assert.assertEquals(3.55, basket.totalPrice(3, 2, 0, 0, TODAY.minusDays(2)), DELTA);

    }

    @Test
    public void coastOfBasketContainingThreeTinsOfSoupTwoLoavesOfBreadBoughtInSixDays() {
        Assert.assertEquals(3.15, basket.totalPrice(3, 2, 0, 0, TODAY.plusDays(6)), DELTA);

    }

    @Test
    public void coastOfBasketContainingThreeTinsOfSoupTwoLoavesOfBreadBoughtInSevenDaysFromNow() {
        Assert.assertEquals(3.55, basket.totalPrice(3, 2, 0, 0, TODAY.plusDays(7)), DELTA);

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
    public void coastOfBasketContainingSixApplesOneBottleOfMilkBoughtInThreeDays() {
        Assert.assertEquals(1.84, basket.totalPrice(0, 0, 6, 1, TODAY.plusDays(3)), DELTA);
    }

    @Test
    public void coastOfBasketContainingSixApplesOneBottleOfMilkBoughtInTheEndOfNextMonth() {
        Assert.assertEquals(1.84, basket.totalPrice(0, 0, 6, 1, TODAY.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth())), DELTA);
    }

    @Test
    public void coastOfBasketContainingSixApplesOneBottleOfMilkBoughtAfterTheEndOfNextMonth() {
        Assert.assertEquals(1.90, basket.totalPrice(0, 0, 6, 1, TODAY.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth()).plusDays(1)), DELTA);
    }

    @Test
    public void coastOfBasketContainingThreeApplesTwoTinsOfSoupLoafOfBreadBoughtInFiveDays() {
        Assert.assertEquals(1.97, basket.totalPrice(2, 1, 3, 0, TODAY.plusDays(5)), DELTA);
    }

    @Test
    public void coastOfBasketContainingThreeApplesTwoTinsOfSoupLoafOfBreadBoughtToday() {
        Assert.assertEquals(2.0, basket.totalPrice(2, 1, 3, 0, TODAY), DELTA);
    }

    @Test
    public void coastOfEmptyBasket() {
        Assert.assertEquals(0.0, basket.totalPrice(0, 0, 0, 0, TODAY), DELTA);
    }

    @Test
    public void coastOfBasketContainingOneTinOfSoupBoughtToday() {
        Assert.assertEquals(0.65, basket.totalPrice(1, 0, 0, 0, TODAY), DELTA);
    }

    @Test
    public void coastOfBasketContainingOneLoafOfBreadBoughtToday() {
        Assert.assertEquals(0.80, basket.totalPrice(0, 1, 0, 0, TODAY), DELTA);
    }

    @Test
    public void coastOfBasketContainingOneAppleBoughtToday() {
        Assert.assertEquals(0.10, basket.totalPrice(0, 0, 1, 0, TODAY), DELTA);
    }

    @Test
    public void coastOfBasketContainingOneBottleOfMilkBoughtToday() {
        Assert.assertEquals(1.30, basket.totalPrice(0, 0, 0, 1, TODAY), DELTA);
    }
}
