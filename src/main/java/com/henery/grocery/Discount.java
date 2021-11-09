package com.henery.grocery;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Discount {
    static final LocalDate TODAY = LocalDate.now();
    static final LocalDate NEXT_WEEK = TODAY.plusDays(7);
    static final LocalDate BREAD_DISCOUNT_START_DATE = TODAY.minusDays(1);
    static final LocalDate APPLE_DISCOUNT_END_DATE = TODAY.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
    static final LocalDate APPLE_DISCOUNT_START_DATE = TODAY.plusDays(3);

    public Discount() {
    }

    double calculateAppleDiscount(int numberOfApples, LocalDate orderDate) {
        return isAppleDiscountEligible(orderDate) ? (numberOfApples * Basket.APPLE_UNIT_PRICE) / 10 : 0.0;

    }

    boolean isAppleDiscountEligible(LocalDate orderDate) {
        return orderDate.isAfter(APPLE_DISCOUNT_START_DATE) && orderDate.isBefore(APPLE_DISCOUNT_END_DATE);
    }

    double calculateBreadDiscount(int tinsOfSoup, LocalDate orderDate) {
        return isBreadDiscountEligible(tinsOfSoup, orderDate) ? Basket.BREAD_UNIT_PRICE / 2 : 0.0;
    }

    boolean isBreadDiscountEligible(int tinsOfSoup, LocalDate orderDate) {
        return (orderDate.isAfter(BREAD_DISCOUNT_START_DATE) || orderDate.equals(BREAD_DISCOUNT_START_DATE)) && orderDate.isBefore(NEXT_WEEK) && tinsOfSoup > 1;
    }
}