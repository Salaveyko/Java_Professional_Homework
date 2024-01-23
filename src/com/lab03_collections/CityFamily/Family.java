package com.lab03_collections.CityFamily;

class Family {

    private String surname;

    public Family(String n) {
        surname = n;
    }

    @Override
    public String toString() {
        return surname.toUpperCase();
    }
}
