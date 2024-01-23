package com.lab15_lambda.lambda;

import com.lab15_lambda.entity.Book;
import com.lab15_lambda.entity.Books;

/**
 * Create a Book class. Implement an anonymous class and a lambda expression.
 */
public class Main {
    public static void main(String[] args) {
        Books books = new Books();
        books.add(new Book("Effective Java", "Bloch, Joshua", 419));
        books.add(new Book("Clean Code", "Martin, Robert", 451));
        books.add(new Book("Spring Microservices in Action", "Carnell, John", 471));

        System.out.println("\n\tAnonymous function" + books.printBooksAnonymously());
        System.out.println("\tLambda function" + books.printBooksLambda());
    }
}
