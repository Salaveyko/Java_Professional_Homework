package com.lab12_jsonParsers.enrtity;

import java.util.ArrayList;
import java.util.List;

public class Addresses {
    private List<Address> addresses;

    public Addresses() {
        addresses = new ArrayList<>();
    }

    public Addresses(List<Address> addresses) {
        if (addresses == null) addresses = new ArrayList<>();
        this.addresses = addresses;
    }

    public void add(Address address) {
        addresses.add(address);
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public boolean isEmpty(){
        return addresses.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n--addresses--");
        for (var a : addresses) {
            sb.append("\n").append(a).append("\n");
        }
        return sb.toString();
    }
}
