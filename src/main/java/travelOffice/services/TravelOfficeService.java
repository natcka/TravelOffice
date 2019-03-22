package travelOffice.services;

import travelOffice.exceptions.NoSuchCustomerException;
import travelOffice.exceptions.NoSuchTripException;
import travelOffice.models.Customer;
import travelOffice.models.TravelOffice;
import travelOffice.models.Trip;

import java.util.HashMap;
import java.util.HashSet;

public class TravelOfficeService {

    private TravelOffice travelOffice;

    public TravelOfficeService(TravelOffice travelOffice) {
        this.travelOffice = travelOffice;
    }

    public boolean addCustomer(Customer customer) {
        return travelOffice.addCustomer(customer);
    }

    public Customer findCustomerByName(String name) throws NoSuchCustomerException {
        return travelOffice.findCustomerByName(name);
    }

    public void removeCustomer(String surname, String name) throws NoSuchCustomerException {
        travelOffice.removeCustomer(surname, name);
    }

    public void getAllCustomers() {
        travelOffice.getAllCustomers();
    }

    public Trip findTripByDestination(String destination) throws NoSuchTripException {
        return travelOffice.findTripByDestination(destination);
    }

    public void removeTrip(String key) throws NoSuchTripException {
        travelOffice.removeTrip(key);
    }

    public void getAllTrips() {
        travelOffice.getAllTrips();
    }

    public HashSet<Customer> getSetOfCustomers() {
        return travelOffice.getSetOfCustomers();
    }

    public HashMap<String, Trip> getMapOfTrips() {
        return travelOffice.getMapOfTrips();
    }

    public boolean assign(String surname, String description) throws NoSuchTripException, NoSuchCustomerException {
        return travelOffice.assign(surname, description);
    }
}
