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
}
