package com.thoughtworks.tfoster.twu;

import com.thoughtworks.tfoster.twu.options.MenuOption;
import com.thoughtworks.tfoster.twu.options.PrintLibraryOption;
import com.thoughtworks.tfoster.twu.options.QuitOption;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> initialLibrary = new ArrayList<>();
        PrintStream printStream = System.out;

        initialLibrary.add(new Book("Book 147238426738423764", "Author 1", "2001", printStream));
        initialLibrary.add(new Book("Book 2", "Author 2", "2002", printStream));
        initialLibrary.add(new Book("Book 3", "Author 3", "2003", printStream));

        ArrayList<MenuOption> options = new ArrayList<>();
        options.add(new PrintLibraryOption(initialLibrary));


        MainMenu mainMenu = new MainMenu(printStream, new BufferedReader(new InputStreamReader(System.in)), options);
        Biblioteca biblioteca = new Biblioteca(printStream, initialLibrary, mainMenu);
        options.add(new QuitOption(biblioteca));

        biblioteca.start();
    }

}
