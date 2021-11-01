package com.henery.grocery;

import org.junit.Assert;
import org.junit.Test;

public class BasketTest {
    @Test
    public void coastOfBasketContainingThreeTinsOfSoupTwoLoavesOfBreadBoughtToday(){
        Assert.assertEquals(3.15, new Basket().totalPrice(3, 2, "today"),0.01);

    }
}
