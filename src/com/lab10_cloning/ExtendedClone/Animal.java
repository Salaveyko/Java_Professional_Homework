package com.lab10_cloning.ExtendedClone;

import java.io.Serializable;

public class Animal implements Serializable {
    private int weight;

    public Animal() {
    }

    public Animal(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "weight = " + weight;
    }
}
