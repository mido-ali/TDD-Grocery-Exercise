package com.henery.grocery;

import java.time.LocalDate;

public class Basket {
    public static final double BREAD_UNIT_PRICE = 0.80;
    public static final double APPLE_UNIT_PRICE = 0.10;
    private static final double SOUP_UNIT_PRICE = 0.65;
    private static final double MILK_UNIT_PRICE = 1.30;
    private final Discount discount = new Discount();

    public double totalPrice(int tinsOfSoup, int loavesOfBread, int numberOfApples, int bottlesOfMilk, LocalDate orderDate) {
        double discountValue = discount.calculateBreadDiscount(tinsOfSoup, orderDate) + discount.calculateAppleDiscount(numberOfApples, orderDate);
        double originalTotalPrice = calculateOriginalTotalPrice(tinsOfSoup, loavesOfBread, numberOfApples, bottlesOfMilk);
        return originalTotalPrice - discountValue;
    }

    private double calculateOriginalTotalPrice(int tinsOfSoup, int loavesOfBread, int numberOfApples, int bottleOfMilk) {
        return (tinsOfSoup * SOUP_UNIT_PRICE) +
                (loavesOfBread * BREAD_UNIT_PRICE) +
                (numberOfApples * APPLE_UNIT_PRICE) +
                (bottleOfMilk * MILK_UNIT_PRICE);
    }
}
