package models.products.productsImpl;

import models.products.Product;

public class Burger implements Product {
    private static final double PRICE = 8.9;
    private static final String NAME = "Burger";
    private static final String REWARD = "Hat";

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
