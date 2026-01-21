package ru.practicum.ShipIt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddParcelToBoxTest {
    @Test
    public void shouldAllowToAddForIncomingParcelWeight5MaxBoxWeight10CurrentBoxWeight2() {
        int incomingParcelWeight = 5;
        int maxBoxWeight = 10;
        int currentBoxWeight = 2;
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(ParcelType.STANDARD, maxBoxWeight);
        StandardParcel standardParcel = new StandardParcel("test", currentBoxWeight, "tuda", 1);
        parcelBox.addParcel(standardParcel);
        StandardParcel incomingParcel = new StandardParcel("test", incomingParcelWeight, "tuda", 1);

        boolean allowedToAdd = parcelBox.addParcel(incomingParcel);

        Assertions.assertTrue(allowedToAdd);
    }

    @Test
    public void shouldAllowToAddForIncomingParcelWeight15MaxBoxWeight20CurrentBoxWeight5() {
        int incomingParcelWeight = 15;
        int maxBoxWeight = 20;
        int currentBoxWeight = 5;
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(ParcelType.STANDARD, maxBoxWeight);
        StandardParcel standardParcel = new StandardParcel("test", currentBoxWeight, "tuda", 1);
        parcelBox.addParcel(standardParcel);
        StandardParcel incomingParcel = new StandardParcel("test", incomingParcelWeight, "tuda", 1);

        boolean allowedToAdd = parcelBox.addParcel(incomingParcel);

        Assertions.assertTrue(allowedToAdd);
    }

    @Test
    public void shouldNotAllowToAddForIncomingParcelWeight50MaxBoxWeight50CurrentBoxWeight50() {
        int incomingParcelWeight = 50;
        int maxBoxWeight = 50;
        int currentBoxWeight = 50;
        ParcelBox<StandardParcel> parcelBox = new ParcelBox<>(ParcelType.STANDARD, maxBoxWeight);
        StandardParcel standardParcel = new StandardParcel("test", currentBoxWeight, "tuda", 1);
        parcelBox.addParcel(standardParcel);
        StandardParcel incomingParcel = new StandardParcel("test", incomingParcelWeight, "tuda", 1);

        boolean allowedToAdd = parcelBox.addParcel(incomingParcel);

        Assertions.assertFalse(allowedToAdd);
    }
}
