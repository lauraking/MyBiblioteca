package com.thoughtworks.tfoster.twu;

import java.io.PrintStream;

public class MainMenu {

    private PrintStream printStream;

    public MainMenu(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void start() {
        printStream.print("List Books");


    }
}
