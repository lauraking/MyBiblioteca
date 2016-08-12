package com.thoughtworks.tfoster.twu;

import java.io.PrintStream;

public class Biblioteca {

    private PrintStream printStream;
    private MainMenu mainMenu;
    private boolean running;

    public Biblioteca(PrintStream printStream, MainMenu mainMenu) {
        this.printStream = printStream;
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
