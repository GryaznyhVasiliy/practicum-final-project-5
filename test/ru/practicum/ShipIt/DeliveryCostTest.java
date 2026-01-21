package ru.practicum.ShipIt;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DeliveryCostTest {
    @Test
    public void shouldCost10ForStandardParcelAnd5Weight() {
        Parcel standardParcel = new StandardParcel("test", 5, "tuda", 1);

        int current = standardParcel.calculateDeliveryCost();
        int expected = 10;

        Assertions.assertEquals(expected, current);
    }

    @Test
    public void shouldCost20ForStandardParcelAnd10Weight() {
        Parcel standardParcel = new StandardParcel("test", 10, "tuda", 1);

        int current = standardParcel.calculateDeliveryCost();
        int expected = 20;

        Assertions.assertEquals(expected, current);
    }

    @Test
    public void shouldReturnNullForStandardParcelAnd0Weight() {
        Parcel standardParcel = new StandardParcel("test", 0, "tuda", 1);

        Integer current = standardParcel.calculateDeliveryCost();

        Assertions.assertNull(current);
    }

    @Test
    public void shouldCost20ForFragileParcelAnd5Weight() {
        Parcel fragileParcel = new FragileParcel("test", 5, "tuda", 1);

        int current = fragileParcel.calculateDeliveryCost();
        int expected = 20;

        Assertions.assertEquals(expected, current);
    }

    @Test
    public void shouldCost40ForFragileParcelAnd10Weight() {
        Parcel fragileParcel = new FragileParcel("test", 10, "tuda", 1);

        int current = fragileParcel.calculateDeliveryCost();
        int expected = 40;

        Assertions.assertEquals(expected, current);
    }

    @Test
    public void shouldReturnNullForFragileParcelAnd0Weight() {
        Parcel fragileParcel = new FragileParcel("test", 0, "tuda", 1);

        Integer current = fragileParcel.calculateDeliveryCost();

        Assertions.assertNull(current);
    }

    @Test
    public void shouldCost15ForPerishableParcelAnd5Weight() {
        Parcel perishableParcel = new PerishableParcel("test", 5, "tuda", 1, 5);

        int current = perishableParcel.calculateDeliveryCost();
        int expected = 15;

        Assertions.assertEquals(expected, current);
    }

    @Test
    public void shouldCost30ForPerishableParcelAnd10Weight() {
        Parcel perishableParcel = new PerishableParcel("test", 10, "tuda", 1, 5);

        int current = perishableParcel.calculateDeliveryCost();
        int expected = 30;

        Assertions.assertEquals(expected, current);
    }

    @Test
    public void shouldReturnNullForPerishableParcelAnd0Weight() {
        Parcel perishableParcel = new PerishableParcel("test", 0, "tuda", 1, 5);

        Integer current = perishableParcel.calculateDeliveryCost();

        Assertions.assertNull(current);
    }
}
