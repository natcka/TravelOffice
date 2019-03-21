package travelOffice;

import travelOffice.models.Customer;
import travelOffice.models.Trip;

public interface UserInterface {

    Customer addCustomer();

    Trip addTrip();

    void assign();

    void removeCustomer();

    void removeTrip();

    void showCustomers();

    void showTrips();
}
