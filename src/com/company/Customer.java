package com.company;

public class Customer {

    private String name;
    private Address address;
    private Trip trip;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Trip getTrip() {
        return trip;
    }

    public void assignTrip(Trip trip) {
        this.trip = trip;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: \n");
        if (name != null) {
            sb.append("\tname: " + name);
        }
        if (address != null) {
            sb.append(",\n" + address.toString());
        }
        if (trip != null) {
            sb.append(",\n" + trip.toString());
            sb.append("\nFinal price: " + trip.getPrice().toString() + "*\n*all extra costs and discounts included");
        }
        return sb.toString();
    }
}
