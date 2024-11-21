package Services;

import exceptions.NoDeliveryManAvailable;
import exceptions.NoValidOrderException;
import exceptions.OrderNotFoundException;
import management.ClientManager;
import management.DeliveryMenManagement;
import management.OrderManagement;
import models.Client;
import models.DeliveryMen;
import models.Order;
import models.products.Product;
import models.products.productsImpl.Burger;
import models.products.productsImpl.Burrito;
import models.products.productsImpl.Kebab;
import models.products.productsImpl.Pizza;
import utils.Helper;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private static ClientManager clientManager;
    private static OrderManagement orderManagement;
    private static DeliveryMenManagement deliveryMenManagement;

    public static void start(){
        clientManager = new ClientManager();
        orderManagement = new OrderManagement();
        deliveryMenManagement = new DeliveryMenManagement();

        deliveryMenManagement.deliveryMenList(); //Si no lo inicializo me sale que no hay repartidores disp.

        startMenu();
    }

    public static void startMenu(){
        int option;
        List<Order> orders = new ArrayList<>();

        do{
            option = Helper.readInt("Welcome, choose an option: \n" +
                    "1. Create a new order.\n" +
                    "2. Mark an order as delivered.\n" +
                    "3. List pending orders.\n" +
                    "4. List delivered orders.\n" +
                    "0. Exit");

            switch(option) {
                case 1 -> {
                    orders.add(createOrderMenu());
                }
                case 2 -> {
                    markAnOrderAsDelivered(orders);
                }
                case 3 -> {
                   System.out.println(orderManagement.listPendingOrders(orders));
                }
                case 4 -> {
                    System.out.println(orderManagement.listDeliveredOrders(orders));
                }
                case 0 ->{
                    System.out.println("Thank you. Quitting the app.....");
                }
                default -> {
                    System.out.println("Please write down a valid option.");
                }

            }
        } while (option != 0);

    }

    public static void markAnOrderAsDelivered(List<Order> orders){
        int id;
        String answer;
        boolean check = false;

        try{

          do {
            id = Helper.readInt("Write down the order's number");
            Order order = orderManagement.findOrderById(orders, id);
            answer = Helper.readString("Are you sure you want to mark the order with number: " + id + " as delivered? (yes / no)").trim();

            if(answer.equalsIgnoreCase("yes")){
                orderManagement.markAsDelivered(order);
                System.out.println("Order with ID " + id + " has been delivered.");
                check = true;
            } else if (answer.equalsIgnoreCase("no")) {
                System.out.println("Cancelling.... Order has not been marked as delivered.");
                check = true;
            } else {
                System.out.println("Invalid option. Please answer 'Yes' or 'No'.");
            }

          }while(!check);

        } catch (OrderNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Order createOrderMenu() {
        String cancelOrder;
        boolean check = false;
        Order order = new Order();

        try {
            DeliveryMen assignedDeliveryMen = deliveryMenManagement.assignDeliveryMan();
            assignedDeliveryMen.setAvailability(false);

            order = orderManagement.createNewOrder(menuClient(), productsMenu(), assignedDeliveryMen);
            System.out.println("Order created successfully!");

        } catch (NoDeliveryManAvailable e) {
            System.out.println(e.getMessage());
            do {
                cancelOrder = Helper.readString("Would you like to cancel your order? (yes/no)").trim();

                if (cancelOrder.equalsIgnoreCase("yes")) {
                    System.out.println("Order canceled.");
                    check = true;
                } else if (cancelOrder.equalsIgnoreCase("no")) {
                    System.out.println("Please try again once we have available delivery men. Thank you.");
                    check = true;
                } else {
                    System.out.println("Invalid option. Please answer 'Yes' or 'No'.");
                }
            } while (!check);
        } catch (NoValidOrderException e) {
            System.out.println(e.getMessage());
        }

        return order;
    }

    public static Client menuClient(){
       String name, address;

       name = Helper.readString("Introduce the customer's name:");
       address = Helper.readString("Introduce the customer's address:");

       return  clientManager.createNewClient(name, address);
    }

    public static List<Product> productsMenu(){
        String option;
        List<Product> products = new ArrayList<>();

        do {
            option = Helper.readString("Select the products in the order: \n" +
            "- Burrito. \n" +
            "- Burger. \n" +
            "- Kebab. \n" +
            "- Pizza. \n" +
            "Type OK to complete the order.").trim();

        switch(option.toLowerCase()){

            case "burrito" -> {
                Product burrito = new Burrito();
                products.add(burrito);
                burrito.getMessageAddedToOrder();
                burrito.getReward();
            }

            case "burger" -> {
                Product burger = new Burger();
                products.add(burger);
                burger.getMessageAddedToOrder();
                burger.getReward();
            }

            case "kebab" -> {
                Product kebab = new Kebab();
                products.add(kebab);
                kebab.getMessageAddedToOrder();
            }

            case "pizza" -> {
                Product pizza = new Pizza();
                products.add(pizza);
                pizza.getMessageAddedToOrder();
            }

            case "ok" -> System.out.println("Saving the order...");

            default -> System.out.println("Invalid option. Please select a valid product or type 'Ok'.");
        }

        }while(!option.equalsIgnoreCase("OK"));

        return products;
    }
}
