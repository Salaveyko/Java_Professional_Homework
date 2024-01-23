package com.lab15_lambda.entity;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private List<Book> books;

    public Books(){
        books = new ArrayList<>();
    }

    public void add(Book book){
        books.add(book);
    }

    public List<Book> getBooks(){
        return books;
    }

    public String printBooksAnonymously(){
        BookPrinter printer = new BookPrinter() {
            @Override
            public String print(Books books) {
                StringBuilder sb = new StringBuilder("\n--Books--");
                for(var b : books.getBooks()){
                    sb.append(b).append("\n");
                }
                return sb.toString();
            }
        };

        return printer.print(this);
    }

    public String printBooksLambda(){
        BookPrinter printer = books -> {
            StringBuilder sb = new StringBuilder("\n--Books--");
            for(var b : books.getBooks()){
                sb.append(b).append("\n");
            }
            return sb.toString();
        };

        return printer.print(this);
    }

    private interface BookPrinter{
        String print(Books books);
    }
}
