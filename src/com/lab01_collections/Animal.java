package com.lab01_collections;

public class Animal implements Comparable<Animal> {

    String breed;
    int weight;
    int speed;
    int price;

    Animal(String breed, int weight, int speed, int price) {
        this.breed = breed;
        this.weight = weight;
        this.speed = speed;
        this.price = price;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.breed + ": " + this.weight + " " + this.speed + " " + this.price + "\t";
    }

    @Override
    public int compareTo(Animal other) {
        int tmp = this.speed - other.speed;
        if (tmp == 0) {
            tmp = this.price - other.price;
            if (tmp == 0) {
                tmp = this.weight - other.weight;
                if (tmp == 0) {
                    return this.breed.compareTo(other.breed);
                } else {
                    return tmp;
                }
            } else {
                return tmp;
            }
        } else {
            return tmp;
        }
    }
}
