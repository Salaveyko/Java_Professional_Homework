package com.lab11_xmlParsers.SAXParser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class AddressHandler extends DefaultHandler {
    private static final String ADDRESS = "address";
    private static final String CITIES = "cities";
    private static final String CITY = "city";
    private static final String CITY_NAME = "city_name";
    private static final String STREET = "street";
    private static final String STREET_NAME = "street_name";
    private static final String BUILD = "build";

    private Address address;
    private StringBuilder value;

    public boolean buildFile(File file, Address address) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");

            transformer.transform(
                    new StreamSource(new StringReader(createXMLStream(address))),
                    new StreamResult(file));

            return true;
        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    public String createXMLStream(Address address) {
        StringBuilder xmlStream = new StringBuilder();
        xmlStream.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        xmlStream.append("<").append(ADDRESS).append(">");
        xmlStream.append("<").append(CITIES).append(">");

        for (var c : address.getCities()) {
            xmlStream.append("<").append(CITY).append(">");
            xmlStream.append("<").append(CITY_NAME).append(">")
                    .append(c.getName())
                    .append("</").append(CITY_NAME).append(">");

            for (var s : c.getStreets()) {
                xmlStream.append("<").append(STREET).append(">");
                xmlStream.append("<").append(STREET_NAME).append(">")
                        .append(s.getName())
                        .append("</").append(STREET_NAME).append(">");

                for (var b : s.getBuilds()) {
                    xmlStream.append("<").append(BUILD).append(">")
                            .append(b)
                            .append("</").append(BUILD).append(">");
                }
                xmlStream.append("</").append(STREET).append(">");
            }
            xmlStream.append("</").append(CITY).append(">");
        }
        xmlStream.append("</").append(CITIES).append(">");
        xmlStream.append("</").append(ADDRESS).append(">");

        return xmlStream.toString();
    }

    public Address parseFile(File file) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(file, this);
            return address;
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (value == null) {
            value = new StringBuilder();
        } else {
            value.append(ch, start, length);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        address = new Address();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch (qName) {
            case CITIES:
                address.setCities(new ArrayList<>());
                break;
            case CITY:
                address.addCity(new City());
                break;
            case CITY_NAME:
            case STREET_NAME:
            case BUILD:
                value = new StringBuilder();
                break;
            case STREET:
                City c = address.getLastCity();
                c.addStreet(new Street());
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName) {
            case CITY_NAME:
                address.getLastCity().setName(value.toString());
                break;
            case STREET_NAME:
                address.getLastCity().getLastStreet().setName(value.toString());
                break;
            case BUILD:
                address.getLastCity().getLastStreet().addBuild(Integer.parseInt(value.toString()));
                break;
        }
    }

    public Address getAddress() {
        return address;
    }
}
