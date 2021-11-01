package com.henery.grocery;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Basket {
    private static final LocalDate TODAY = LocalDate.now();
    private static final LocalDate NEXT_WEEK = TODAY.plusDays(7);
    private static final LocalDate YESTERDAY = TODAY.minusDays(1);
    private static final LocalDate APPLE_DISCOUNT_END_DATE = TODAY.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
    private static final LocalDate APPLE_DISCOUNT_START_DATE = TODAY.plusDays(3);
    private static final double SOUP_UNIT_PRICE = 0.65;
    private static final double BREAD_UNIT_PRICE = 0.80;
    private static final double APPLE_UNIT_PRICE = 0.10;
    private static final double MILK_UNIT_PRICE = 1.30;

    public double totalPrice(int tinsOfSoup, int loavesOfBread, int numberOfApples, int bottleOfMilk, LocalDate orderDate) {
        double discountValue = calculateBreadDiscount(tinsOfSoup, orderDate) + calculateAppleDiscount(numberOfApples, orderDate);
        double originalTotalPrice = calculateOriginalTotalPrice(tinsOfSoup, loavesOfBread, numberOfApples, bottleOfMilk);
        return originalTotalPrice - discountValue;
    }

    private double calculateAppleDiscount(int numberOfApples, LocalDate orderDate) {
        return isAppleDiscountEligible(orderDate) ? (numberOfApples * APPLE_UNIT_PRICE) / 10 : 0.0;

    }

    private boolean isAppleDiscountEligible(LocalDate orderDate) {
        return orderDate.isAfter(APPLE_DISCOUNT_START_DATE) && orderDate.isBefore(APPLE_DISCOUNT_END_DATE);
    }

    private double calculateBreadDiscount(int tinsOfSoup, LocalDate orderDate) {
        return isBreadDiscountEligible(tinsOfSoup, orderDate) ? BREAD_UNIT_PRICE / 2 : 0.0;
    }

    private boolean isBreadDiscountEligible(int tinsOfSoup, LocalDate orderDate) {
        return orderDate.isAfter(YESTERDAY) && orderDate.isBefore(NEXT_WEEK) && tinsOfSoup > 1;
    }

    private double calculateOriginalTotalPrice(int tinsOfSoup, int loavesOfBread, int numberOfApples, int bottleOfMilk) {
        return (tinsOfSoup * SOUP_UNIT_PRICE) +
                (loavesOfBread * BREAD_UNIT_PRICE) +
                (numberOfApples * APPLE_UNIT_PRICE) +
                (bottleOfMilk * MILK_UNIT_PRICE);
    }
}
