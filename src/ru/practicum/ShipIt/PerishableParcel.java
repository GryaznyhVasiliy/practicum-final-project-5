package ru.practicum.ShipIt;

public class PerishableParcel extends Parcel {
    public static final Integer BASIC_UNIT_SHIPPING_COST = 3;
    protected ParcelType parcelType = ParcelType.PERISHABLE;
    protected Integer timeToLive;

    public PerishableParcel(String description, Integer weight, String deliveryAddress, Integer sendDay, Integer timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public Integer getBasicUnitShippingCost() {
        return BASIC_UNIT_SHIPPING_COST;
    }

    public Boolean isExpired(Integer currentDay) {
        return (sendDay + timeToLive) < currentDay;
    }

    @Override
    public ParcelType getParcelType() {
        return parcelType;
    }
}
