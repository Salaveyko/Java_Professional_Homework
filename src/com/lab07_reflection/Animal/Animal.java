package com.lab07_reflection.Animal;

class Animal {

    private int id;
    protected int paws;
    public String name;

    public Animal(int id) {
        this.id = id;
    }

    public Animal(int id, int paws) {
        this.id = id;
        this.paws = paws;
    }

    public Animal(int id, int paws, String name) {
        this.id = id;
        this.paws = paws;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getPaws() {
        return paws;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPaws(int paws) {
        this.paws = paws;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID:\t" + id + "\nName:\t" + name + "\nPaws:\t" + paws;
    }
}
