package ru.practicum.ShipIt;

public class FragileParcel extends Parcel implements Trackable {
    public static final Integer BASIC_UNIT_SHIPPING_COST = 4;
    protected ParcelType parcelType = ParcelType.FRAGILE;

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

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation);
    }

    @Override
    public ParcelType getParcelType() {
        return parcelType;
    }
}
