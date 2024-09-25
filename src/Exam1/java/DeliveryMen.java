public class DeliveryMen {
    private String name;
    public enum DeliveryType {BIKE, SCOOTER, WALKING};
    private DeliveryType dType;
    private boolean availability;

    public DeliveryMen(String name, boolean availability, DeliveryType dType){
        this.name = name;
        this.availability = true;
        this.dType = dType;
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return availability;
    }

    public DeliveryType getDType() {
        return dType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public double CalculateDeliverType(int price, DeliveryMen dMan){
        double finalPrice = 0;

        if(dMan.getDType().equals(DeliveryType.BIKE)){
            finalPrice = price + (0.01 * price);
        }else if (dMan.getDType().equals(DeliveryType.SCOOTER)){
            finalPrice = price + (0.02 * price);
        } else {
            finalPrice = price;
        }
        return finalPrice;
    }
}