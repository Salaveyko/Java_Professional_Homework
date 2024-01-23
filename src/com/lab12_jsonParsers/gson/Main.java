package com.lab12_jsonParsers.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.lab12_jsonParsers.builder.FileBuilder;
import com.lab12_jsonParsers.enrtity.Address;
import com.lab12_jsonParsers.enrtity.Addresses;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Write the Address object to a .json file, and then read the data using Gson.
 * Display the results on the screen.
 */
public class Main {
    public static void main(String[] args) {
        Addresses addresses = new Addresses();
        addresses.add(new Address("USA", "New York", "Independence"));
        addresses.add(new Address("UK", "London", "Oxford"));
        addresses.add(new Address("Ukraine", "Kyiv", "Soborna"));

        System.out.println(addresses);

        File file = FileBuilder.build("gsonAddresses.json");

        if (writeToJson(addresses, file)) {
            System.out.println("Data has been successfully written.\n" + file.getAbsolutePath());
        }

        Addresses readAddresses = readFromJson(file);
        if (!readAddresses.isEmpty()) {
            System.out.println("\nFile was successfully read.\n" + readAddresses);
        }
    }

    private static Addresses readFromJson(File file) {
        Addresses addresses = null;
        try (FileReader reader = new FileReader(file)) {
            Gson gson = new Gson();
            Type type = new TypeToken<List<Address>>() {
            }.getType();
            addresses = new Addresses(gson.fromJson(reader, type));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return addresses;
    }

    private static boolean writeToJson(Addresses addresses, File file) {
        try (FileWriter writer = new FileWriter(file)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(addresses.getAddresses(), writer);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
