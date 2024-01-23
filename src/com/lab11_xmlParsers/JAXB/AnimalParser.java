package com.lab11_xmlParsers.JAXB;

import com.lab11_xmlParsers.builder.FileBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * Create the Animal.xml file and write an object to it using JAXB.
 * Read the file and display the read data on the screen.
 */
public class AnimalParser {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.addCat(new Cat("Marsel", 6, "Sphynx", 6));
        animal.addCat(new Cat("Murzik", 5, "Oriental", 4));

        File file = FileBuilder.build("Animal.xml");

        try {
            JAXBContext context = JAXBContext.newInstance(Animal.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(animal, file);
            System.out.println("Object written successfully into " + file.getAbsolutePath());
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            JAXBContext context = JAXBContext.newInstance(Animal.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Animal readAnimal = (Animal) unmarshaller.unmarshal(file);

            System.out.println("Data successfully read.\n" + readAnimal);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
