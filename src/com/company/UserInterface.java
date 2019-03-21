package com.company;

public interface UserInterface {

    Customer addCustomer();

    Trip addTrip();

    void assign();

    boolean removeCustomer();

    boolean removeTrip();

    void showCustomers();

    void showTrips();
}
