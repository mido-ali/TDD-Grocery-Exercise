package com.henery.grocery;

import org.junit.Assert;
import org.junit.Test;

public class BasketTest {
    @Test
    public void coastOfBasketContainingThreeTinsOfSoupTwoLoavesOfBreadBoughtToday() {
        Assert.assertEquals(3.15, new Basket().totalPrice(3, 2, 0, 0, "today"), 0.01);

    }

    @Test
    public void coastOfBasketContainingSixApplesOneBottleOfMilkBoughtToday() {
        Assert.assertEquals(1.90, new Basket().totalPrice(0, 0, 6, 1, "today"), 0.01);
    }
}
