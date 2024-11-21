package models.transports.transportsImpl;

import models.transports.Transport;

public class Scooter implements Transport {
    private static final String TRANSPORT_NAME = "Scooter";
    @Override
    public double calculateIncrement(double totalPrice) {
        return totalPrice * 0.02;
    }

    @Override
    public String getTransport() {
        return TRANSPORT_NAME;
    }
}
