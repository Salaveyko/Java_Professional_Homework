package com.lab10_cloning.DeepCloning;

import java.io.*;

public class Bird implements Serializable, Cloneable{
    private final String color;
    private static int wings = 2;
    private transient double wingspan;

    public Bird(String color) {
        this.color = color;
    }

    public Bird(String color, double wingspan) {
        this.color = color;
        this.wingspan = wingspan;
    }

    public static int getWings() {
        return wings;
    }

    public static void setWings(int wings) {
        Bird.wings = wings;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }

    @Override
    public String toString() {
        return "Color - " + color + ", wingspan - " + wingspan + ", wings - " + wings;
    }

    @Override
    public Bird clone() {
        try {
            ByteArrayOutputStream bOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bOut);
            out.writeObject(this);

            ByteArrayInputStream bIn = new ByteArrayInputStream(bOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bIn);
            return (Bird) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
