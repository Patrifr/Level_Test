import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner entry = new Scanner(System.in);
    public static void main(String[] args) {
        menu();
    }

    public static void menu(){
        int option = 0;
        String answer = "";
        ArrayList<Order> orders = new ArrayList<Order>();
        Scanner entry = new Scanner(System.in);
        do{
            System.out.println("Welcome, choose an option: \n" +
                    "1. Create a new order.\n" +
                    "2. Mark an order as delivered.\n" +
                    "3. List pending orders.\n" +
                    "4. List delivered orders.\n" +
                    "0. Exit");
            option = entry.nextInt();

            switch (option){
                case 1:
                    Order newOrder = createNewOrder();
                    orders.add(newOrder);
                    break;
                case 2:
                    markOrderAsDelivered(orders);
                    break;
                case 3:
                    answer = listPendingOrders(orders);
                    System.out.println(answer);
                    break;
                case 4:
                    answer = listDeliveredOrders(orders);
                    System.out.println(answer);
                    break;
            }
        }while(option != 0);
        entry.close();
    }
    public static String listDeliveredOrders(ArrayList<Order> orders){
        String list = "";
        for(Order order : orders){
            String listProducts = seeProductsList(order.getProductsList());
            String clientName = order.getClient().getName();
            String clientAddress = order.getClient().getAddress();
            String delMenName = order.getDeliveryMan().getName();
            String status = (!order.isDelivered()) ? "Pending" : "Delivered";

            if(order.isDelivered()){
                list += "\nOrder number: " + order.getOrderId() + "\nClient Name: " + clientName + "\nClient Address: "
                        +  clientAddress + "\nProducts: \n" + listProducts + "Delivery men: " + delMenName
                        + "\nOrder Status: " + status + "\n";
            }
        }
        return list;
    }
    public static String listPendingOrders(ArrayList<Order> orders){
        String list = "";
        for(Order order : orders){
            String listProducts = seeProductsList(order.getProductsList());
            String clientName = order.getClient().getName();
            String clientAddress = order.getClient().getAddress();
            String delMenName = order.getDeliveryMan().getName();
            String status = (!order.isDelivered()) ? "Pending" : "Delivered";

            if(!order.isDelivered()){
                list += "\nOrder number: " + order.getOrderId() + "\nClient Name: " + clientName + "\nClient Address: "
                        +  clientAddress + "\nProducts: \n" + listProducts + "Delivery men: " + delMenName
                        + "\nOrder Status: " + status + "\n";
            }
        }
        return list;
    }
    public static void markOrderAsDelivered(ArrayList<Order> listOrders){
        int idInput = 0;
        String answer = "";
        boolean delivered = true;
        boolean check = false;

        System.out.println("Write down the Order's number: ");
        idInput = entry.nextInt();
        while(!check){
            for(Order order : listOrders){
                if(order.getOrderId() == idInput){
                        System.out.println("Are you sure you want to mark the order with id: " + idInput + " as delivered?\n" +
                                    "Answer Yes or No: ");
                        answer = entry.next();

                        if(answer.equalsIgnoreCase("Yes")){
                        order.setDelivered(delivered);
                        System.out.println("Order successfully marked as delivered.");
                        } else if (answer.equalsIgnoreCase("No")) {
                        System.out.println("Cancelling..........");
                        }
                        check = true;
                    if(order.getOrderId() != idInput){
                        System.out.println("There's no order with the specified id.");
                        check = true;

                    }
                }
            }
        }
    }
    public static Order createNewOrder() {
        Client newClient = Order.createNewClient();
        DeliveryMen delivery = Order.randomDeliverMen();
        ArrayList<Products> productsList = new ArrayList<Products>();
        Order order1;
        try {
            if (!delivery.isAvailable()) {
                throw new NoDeliveryMenAvailable("At this moment there's no delivery men available.");
            } else {
                order1 = new Order(1, newClient, productsList, delivery, false);
                productsList = addToCard(order1);
            }
        } catch (NoDeliveryMenAvailable e) {
            throw new RuntimeException(e);
        }

        return order1;
    }
    public static String seeProductsList(ArrayList<Products> products){
        String list = "";
        for(Products product : products){
            list += product.getName() + ": " + product.getPrice() + "€.\n";
        }
        return list;
    }

    public static ArrayList<Products> addToCard(Order order){
        int option = 0;
        do{
            System.out.println("Select the products in the order: \n" +
                    "1. Burrito. \n" +
                    "2. Burger. \n" +
                    "3. Kebab. \n" +
                    "4. Pizza. \n" +
                    "0. Finish.");
            option = entry.nextInt();
            switch(option){
                case 1:
                    Products burrito = new Products("Burrito", 6.5);
                    order.getProductsList().add(burrito);
                    System.out.println("Product successfully added to the order.\n" +
                            "For the purchase of one burrito you get a pin as a reward!");
                    break;
                case 2:
                    Products burger = new Products("Burger", 8.90);
                    order.getProductsList().add(burger);
                    System.out.println("Product successfully added to the order.\n" +
                            "For the purchase of one burger you get a hat as a reward!");
                    break;
                case 3:
                    Products kebab = new Products("Kebab", 4.5);
                    order.getProductsList().add(kebab);
                    System.out.println("Product successfully added to the order.");
                    break;
                case 4:
                    Products pizza = new Products("Pizza", 7.9);
                    order.getProductsList().add(pizza);
                    System.out.println("Product successfully added to the order.");
                    break;
                case 0:
                    System.out.println("Saving the order.......");
                    break;
            }
        }while(option != 0);
        return order.getProductsList();
    }
}
