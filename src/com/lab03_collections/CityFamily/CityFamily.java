package com.lab03_collections.CityFamily;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * The task is to create a HashMap instance and fill it with data like "city"-"family".
 * Print out which family lives in which city.
 */
public class CityFamily {

    public static void main(String[] args) {
        Map<String, Family> cityFamily = new HashMap<>();

        cityFamily.put("Kyiv", new Family("Kozel"));
        cityFamily.put("Rivne", new Family("Solovey"));
        cityFamily.put("Lutsk", new Family("Rot"));
        cityFamily.put("Lviv", new Family("Karpov"));

        Set<String> keys = cityFamily.keySet();

        for (String k : keys) {
            System.out.println(k + " " + cityFamily.get(k));
        }
    }
}