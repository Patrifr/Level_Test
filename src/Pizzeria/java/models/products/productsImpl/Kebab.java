package models.products.productsImpl;

import models.products.Product;

public class Kebab implements Product {
    private static final double PRICE = 4.5;
    private static final String NAME = "Kebab";

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
