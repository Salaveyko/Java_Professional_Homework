package com.lab10_cloning.SurfaceDeppCloning;

/**
 * Create the Engine and Car classes.
 * Make object`s deep clone and shallow copy.
 * Display the difference between these methods.
 */
public class Main {
    public static void main(String[] args) {
        Engine engine = new Engine(500);
        Car audi = new Car("Audi", 300, engine);
        Car shallowClone = audi.clone();
        Car deepClone = audi.deepCloning();

        System.out.println("--Original--\n" + audi);
        System.out.println("\nIncreasing engine power up to 600.");
        engine.setHorsePower(600);

        System.out.println("\n--Shallow clone--\n" + shallowClone);
        System.out.println("\n--Deep clone--\n" + deepClone);
    }
}
