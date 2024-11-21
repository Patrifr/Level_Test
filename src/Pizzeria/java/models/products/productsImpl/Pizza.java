package models.products.productsImpl;

import models.products.Product;

public class Pizza implements Product {
    private static final double PRICE = 7.9;
    private static final String NAME = "Pizza";

    @Override
    public double getPrice() {
        return PRICE;
    }

    @Override
    public void getReward() {
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
