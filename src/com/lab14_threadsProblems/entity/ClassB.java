package com.lab14_threadsProblems.entity;

public class ClassB {
    private int b;

    public ClassB() {}
    public ClassB(int b) {
        this.b = b;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "b = " + b;
    }
}
