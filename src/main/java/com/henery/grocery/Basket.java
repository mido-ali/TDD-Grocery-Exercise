package com.henery.grocery;

import java.time.LocalDate;

public class Basket {
    public static final LocalDate TODAY = LocalDate.now();
    public static final double SOUP_UNIT_PRICE = 0.65;
    public static final double BREAD_UNIT_PRICE = 0.80;
    public static final double APPLE_UNIT_PRICE = 0.10;
    public static final double MILK_UNIT_PRICE = 1.30;

    public double totalPrice(int tinsOfSoup, int loavesOfBread, int numberOfApples, int bottleOfMilk, LocalDate orderDate) {
        double disCountValue = calculateDiscount(tinsOfSoup, orderDate);
        double originalTotalPrice = calculateOriginalTotalPrice(tinsOfSoup, loavesOfBread, numberOfApples, bottleOfMilk);
        return originalTotalPrice - disCountValue;
    }

    private double calculateDiscount(int tinsOfSoup, LocalDate orderDate) {
        return (orderDate.equals(TODAY) && tinsOfSoup > 1) ? BREAD_UNIT_PRICE / 2 : 0.0;
    }

    private double calculateOriginalTotalPrice(int tinsOfSoup, int loavesOfBread, int numberOfApples, int bottleOfMilk) {
        return (tinsOfSoup * SOUP_UNIT_PRICE) + (loavesOfBread * BREAD_UNIT_PRICE) + (numberOfApples * APPLE_UNIT_PRICE) + (bottleOfMilk * MILK_UNIT_PRICE);
    }
}
