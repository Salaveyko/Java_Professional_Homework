package com.lab11_xmlParsers.JAXB;

import javax.xml.bind.annotation.XmlElement;

public class Cat {
    private String name;
    private int age;
    private String breed;
    private int weight;

    public Cat() {
    }

    public Cat(String name, int age, String breed, int weight) {
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.weight = weight;
    }

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @XmlElement(name = "breed")
    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    @XmlElement(name = "weight")
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "name = " + name +
                ", age = " + age +
                ", breed = " + breed +
                ", weight = " + weight;
    }
}
