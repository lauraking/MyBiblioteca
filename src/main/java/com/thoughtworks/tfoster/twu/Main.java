package com.thoughtworks.tfoster.twu;

import com.thoughtworks.tfoster.twu.options.*;
import com.thoughtworks.tfoster.twu.util.BookCollection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        books.add(new Book("Proton", "Author 1", "2001", printStream));
        books.add(new Book("Electron", "Author 2", "2002", printStream));
        books.add(new Book("Neutron", "Author 3", "2003", printStream));

        Collection<Book> checkedOutBooks = new ArrayList<>();

        Library library = new Library(new BookCollection(books), new BookCollection(checkedOutBooks));

        ArrayList<MenuOption> options = new ArrayList<>();
        options.add(new PrintLibraryOption(library));
        options.add(new CheckoutBookOption(library, printStream, reader));
        options.add(new ReturnBookOption(library, printStream, reader));

        MainMenu mainMenu = new MainMenu(printStream, reader, options);
        Biblioteca biblioteca = new Biblioteca(printStream, mainMenu);
        options.add(new QuitOption(biblioteca));

        biblioteca.start();
    }

}
