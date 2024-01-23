package com.lab12_jsonParsers.currencyParser;

import com.lab12_jsonParsers.enrtity.Currency;

import java.util.List;


/**
 * Create a Parser class that takes currencies from the NBU API
 * (https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json)
 * Display 3 currencies on the screen.
 */
public class Main {
    public static void main(String[] args) {
        List<Currency> currencies = Parser.parseCurrencies();

        if (!currencies.isEmpty()) {
            System.out.println("--Top 3 currencies--");
            for (int i = 0; i < Math.min(currencies.size(), 3); i++) {
                System.out.println(currencies.get(i));
            }
        } else {
            System.out.println("No data...");
        }
    }
}
