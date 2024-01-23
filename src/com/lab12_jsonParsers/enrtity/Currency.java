package com.lab12_jsonParsers.enrtity;

public class Currency {
    private String r030;
    private String txt;
    private double rate;

    public String getR030() {
        return r030;
    }

    public String getTxt() {
        return txt;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "\nr030 = " + r030
                + "\ntxt = " + txt
                + "\nrate = " + rate;
    }
}
