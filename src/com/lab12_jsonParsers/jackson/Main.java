package com.lab12_jsonParsers.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.lab12_jsonParsers.builder.FileBuilder;
import com.lab12_jsonParsers.enrtity.Address;
import com.lab12_jsonParsers.enrtity.Addresses;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Write the Address object to a .json file, and then read the data using Jackson.
 * Display the results on the screen.
 */
public class Main {
    public static void main(String[] args) {
        Addresses addresses = new Addresses();

        addresses.add(new Address("Ukraine", "Rivne", "Soborna"));
        addresses.add(new Address("Ukraine", "Lviv", "Stepana Bandery"));
        addresses.add(new Address("Poland", "Warsaw", "Koscielna"));

        System.out.println(addresses);

        File file = FileBuilder.build("jacksonAddresses.json");

        if (writeToJson(addresses.getAddresses(), file)) {
            System.out.println("Data has been successfully written.\n" + file.getAbsolutePath());
        }

        Addresses readAddresses = new Addresses(readFromJson(file));
        if (!readAddresses.isEmpty()) {
            System.out.println("\nFile was successfully read.\n" + readAddresses);
        }
    }

    private static boolean writeToJson(List<Address> addresses, File file) {
        try {
            ObjectWriter writer = new ObjectMapper().writerWithDefaultPrettyPrinter();
            writer.writeValue(file, addresses);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static List<Address> readFromJson(File file) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(file, new TypeReference<List<Address>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
