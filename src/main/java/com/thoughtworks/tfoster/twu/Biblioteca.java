package com.thoughtworks.tfoster.twu;

import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {

    private PrintStream printStream;
    private ArrayList<Book> library;

    public Biblioteca(PrintStream printStream, ArrayList<Book> initialLibrary) {
        this.printStream = printStream;
        this.library = initialLibrary;
    }

    public void start() {
        printStream.println("Welcome!");
        printLibrary();
    }

    private void printLibrary() {
        for(Book book : library)
            book.print();
    }
}
