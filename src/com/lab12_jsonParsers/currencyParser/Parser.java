package com.lab12_jsonParsers.currencyParser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lab12_jsonParsers.enrtity.Currency;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static List<Currency> parseCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        try {
            URL url = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStreamReader reader = new InputStreamReader(connection.getInputStream());
                JsonArray jsonArray = new Gson().fromJson(reader, JsonArray.class);

                for (var e : jsonArray) {
                    JsonObject object = e.getAsJsonObject();
                    Currency curr = new Gson().fromJson(object, Currency.class);
                    currencies.add(curr);
                }

                reader.close();
            } else {
                throw new IOException("Failed to retrieve data from the connection. HTTP code:"
                        + connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return currencies;
    }
}
