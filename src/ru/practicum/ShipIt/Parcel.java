package ru.practicum.ShipIt;

public abstract class Parcel {
    protected String description;
    protected Integer weight;
    protected String deliveryAddress;
    protected Integer sendDay;

    @Override
    public String toString() {
        return "Parcel{" +
                "description= " + description + ", " +
                "weight= " + weight + ", " +
                "deliveryAddress= " + deliveryAddress + ", " +
                "sendDay= " + sendDay + "}";
    }

    public Parcel(String description, Integer weight, String deliveryAddress, Integer sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    public Integer calculateDeliveryCost() {
        return weight * getBasicUnitShippingCost();
    }

    public abstract Integer getBasicUnitShippingCost();
}
