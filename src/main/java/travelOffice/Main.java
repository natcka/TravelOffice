package travelOffice;

import travelOffice.models.AbroadTrip;
import travelOffice.models.Customer;
import travelOffice.models.TravelOffice;
import travelOffice.models.Trip;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static TravelOffice travelOffice = new TravelOffice();

    private static UserInterface ui = new MainHandler(travelOffice);

    public static Logger logger = Logger.getLogger("com.company.TravelOffice");

    private static final String menu = "\nMENU: \n" +
            "\t1. Dodaj klienta\n" +
            "\t2. Dodaj wycieczkę\n" +
            "\t3. Przypisz wycieczkę do klienta\n" +
            "\t4. Usuń klienta\n" +
            "\t5. Usuń wycieczkę\n" +
            "\t6. Pokaż klientów\n" +
            "\t7. Pokaż wycieczki\n" +
            "\t8. Wyjdź";

    public static void main(String[] args) throws IOException {
        logger.setUseParentHandlers(false);
        FileHandler fileHandler = new FileHandler("log.txt");
        fileHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(fileHandler);

        logger.info("Uruchamiam aplikację");
        userMenu();
    }

    private static void userMenu() {
        int i = 0;

        do {
            System.out.println(menu);
            try {
                i = scanner.nextInt();
            } catch (InputMismatchException ex) {
                logger.severe(ex.getLocalizedMessage());
            }

            switch (i) {
                case 1:
                    Customer customer = ui.addCustomer();
                    HashSet<Customer> setOfCustomers = travelOffice.getSetOfCustomers();
                    setOfCustomers.add(customer);
                    System.out.println("Dodano klienta [nazwisko= " + customer.getSurname() + ", imię= " + customer.getName() + "]");
                    break;

                case 2:
                    Trip trip = null;
                    try {
                        trip = ui.addTrip();
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getLocalizedMessage());
                        break;
                    }
                    HashMap<String, Trip> mapOfTrips = travelOffice.getMapOfTrips();
                    mapOfTrips.put(trip.getDestination(), trip);
                    System.out.println("Dodano wycieczkę " + (trip instanceof AbroadTrip ? "zagraniczną " : "krajową ")
                            + "[destynacja= " + trip.getDestination() + "]");
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
                    System.out.println("\nLISTA KLIENTÓW");
                    ui.showCustomers();
                    break;

                case 7:
                    System.out.println("\nLISTA WYCIECZEK");
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