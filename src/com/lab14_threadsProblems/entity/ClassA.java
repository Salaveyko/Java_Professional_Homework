package com.lab14_threadsProblems.entity;

public class ClassA {
    private int a;

    public ClassA() {}
    public ClassA(int a) {
        this.a = a;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "a = " + a;
    }
}
