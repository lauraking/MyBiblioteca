package com.thoughtworks.tfoster.twu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

public class MainMenu {

    private PrintStream printStream;
    private BufferedReader reader;
    private ArrayList<MenuOption> options;

    public MainMenu(PrintStream printStream, BufferedReader reader, ArrayList<MenuOption> options) {
        this.printStream = printStream;
        this.reader = reader;
        this.options = options;
    }

    public void showMenu() {
        printStream.print("1: List Books");


    }

    public void userOptionSelection() {

        try {
            options.get(Integer.parseInt(reader.readLine()) - 1).run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
