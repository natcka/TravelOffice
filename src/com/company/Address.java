package com.company;

public class Address {

    private String street;
    private String zip;
    private String city;

    public Address(String street, String zip, String city) {
        this.street = street;
        this.zip = zip;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address: \n");
        if (street != null) {
            sb.append("\tstreet: " + street);
        }
        if (city != null) {
            sb.append(",\n\tcity: " + city);
        }
        if (zip != null) {
            sb.append(",\n\tzip: " + zip);
        }
        return sb.toString();
    }
}
