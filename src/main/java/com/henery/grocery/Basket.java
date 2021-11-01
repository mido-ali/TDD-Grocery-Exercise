package com.henery.grocery;

import java.time.LocalDate;

public class Basket {
    public static final LocalDate TODAY = LocalDate.now();
    private static final double SOUP_UNIT_PRICE = 0.65;
    private static final double BREAD_UNIT_PRICE = 0.80;
    private static final double APPLE_UNIT_PRICE = 0.10;
    private static final double MILK_UNIT_PRICE = 1.30;

    public double totalPrice(int tinsOfSoup, int loavesOfBread, int numberOfApples, int bottleOfMilk, LocalDate orderDate) {
        double discountValue = calculateDiscount(tinsOfSoup, orderDate);
        double originalTotalPrice = calculateOriginalTotalPrice(tinsOfSoup, loavesOfBread, numberOfApples, bottleOfMilk);
        return originalTotalPrice - discountValue;
    }

    private double calculateDiscount(int tinsOfSoup, LocalDate orderDate) {
        return (orderDate.equals(TODAY) && tinsOfSoup > 1) ? BREAD_UNIT_PRICE / 2 : 0.0;
    }

    private double calculateOriginalTotalPrice(int tinsOfSoup, int loavesOfBread, int numberOfApples, int bottleOfMilk) {
        return (tinsOfSoup * SOUP_UNIT_PRICE) + (loavesOfBread * BREAD_UNIT_PRICE) + (numberOfApples * APPLE_UNIT_PRICE) + (bottleOfMilk * MILK_UNIT_PRICE);
    }
}
