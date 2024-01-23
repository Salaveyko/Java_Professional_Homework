package com.lab11_xmlParsers.SAXParser;

import java.util.ArrayList;

public class Address {
    private ArrayList<City> cities;

    public Address() {
        cities = new ArrayList<>();
    }

    public ArrayList<City> getCities() {
        return cities;
    }

    public void setCities(ArrayList<City> cities) {
        this.cities = cities;
    }

    public City getCity(int index) {
        return cities.get(index);
    }

    public City getLastCity() {
        return cities.get(cities.size() - 1);
    }

    public void removeCity(int index) {
        cities.remove(index);
    }

    public void addCity(City city) {
        cities.add(city);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for(City city:cities){
            str.append(city).append("\n");
        }

        return str.toString();
    }
}
