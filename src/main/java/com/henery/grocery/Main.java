package com.henery.grocery;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter tins of Soup you want to add to basket");
        int tinsOfSoup = in.nextInt();

        System.out.println("Please enter loaves of Bread you want to add to basket");
        int loavesOfBread = in.nextInt();

        System.out.println("Please enter number of Apples you want to add to basket");
        int numberOfApples = in.nextInt();

        System.out.println("Please enter bottles Of Milk you want to add to basket");
        int bottlesOfMilk = in.nextInt();

        double totalPrice = new Basket().totalPrice(tinsOfSoup, loavesOfBread, numberOfApples, bottlesOfMilk, LocalDate.now());
        System.out.println("basket total price is: " + totalPrice);

        in.close();
    }
}
