package com.henery.grocery;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter tins of soup you want to add to basket");
        int tinsOfSoup = in.nextInt();

        System.out.println("Please enter loaves of bread you want to add to basket");
        int loavesOfBread = in.nextInt();

        System.out.println("Please enter number of apples you want to add to basket");
        int numberOfApples = in.nextInt();

        System.out.println("Please enter bottles of milk you want to add to basket");
        int bottlesOfMilk = in.nextInt();

        System.out.println("Please enter order date with format yyyy-mm-dd");
        String orderDate = in.next();
        LocalDate localDate = LocalDate.parse(orderDate);

        double totalPrice = new Basket().totalPrice(tinsOfSoup, loavesOfBread, numberOfApples, bottlesOfMilk, localDate);
        System.out.println("basket total price is: " + DECIMAL_FORMAT.format(totalPrice));

        in.close();
    }
}
