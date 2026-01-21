package ru.practicum.ShipIt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExpirationTest {
    @Test
    public void shouldExpireForSendDay1TimeToLive1CurrentDay3() {
        int sendDay = 1;
        int timeToLive = 1;
        int currentDay = 3;
        PerishableParcel perishableParcel = new PerishableParcel("test", 5, "tuda", sendDay, timeToLive);

        boolean isExpired = perishableParcel.isExpired(currentDay);

        Assertions.assertTrue(isExpired);
    }

    @Test
    public void shouldNotExpireForSendDay1TimeToLive5CurrentDay4() {
        int sendDay = 1;
        int timeToLive = 5;
        int currentDay = 4;
        PerishableParcel perishableParcel = new PerishableParcel("test", 5, "tuda", sendDay, timeToLive);

        boolean isExpired = perishableParcel.isExpired(currentDay);

        Assertions.assertFalse(isExpired);
    }

    @Test
    public void shouldNotExpireForSendDay10TimeToLive10CurrentDay1() {
        int sendDay = 10;
        int timeToLive = 10;
        int currentDay = 1;
        PerishableParcel perishableParcel = new PerishableParcel("test", 5, "tuda", sendDay, timeToLive);

        boolean isExpired = perishableParcel.isExpired(currentDay);

        Assertions.assertFalse(isExpired);
    }
}
