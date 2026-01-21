package ru.practicum.ShipIt;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackableParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardParcelsBox;
    private static ParcelBox<FragileParcel> fragileParcelsBox;
    private static ParcelBox<PerishableParcel> perishableParcelsBox;

    public static void main(String[] args) {
        prepareBoxes();
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    reportStatus();
                    break;
                case 5:
                    printBoxContent();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void prepareBoxes() {
        System.out.println("Перед началом работы необходимо подготовить коробки посылок");
        prepareBox(ParcelType.STANDARD);
        prepareBox(ParcelType.FRAGILE);
        prepareBox(ParcelType.PERISHABLE);
    }

    private static void prepareBox(ParcelType parcelType) {
        System.out.println("Введите максимальный вес для коробки с посылками типа " + parcelType.getParcelTypeName());
        Integer boxMaxWeight = Integer.parseInt(scanner.nextLine());
        while (boxMaxWeight < 1) {
            System.out.println("Вес не может быть меньше 1.");
            boxMaxWeight = Integer.parseInt(scanner.nextLine());
        }

        switch (parcelType) {
            case STANDARD:
                standardParcelsBox = new ParcelBox<>(parcelType, boxMaxWeight);
                break;
            case FRAGILE:
                fragileParcelsBox = new ParcelBox<>(parcelType, boxMaxWeight);
                break;
            case PERISHABLE:
                perishableParcelsBox = new ParcelBox<>(parcelType, boxMaxWeight);
                break;
            default:
                System.out.println("Ошибка.");
        }

        System.out.println("Коробка для посылок типа " + parcelType.getParcelTypeName() + " создана.");
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Отправить сообщения об изменении местоположения посылок");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    private static void reportStatus() {
        System.out.println("--- Мониторинг посылки ---");
        System.out.println("Введите новое местоположение посылки");
        String newLocation = scanner.nextLine();
        for (Trackable trackableParcel : trackableParcels) {
            trackableParcel.reportStatus(newLocation);
        }
        System.out.println("--- Мониторинг посылки ---");
    }

    private static void addParcel() {
        System.out.println("--- Добавление посылки ---");
        System.out.println("Выберите тип посылки:");
        System.out.println("1 - Стандартная посылка");
        System.out.println("2 - Хрупкая посылка");
        System.out.println("3 - Скоропортящаяся посылка");
        int parcelTypeChoice = Integer.parseInt(scanner.nextLine());
        while (parcelTypeChoice < 1 || parcelTypeChoice > 3) {
            System.out.println("Такого типа не существует. Введите цифру 1, 2 или 3.:");
            parcelTypeChoice = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Введите описание посылки (строка)");
        String parcelDescription = scanner.nextLine();

        System.out.println("Введите вес посылки (целочисленный)");
        int parcelWeight = Integer.parseInt(scanner.nextLine());
        while (parcelWeight < 0) {
            System.out.println("Вес не может быть отрицательным. Попробуйте снова");
            parcelWeight = Integer.parseInt(scanner.nextLine());
        }

        System.out.println("Введите адрес места назначения (строка)");
        String parcelDeliveryAddress = scanner.nextLine();

        System.out.println("Введите день отправки (целочисленный)");
        int parcelSendDay = Integer.parseInt(scanner.nextLine());
        while (parcelSendDay < 1 || parcelSendDay > 31) {
            System.out.println("В текущем месяце 31 день. Введите цифру от 1 до 31");
            parcelSendDay = Integer.parseInt(scanner.nextLine());
        }

        int parcelTimeToLive = 0;
        if (parcelTypeChoice == 3) {
            System.out.println("Введите срок, за который посылка испортится (целочисленный, в днях)");
            parcelTimeToLive = Integer.parseInt(scanner.nextLine());
            if (parcelTimeToLive < 0) {
                System.out.println("Невозможно перевезти посылку, которая уже испорчена. Попробуйте отправить другую посылку");
                return;
            }
        }

        Parcel parcel;
        if (parcelTypeChoice == 1) {
            parcel = new StandardParcel(parcelDescription, parcelWeight, parcelDeliveryAddress, parcelSendDay);
            standardParcelsBox.addParcel((StandardParcel) parcel);
        } else if (parcelTypeChoice == 2) {
            parcel = new FragileParcel(parcelDescription, parcelWeight, parcelDeliveryAddress, parcelSendDay);
            trackableParcels.add((Trackable) parcel);
            fragileParcelsBox.addParcel((FragileParcel) parcel);
        } else if (parcelTypeChoice == 3) {
            parcel = new PerishableParcel(parcelDescription, parcelWeight, parcelDeliveryAddress, parcelSendDay, parcelTimeToLive);
            perishableParcelsBox.addParcel((PerishableParcel) parcel);
        } else {
            System.out.println("Ошибка.");
            return;
        }

        allParcels.add(parcel);
        System.out.println("Добавлена посылка " + parcel.toString());
        System.out.println("--- Добавление посылки ---");
    }

    private static void sendParcels() {
        System.out.println("--- Отправка посылок ---");
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
        System.out.println("--- Отправка посылок ---");
    }

    private static void calculateCosts() {
        System.out.println("--- Расчёт стоимости ---");
        Integer result = 0;
        for (Parcel parcel : allParcels) {
            result += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех доставок: " + result);
        System.out.println("--- Расчёт стоимости ---");
    }

    public static void printBoxContent() {
        System.out.println("--- Вывод содержимого коробки ---");
        System.out.println("Содержимое какой коробки вы хотите вывести?");
        System.out.println("1 - Стандартной");
        System.out.println("2 - Хрупкой");
        System.out.println("3 - Скоропортящейся");
        int parcelBoxTypeChoice = Integer.parseInt(scanner.nextLine());
        while (parcelBoxTypeChoice < 1 || parcelBoxTypeChoice > 3) {
            System.out.println("Такого типа не существует. Введите цифру 1, 2 или 3.:");
            parcelBoxTypeChoice = Integer.parseInt(scanner.nextLine());
        }

        switch (parcelBoxTypeChoice) {
            case 1:
                standardParcelsBox.printBoxContent();
                break;
            case 2:
                fragileParcelsBox.printBoxContent();
                break;
            case 3:
                perishableParcelsBox.printBoxContent();
                break;
            default:
                System.out.println("Ошибка.");
        }
        System.out.println("--- Вывод содержимого коробки ---");
    }
}