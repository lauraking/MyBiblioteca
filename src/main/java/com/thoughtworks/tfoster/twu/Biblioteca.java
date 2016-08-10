package com.thoughtworks.tfoster.twu;

import java.io.PrintStream;
import java.util.ArrayList;

public class Biblioteca {

    private PrintStream printStream;
    private ArrayList<Book> library;
    private MainMenu mainMenu;

    public Biblioteca(PrintStream printStream, ArrayList<Book> initialLibrary, MainMenu mainMenu) {
        this.printStream = printStream;
        this.library = initialLibrary;
        this.mainMenu = mainMenu;
    }

    public void start() {
        printStream.println("Welcome!");
        printLibrary();
        mainMenu.start();
    }

    private void printLibrary() {
        for(Book book : library)
            book.print();
    }

}
