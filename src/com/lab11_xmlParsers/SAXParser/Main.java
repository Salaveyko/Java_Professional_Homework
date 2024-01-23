package com.lab11_xmlParsers.SAXParser;

import com.lab11_xmlParsers.builder.FileBuilder;

/**
 * Using SAXParser to read and write data from files.
 */
public class Main {
    public static void main(String[] args) {

        Street bankova = new Street("Bankova");
        bankova.addBuild(12);
        bankova.addBuild(13);
        bankova.addBuild(14);
        Street soborna = new Street("Soborna");
        soborna.addBuild(1);
        soborna.addBuild(3);
        soborna.addBuild(4);
        City kyiv = new City("Kyiv");
        kyiv.addStreet(bankova);
        kyiv.addStreet(soborna);

        Street bandery = new Street("Stepana Bandery");
        bandery.addBuild(21);
        bandery.addBuild(23);
        bandery.addBuild(25);
        City rivne = new City("Rivne");
        rivne.addStreet(bandery);
        rivne.addStreet(soborna);

        Address address = new Address();
        address.addCity(kyiv);
        address.addCity(rivne);

        System.out.println(address);

        AddressHandler handler = new AddressHandler();

        System.out.println("--Writing to the file--\n");
        handler.buildFile(FileBuilder.build("AddressOut.xml"), address);

        System.out.println("--Reading from the file--\n");
        address = handler.parseFile(FileBuilder.build("Address.xml"));
        System.out.println(address);
    }

}
