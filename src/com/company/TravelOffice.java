package com.company;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class TravelOffice {

    private HashSet<Customer> setOfCustomers = new HashSet<>();
    private HashMap<String, Trip> mapOfTrips = new HashMap<>();

    private void addCustomer(Customer newCustomer) {
        setOfCustomers.add(newCustomer);
    }

    private String getInfo(Customer[] arrayOfCustomers) {
        StringBuilder sb = new StringBuilder();
        for (Customer customer : arrayOfCustomers) {
            sb.append(customer.toString() + "\n");
            sb.append("\n-----\n");
        }
        return sb.toString();
    }

    public int getCustomerCount() {
        return setOfCustomers.size();
    }

    public HashSet<Customer> getSetOfCustomers() {
        return setOfCustomers;
    }

    private void setSetOfCustomers(HashSet<Customer> setOfCustomers) {
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

    public boolean removeTrip(String key) {
        if (mapOfTrips.containsKey(key)) {
            mapOfTrips.remove(key);
            return true;
        }
        return false;
    }

    public Customer findCustomerByName(String name) {
        for (Iterator<Customer> iterator = setOfCustomers.iterator(); iterator.hasNext();) {
            Customer customer = iterator.next();
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

    public boolean removeCustomer(String name) {
        for (Iterator<Customer> iterator = setOfCustomers.iterator(); iterator.hasNext();) {
            Customer customer = iterator.next();
            if (customer.getName().equals(name)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public void getAllCustomers() {
        System.out.println(setOfCustomers);
    }

    public Trip findTripByDestination(String destination) {
        Trip result = null;
        if (mapOfTrips.get(destination) != null) {
            result = mapOfTrips.get(destination);
        } else {
            throw new NullPointerException("Nie ma takiej destynacji!");
        }
        return result;
    }

    public void getAllTrips() {
        System.out.println(mapOfTrips);
    }
}
