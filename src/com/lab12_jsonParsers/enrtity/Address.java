package com.lab12_jsonParsers.enrtity;

public class Address {
    private String country;
    private String town;
    private String street;

    public Address() {
    }

    public Address(String country, String town, String street) {
        this.country = country;
        this.town = town;
        this.street = street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "country: " + country
                + "\ntown: " + town
                + "\nstreet: " + street;
    }
}
