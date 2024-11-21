package models.products.productsImpl;

import models.products.Product;

public class Burrito implements Product {
    private static final double PRICE = 6.5;
    private static final String NAME = "Burrito";
    private static final String REWARD = "Pin";

    @Override
    public double getPrice() {
        return PRICE;
    }

    @Override
    public void getReward() {
        System.out.println("Congratulations! You'll receive a " + REWARD + " with your burrito.");
    }

    @Override
    public void getMessageAddedToOrder() {
        System.out.println(NAME + " successfully added to the order.");
    }

    @Override
    public String getName() {
        return NAME;
    }
}
