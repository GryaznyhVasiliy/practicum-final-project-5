package ru.practicum.ShipIt;

public enum ParcelType {
    STANDARD("Стандарт"),
    FRAGILE("Хрупкий"),
    PERISHABLE("Скоропортящийся");

    private final String parcelTypeName;

    private ParcelType(String parcelTypeName) {
        this.parcelTypeName = parcelTypeName;
    }

    public String getParcelTypeName() {
        return parcelTypeName;
    }
}
