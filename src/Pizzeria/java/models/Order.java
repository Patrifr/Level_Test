package models;

import models.products.Product;

import utils.idsGenerators.Ids;

import java.util.List;

public class Order {
        private int orderId;
        private Client client;
        private List<Product> productsList;
        private DeliveryMen deliveryMan;
        private boolean delivered;

    public Order(){

    }

    public Order(Client client, List<Product> productsList, DeliveryMen deliveryMan) {
        this.orderId = Ids.orderIdGenerator.generateId();
        this.client = client;
        this.productsList = productsList;
        this.deliveryMan = deliveryMan;
        this.delivered = false;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Product> productsList) {
        this.productsList = productsList;
    }

    public DeliveryMen getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMen deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }
}
