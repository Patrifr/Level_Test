package management;

import exceptions.NoValidOrderException;
import exceptions.OrderNotFoundException;
import models.Client;
import models.DeliveryMen;
import models.Order;
import models.products.Product;

import java.util.List;


public class OrderManagement {

    public Order createNewOrder(Client client, List<Product> productsOrder, DeliveryMen delMen) throws NoValidOrderException {
        if(client == null){
            throw new NoValidOrderException("Error. The order must have a client.");
        }
        if(productsOrder == null || productsOrder.isEmpty()){
            throw new NoValidOrderException("Error. The order cannot be empty, please add you products first.");
        }

        return new Order(client, productsOrder, delMen);
    }

    public List<String> listDeliveredOrders(List<Order> orders){
        return orders.stream().filter(Order::isDelivered).map(order -> {
            List<String> listProducts = seeProductsList(order.getProductsList());
            String clientName = order.getClient().getName();
            String clientAddress = order.getClient().getAddress();
            String delMenName = order.getDeliveryMan().getName();
            String status = (!order.isDelivered()) ? "Pending" : "Delivered";

            return "\nOrder number: " + order.getOrderId() + "\nClient Name: " + clientName + "\nClient Address: "
                    + clientAddress + "\nProducts: \n" + listProducts + "Delivery Man: " + delMenName
                    + "\nOrder Status: " + status + "\n";
        }).toList();
    }

    public List<String> listPendingOrders(List<Order> orders){
        return orders.stream().filter(order -> !order.isDelivered()).map(order -> {
            List<String> listProducts = seeProductsList(order.getProductsList());
            String clientName = order.getClient().getName();
            String clientAddress = order.getClient().getAddress();
            String delMenName = order.getDeliveryMan().getName();
            String status = (!order.isDelivered()) ? "Pending" : "Delivered";

            return "\nOrder number: " + order.getOrderId() + "\nClient Name: " + clientName + "\nClient Address: "
                    + clientAddress + "\nProducts: \n" + listProducts + "Delivery Man: " + delMenName
                    + "\nOrder Status: " + status + "\n";
        }).toList();
    }

    public Order findOrderById(List<Order> orders, int orderId) throws OrderNotFoundException {
        return orders.stream()
                .filter(order -> order.getOrderId() == orderId)
                .findFirst()
                .orElseThrow(()-> new OrderNotFoundException("Order with id: " + orderId + " not found."));
    }

    public static List<String> seeProductsList(List<Product> products){
        return products.stream().map(product -> product.getName() + ": " +
                product.getPrice() + "€. \n").toList();
    }

    public void markAsDelivered(Order order) {
        order.setDelivered(true);
        if (order.getDeliveryMan() != null) {
            order.getDeliveryMan().setAvailability(true);
        }
    }
}
