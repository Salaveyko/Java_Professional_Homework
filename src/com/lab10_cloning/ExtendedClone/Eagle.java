package com.lab10_cloning.ExtendedClone;

import java.io.*;

public class Eagle extends Animal implements Serializable, Cloneable {
    private double wingspan;

    public Eagle() {
    }

    public Eagle(double wingspan, int weight) {
        super(weight);
        this.wingspan = wingspan;
    }

    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double wingspan) {
        this.wingspan = wingspan;
    }    

    @Override
    protected Eagle clone() {
        try{
            ByteArrayOutputStream bOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(bOut);
            out.writeObject(this);

            ByteArrayInputStream bIn = new ByteArrayInputStream(bOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(bIn);
            return (Eagle) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Eagle:\n\t" + super.toString() + "\n\twingspan = " + wingspan;
    }
}
