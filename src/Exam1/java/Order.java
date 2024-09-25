import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Order {
    private static Scanner entry = new Scanner(System.in);
    private int orderId;
    static private int orderIdCount = 1;
    private Client client;
    private ArrayList<Products> productsList;
    private DeliveryMen deliveryMan;
    private boolean delivered;

    public Order (int orderId, Client client, ArrayList<Products> productsList, DeliveryMen deliveryMan,boolean delivered){
        this.orderId = orderIdCount;
        orderIdCount++;
        this.client = client;
        this.productsList = new ArrayList<Products>();
        this.deliveryMan = deliveryMan;
        this.delivered = false;
    }

    public int getOrderId() {
        return orderId;
    }
    public Client getClient() {
        return client;
    }
    public ArrayList<Products> getProductsList() {
        return productsList;
    }
    public DeliveryMen getDeliveryMan() {
        return deliveryMan;
    }
    public boolean isDelivered() {
        return delivered;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    public void setProductsList(Products product) {
        this.productsList.add(product);
    }
    public void setDeliveryMan(DeliveryMen deliveryMan) {
        this.deliveryMan = deliveryMan;
    }
    public void setDelivered(boolean delivered) {
        this.delivered = delivered;
    }

    public static Client createNewClient() {
        String name, address;

        System.out.println("Introduce the customer's name:");
        name = entry.nextLine();
        System.out.println("Introduce the customer's address:");
        address = entry.nextLine();
        Client newClient = new Client(name, address);

        return newClient;
    }
    public static DeliveryMen randomDeliverMen(){
        ArrayList<DeliveryMen> randomDel = createDelMan();
        Random r = new Random();

        int randomInt = r.nextInt(randomDel.size());
        DeliveryMen randomMen = randomDel.get(randomInt);

        return randomMen;
    }

    public static ArrayList<DeliveryMen> createDelMan(){
        ArrayList<DeliveryMen> deliveryMen = new ArrayList<DeliveryMen>();
        DeliveryMen delMen1 = new DeliveryMen("Manolo Garcia", true, DeliveryMen.DeliveryType.WALKING);
        deliveryMen.add(delMen1);
        DeliveryMen delMen2 = new DeliveryMen("Roberto Alberto", true, DeliveryMen.DeliveryType.BIKE);
        deliveryMen.add(delMen2);
        DeliveryMen delMen3 = new DeliveryMen("Maria Lorenzo", true, DeliveryMen.DeliveryType.SCOOTER);
        deliveryMen.add(delMen3);

        return deliveryMen;
    }
}
