package models.transports.transportsImpl;

import models.transports.Transport;

public class Walk implements Transport {
    private static final String TRANSPORT_NAME = "Walking";
    @Override
    public double calculateIncrement(double totalPrice) {
        return 0;
    }

    @Override
    public String getTransport() {
        return TRANSPORT_NAME;
    }
}
