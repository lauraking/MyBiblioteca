package com.thoughtworks.tfoster.twu;

import com.thoughtworks.tfoster.twu.options.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        ArrayList<MediaItem> availableBooks = new ArrayList<>();
        PrintStream printStream = System.out;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MediaItemDetails bookItemDetails = new MediaItemDetails();
        availableBooks.add(new MediaItem("Proton", bookItemDetails, printStream));
        availableBooks.add(new MediaItem("Electron", bookItemDetails, printStream));
        availableBooks.add(new MediaItem("Neutron", bookItemDetails, printStream));

        Collection<MediaItem> checkedOutBooks = new ArrayList<>();

        Collection<MediaItem> availableMovies = new ArrayList<>();
        Collection<MediaItem> checkedOutMovies = new ArrayList<>();

        Library bookLibrary = new Library(new MediaCollection(availableBooks), new MediaCollection(checkedOutBooks));
        Library movieLibrary = new Library(new MediaCollection(availableMovies), new MediaCollection(checkedOutMovies));


        ArrayList<MenuOption> options = new ArrayList<>();
        options.add(new ListBooksOption(bookLibrary));
        options.add(new CheckoutBookOption(bookLibrary, printStream, reader));
        options.add(new ReturnBookOption(bookLibrary, printStream, reader));
        options.add(new ListMoviesOption(movieLibrary, printStream, reader));

        MainMenu mainMenu = new MainMenu(printStream, reader, options);
        Biblioteca biblioteca = new Biblioteca(printStream, mainMenu);
        options.add(new QuitOption(biblioteca));

        biblioteca.start();
    }



}
