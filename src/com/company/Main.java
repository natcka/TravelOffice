package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static TravelOffice travelOffice = new TravelOffice();

    private static UserInterface ui = new MainHandler(travelOffice);

    private static final String menu = "MENU: \n" +
            "\t1. Dodaj klienta\n" +
            "\t2. Dodaj wycieczkę\n" +
            "\t3. Przypisz wycieczkę do klienta\n" +
            "\t4. Usuń klienta\n" +
            "\t5. Usuń wycieczkę\n" +
            "\t6. Pokaż klientów\n" +
            "\t7. Pokaż wycieczki\n" +
            "\t8. Wyjdź";

    public static void main(String[] args) {
        userMenu();
    }

    private static void userMenu() {
        int i = 0;

        do {
            System.out.println(menu);
            i = scanner.nextInt();

            switch (i) {
                case 1:
                    Customer customer = ui.addCustomer();
                    HashSet<Customer> setOfCustomers = travelOffice.getSetOfCustomers();
                    setOfCustomers.add(customer);
                    break;

                case 2:
                    Trip trip = ui.addTrip();
                    HashMap<String, Trip> mapOfTrips = travelOffice.getMapOfTrips();
                    mapOfTrips.put(trip.getDestination(), trip);
                    break;

                case 3:
                    ui.assign();
                    break;

                case 4:
                    ui.removeCustomer();
                    break;

                case 5:
                    ui.removeTrip();
                    break;

                case 6:
                    ui.showCustomers();
                    break;

                case 7:
                    ui.showTrips();
                    break;

                case 8:
                    System.exit(0);
                    break;

                default:
                    System.out.println(menu);
            }
        } while (i <= 8);
    }
}
