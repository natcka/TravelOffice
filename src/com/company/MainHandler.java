package com.company;

import java.util.Scanner;

public class MainHandler implements UserInterface {

    private TravelOffice travelOffice;

    private Scanner scanner = new Scanner(System.in);

    public MainHandler(TravelOffice travelOffice) {
        this.travelOffice = travelOffice;
    }

    @Override
    public Customer addCustomer() {
        System.out.println("Podaj nazwisko: ");
        String name = scanner.nextLine();
        Customer newCustomer = new Customer(name);
        return newCustomer;
    }

    @Override
    public Trip addTrip() {
        Trip newTrip = null;
        System.out.println("Wycieczka krajowa czy zagraniczna? (K/Z)");

        String s = scanner.nextLine();
        System.out.println("Podaj destynację: ");
        String destionation = scanner.nextLine();
        System.out.println("Podaj cenę: ");
        String price = scanner.nextLine();
        System.out.println("Podaj datę od (w formacie dd-MM-yyyy): ");
        String dateFrom = scanner.nextLine();
        System.out.println("Podaj datę do (w formacie dd-MM-yyyy): ");
        String dateTo = scanner.nextLine();

        if (s.equalsIgnoreCase("k")) {
            System.out.println("Podaj rabat: ");
            String discount = scanner.nextLine();
            newTrip = new DomesticTrip(Date.dateOf(dateFrom), Date.dateOf(dateTo), destionation, Long.valueOf(price), Long.valueOf(discount));
        } else if (s.equalsIgnoreCase("z")) {
            System.out.println("Podaj ubezpieczenie: ");
            String insurance = scanner.nextLine();
            newTrip = new AbroadTrip(Date.dateOf(dateFrom), Date.dateOf(dateTo), destionation, Long.valueOf(price), Long.valueOf(insurance));
        }

        return newTrip;
    }

    @Override
    public void assign() {
        System.out.println("Podaj nazwisko klienta: ");
        String name = scanner.nextLine();
        Customer customer = travelOffice.findCustomerByName(name);

        System.out.println("Podaj destynację: ");
        String destination = scanner.nextLine();
        Trip trip = travelOffice.findTripByDestination(destination);

        customer.assignTrip(trip);
    }

    @Override
    public boolean removeCustomer() {
        System.out.println("Podaj nazwisko: ");
        String name = scanner.nextLine();
        boolean result = travelOffice.removeCustomer(name);
        return result;
    }

    @Override
    public boolean removeTrip() {
        System.out.println("Podaj destynację: ");
        String destination = scanner.nextLine();
        boolean result = travelOffice.removeTrip(destination);
        return result;
    }

    @Override
    public void showCustomers() {
        travelOffice.getAllCustomers();
    }

    @Override
    public void showTrips() {
        travelOffice.getAllTrips();
    }
}
