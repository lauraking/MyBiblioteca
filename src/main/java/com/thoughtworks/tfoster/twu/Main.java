package com.thoughtworks.tfoster.twu;

import java.io.PrintStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> initialLibrary = new ArrayList<>();
        PrintStream printStream = System.out;

        initialLibrary.add(new Book("Book 147238426738423764", "Author 1", "2001", printStream));
        initialLibrary.add(new Book("Book 2", "Author 2", "2002", printStream));
        initialLibrary.add(new Book("Book 3", "Author 3", "2003", printStream));

        Biblioteca biblioteca = new Biblioteca(printStream, initialLibrary, new MainMenu(printStream));
        biblioteca.start();
    }

}
