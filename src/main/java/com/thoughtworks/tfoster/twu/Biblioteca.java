package com.thoughtworks.tfoster.twu;

import java.io.PrintStream;
import java.util.Collection;

public class Biblioteca {

    private PrintStream printStream;
    private Collection<Book> library;
    private MainMenu mainMenu;

    public Biblioteca(PrintStream printStream, Collection<Book> initialLibrary, MainMenu mainMenu) {
        this.printStream = printStream;
        this.library = initialLibrary;
        this.mainMenu = mainMenu;
    }

    public void start() {
        printStream.println("Welcome!");
        mainMenu.showMenu();
        mainMenu.processUserSelection();
    }

}
