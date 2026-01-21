package ru.practicum.ShipIt;

import java.util.ArrayList;

public class ParcelBox<T extends Parcel> {
    protected ArrayList<T> parcels;
    protected ParcelType parcelType;
    protected Integer maxWeight;

    public ParcelBox(ParcelType parcelType, Integer maxWeight) {
        this.parcels = new ArrayList<>();
        this.parcelType = parcelType;
        this.maxWeight = maxWeight;
    }

    public ParcelType getBoxParcelType() {
        return parcelType;
    }

    public Integer calculateBoxWeight() {
        Integer result = 0;
        for (T parcel : parcels) {
            result += parcel.getWeight();
        }
        return result;
    }

    public boolean addParcel(T parcel) {
        ParcelType boxParcelType = getBoxParcelType();
        ParcelType incomingParcelType = parcel.getParcelType();
        Integer parcelWeight = parcel.getWeight();
        Integer boxWeight = calculateBoxWeight();

        if (incomingParcelType != boxParcelType) {
            System.out.println("Невозможно добавить посылку типа " + incomingParcelType + " в коробку с посылками типа " + boxParcelType);
            return false;
        }
        if (parcelWeight > (maxWeight - boxWeight)) {
            System.out.println("Посылка слишком тяжёлая для этой коробки. Посылка весит " + parcelWeight
                                + ". Однако в коробку можно поместить ещё не больше " + (maxWeight - boxWeight)
                                + ". Отмена операции.");
            return false;
        }

        parcels.add(parcel);
        return true;
    }

    //А зачем этот метод вообще просят в ТЗ? Его ведь негде использвоать
    public ArrayList<T> getAllParcels() {
        return parcels;
    }

    public void printBoxContent() {
        System.out.println("Содержимое коробки типа " + parcelType.getParcelTypeName() + ":");
        for (T parcel : parcels) {
            System.out.println(parcel.toString());
        }
    }
}