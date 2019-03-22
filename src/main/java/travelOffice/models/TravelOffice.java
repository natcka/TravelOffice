package travelOffice.models;


import travelOffice.exceptions.NoSuchCustomerException;
import travelOffice.exceptions.NoSuchTripException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TravelOffice {

    private HashSet<Customer> setOfCustomers = new HashSet<Customer>();
    private HashMap<String, Trip> mapOfTrips = new HashMap<String, Trip>();

    public boolean addCustomer(Customer newCustomer) {
        try {
            setOfCustomers.add(newCustomer);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public int getCustomerCount() {
        return setOfCustomers.size();
    }

    public HashSet<Customer> getSetOfCustomers() {
        return setOfCustomers;
    }

    public void setSetOfCustomers(HashSet<Customer> setOfCustomers) {
        this.setOfCustomers = setOfCustomers;
    }

    public HashMap<String, Trip> getMapOfTrips() {
        return mapOfTrips;
    }

    public void setMapOfTrips(HashMap<String, Trip> mapOfTrips) {
        this.mapOfTrips = mapOfTrips;
    }

    public void addTrip(String key, Trip newTrip) {
        mapOfTrips.put(key, newTrip);
    }

    public Customer findCustomerByName(String name) throws NoSuchCustomerException {
        Customer result = null;
        for (Iterator<Customer> iterator = setOfCustomers.iterator(); iterator.hasNext();) {
            Customer customer = iterator.next();
            if (customer.getSurname().equals(name)) {
                result = customer;
            }
        }
        if (result != null) {
            return result;
        } else {
            throw new NoSuchCustomerException();
        }
    }

    public void removeCustomer(String surname, String name) throws NoSuchCustomerException {
        if (!setOfCustomers.removeIf(c -> c.getName().equals(name) && c.getSurname().equals(surname))) {
            throw new NoSuchCustomerException();
        }
    }

    public void getAllCustomers() {
        setOfCustomers.forEach(c -> System.out.println(c.toString()));
    }

    public Trip findTripByDestination(String destination) throws NoSuchTripException {
        Trip result = null;
        if (mapOfTrips.get(destination) != null) {
            result = mapOfTrips.get(destination);
        } else {
            throw new NoSuchTripException();
        }
        return result;
    }

    public void removeTrip(String key) throws NoSuchTripException {
        if (mapOfTrips.containsKey(key)) {
            mapOfTrips.remove(key);
        } else {
            throw new NoSuchTripException();
        }
    }

    public void getAllTrips() {
        mapOfTrips.forEach((k, v) -> System.out.println(mapOfTrips.get(k).toString()));
    }

    public boolean assign(String surname, String destination) throws NoSuchCustomerException, NoSuchTripException {
        Customer customerByName = findCustomerByName(surname);
        Trip tripByDestination = findTripByDestination(destination);

        try {
            customerByName.assignTrip(tripByDestination);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
