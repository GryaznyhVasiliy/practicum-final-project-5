package ru.practicum.ShipIt;

public class StandardParcel extends Parcel {
    public static final Integer BASIC_UNIT_SHIPPING_COST = 2;

    public StandardParcel(String description, Integer weight, String deliveryAddress, Integer sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public Integer getBasicUnitShippingCost() {
        return BASIC_UNIT_SHIPPING_COST;
    }
}
