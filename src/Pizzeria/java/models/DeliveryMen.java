package models;

import models.transports.Transport;

public class DeliveryMen {
    private String name;
    private boolean availability;
    private Transport transport;

    public DeliveryMen(String name, Transport transport) {
        this.name = name;
        this.availability = true;
        this.transport = transport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}
