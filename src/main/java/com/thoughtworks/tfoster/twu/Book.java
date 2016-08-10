package com.thoughtworks.tfoster.twu;

import java.io.PrintStream;

public class Book {

    private String title;
    private String author;
    private String yearPublished;
    private PrintStream printStream;

    public Book(String title, String author, String yearPublished, PrintStream printStream) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.printStream = printStream;
    }

    public void print() {
        printStream.print(title);
        printStream.print(" | ");
        printStream.print(author);
        printStream.print(" | ");
        printStream.print(yearPublished);
        printStream.print("\n");
    }
}
