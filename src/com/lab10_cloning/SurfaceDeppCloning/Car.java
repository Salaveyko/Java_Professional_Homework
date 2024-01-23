package com.lab10_cloning.SurfaceDeppCloning;

public class Car implements Cloneable{
    private String mark;
    private int speed;
    private Engine engine;

    public Car() {
    }

    public Car(String mark, int speed, Engine engine) {
        this.mark = mark;
        this.speed = speed;
        this.engine = engine;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public Car deepCloning() {
        Car clone = this.clone();
        clone.engine = new Engine(engine.getHorsePower());
        
        return clone;
    }     

    @Override
    public String toString() {
        return "Mark = " + mark + "\nSpeed = " + speed + "\nEngine : " + engine;
    }
    
    
}
