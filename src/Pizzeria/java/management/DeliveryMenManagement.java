package management;

import exceptions.NoDeliveryManAvailable;
import models.DeliveryMen;
import models.transports.transportsImpl.Bike;
import models.transports.transportsImpl.Scooter;
import models.transports.transportsImpl.Walk;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DeliveryMenManagement {
    private List<DeliveryMen> deliveryMen;

    public DeliveryMenManagement() {
        this.deliveryMen = new ArrayList<>();
    }

    public DeliveryMen assignDeliveryMan() throws NoDeliveryManAvailable {
        List<DeliveryMen> availableDeliveryMen = availableDeliveryMen();

        if(availableDeliveryMen().isEmpty()){
            throw new NoDeliveryManAvailable("Sorry, we don't have any available delivery man at he moment.");
        }
        return randomDeliveryMan(availableDeliveryMen);
    }

    public DeliveryMen randomDeliveryMan(List<DeliveryMen> availableDeliveryMen){
        Random rand = new Random();
        int index = rand.nextInt(availableDeliveryMen.size());
        return availableDeliveryMen.get(index);

    }

    public List<DeliveryMen> availableDeliveryMen(){
        return deliveryMen.stream()
                .filter(DeliveryMen::isAvailable)
                .toList();
    }

    public List<DeliveryMen> deliveryMenList(){
        DeliveryMen delMen1 = new DeliveryMen("Manolo Garcia", new Walk());
        delMen1.setAvailability(true);
        deliveryMen.add(delMen1);
        DeliveryMen delMen2 = new DeliveryMen("Roberto Alberto", new Bike());
        delMen2.setAvailability(true);
        deliveryMen.add(delMen2);
        DeliveryMen delMen3 = new DeliveryMen("Maria Lorenzo", new Scooter());
        delMen3.setAvailability(true);
        deliveryMen.add(delMen3);

        return deliveryMen;
    }
}
