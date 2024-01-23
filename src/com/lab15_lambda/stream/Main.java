package com.lab15_lambda.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Create a list of integers of size 10, fill it randomly.
 * Using StreamAPI, find the sum of squares of all elements.
 */
public class Main {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            integers.add(new Random().nextInt(201) - 100);
        }

        integers.forEach(System.out::println);

        double sum = integers.stream()
                .map(i -> (Math.pow(i, 2)))
                .reduce(0d, Double::sum);

        System.out.println(sum);
    }
}
