package ru.practicum.ShipIt;

public class FragileParcel extends Parcel {
    public static final Integer BASIC_UNIT_SHIPPING_COST = 4;

    public FragileParcel(String description, Integer weight, String deliveryAddress, Integer sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + description + " обёрнута в защитную плёнку");
        super.packageItem();
    }

    @Override
    public Integer getBasicUnitShippingCost() {
        return BASIC_UNIT_SHIPPING_COST;
    }
}
