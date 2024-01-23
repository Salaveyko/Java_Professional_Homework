package com.lab10_cloning.DeepCloning;

/**
 * Create a Bird class with static, transient and final fields.
 * Clone the object using the deep cloning method through serialization.
 */
public class Main {
    public static void main(String[] args) {
        Bird phoenix = new Bird("Orange", 9);
        Bird eagle = phoenix.clone();

        System.out.println("Phoenix:\n" + phoenix);
        System.out.println("Eagle (cloned phoenix):\n" + eagle);
        eagle.setWingspan(6);
        System.out.println("Eagle:\n" + eagle);
    }
}
