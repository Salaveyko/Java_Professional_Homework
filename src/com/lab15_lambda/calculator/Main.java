package com.lab15_lambda.calculator;

import java.util.function.BinaryOperator;

/**
 * Create a calculator that performs simple math operations using lambda.
 */
public class Main {
    private static final BinaryOperator<Double> add = Double::sum;
    private static final BinaryOperator<Double> sub = (a, b) -> a - b;
    private static final BinaryOperator<Double> mul = (a, b) -> a * b;
    private static final BinaryOperator<Double> div = (a, b) -> {
        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Error: division by zero.");
        }
    };

    public static void main(String[] args) {
        double x = 12;
        double y = 6;

        System.out.printf("%f + %f = %f%n", x, y, add.apply(x, y));
        System.out.printf("%f - %f = %f%n", x, y, sub.apply(x, y));
        System.out.printf("%f * %f = %f%n", x, y, mul.apply(x, y));
        System.out.printf("%f / %f = %f%n", x, y, div.apply(x, y));
    }
}
