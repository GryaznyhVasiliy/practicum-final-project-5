package ru.practicum.ShipIt;

public abstract class Parcel {
    protected String description;
    protected Integer weight;
    protected String deliveryAddress;
    protected Integer sendDay;

    @Override
    public String toString() {
        return "Parcel{}";
    }

    public void packageItem() {
        System.out.println("Посылка " + this.toString() + " упакована");
    }
}
