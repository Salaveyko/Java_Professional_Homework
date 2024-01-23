package com.lab10_cloning.SurfaceDeppCloning;

public class Engine{
    private int horsePower;

    public Engine() {
    }

    public Engine(int horsePower) {
        this.horsePower = horsePower;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "\n" + "horsePower = " + horsePower;
    }
    
    
}
