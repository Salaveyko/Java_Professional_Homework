package com.lab07_reflection.ClassInfo;

import java.lang.reflect.Member;
import java.util.Scanner;

/**
 * The program gets all members of the entered class using reflection and prints them.
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            System.out.print("\nEnter the full name of class ('e' - exit): ");
            String clazz = new Scanner(System.in).nextLine();

            if (clazz.equals("e")) break;

            try {
                Class<?> cl = Class.forName(clazz);

                System.out.println("\nFields:".toUpperCase());
                printMembers(cl.getDeclaredFields());
                System.out.println("\nConstructors:".toUpperCase());
                printMembers(cl.getDeclaredConstructors());
                System.out.println("\nMethods:".toUpperCase());
                printMembers(cl.getDeclaredMethods());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void printMembers(Member[] members) {
        for (Member m : members) {
            System.out.println(m);
        }
    }
}
