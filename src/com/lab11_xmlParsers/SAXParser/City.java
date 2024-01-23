package com.lab11_xmlParsers.SAXParser;

import java.util.ArrayList;

public class City {
    private ArrayList<Street> streets;
    private String name;

    public City() {
        this("");
    }

    public City(String name) {
        this.name = name;
        streets = new ArrayList<>();
    }

    public ArrayList<Street> getStreets() {
        return streets;
    }

    public void setStreets(ArrayList<Street> streets) {
        this.streets = streets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Street getStreet(int index) {
        return streets.get(index);
    }

    public Street getLastStreet() {
        return streets.get(streets.size() - 1);
    }

    public void removeStreet(int index) {
        streets.remove(index);
    }

    public void addStreet(Street street) {
        streets.add(street);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(name).append("\nStreets:");
        for (Street street : streets) {
            str.append("\n\t").append(street);
        }
        return str.toString();
    }
}
