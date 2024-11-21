package models.transports.transportsImpl;

import models.transports.Transport;

public class Bike implements Transport {
    private static final String TRANSPORT_NAME = "Bike";
    @Override
    public double calculateIncrement(double totalPrice) {
        return totalPrice * 0.01;
    }

    @Override
    public String getTransport() {
        return TRANSPORT_NAME;
    }
}
