package com.henery.grocery;

public class Basket {
    double breadDisCountValue = 0;

    public double totalPrice(int tinsOfSoup, int loavesOfBread, int numberOfApples, int bottleOfMilk, String today) {
        if (today == "today" && tinsOfSoup > 1) {
            breadDisCountValue = 0.80 / 2;
        }

        return (tinsOfSoup * 0.65) + (loavesOfBread * 0.80 - breadDisCountValue) + (numberOfApples * 0.10) + (bottleOfMilk * 1.30);
    }
}
