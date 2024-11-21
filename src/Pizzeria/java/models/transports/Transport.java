package models.transports;

public interface Transport {
    double calculateIncrement(double totalPrice);
    String getTransport();
}
