package com.thoughtworks.tfoster.twu;

import java.io.PrintStream;
import java.util.Collection;

public class Biblioteca {

    private PrintStream printStream;
    private Collection<Book> library;
    private MainMenu mainMenu;
    private boolean running;

    public Biblioteca(PrintStream printStream, Collection<Book> initialLibrary, MainMenu mainMenu) {
        this.printStream = printStream;
        this.library = initialLibrary;
        this.mainMenu = mainMenu;
    }

    public void start() {
        running = true;
        printStream.println("Welcome!");

        while(isRunning()) {
            mainMenu.showMenu();
            mainMenu.processUserSelection();
        }
    }

    public void quit() {
        running = false;
    }

    private boolean isRunning() {
        return running;
    }
}
