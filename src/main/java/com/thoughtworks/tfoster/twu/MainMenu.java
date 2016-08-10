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

    public void processUserSelection() {
        printStream.print("\n> ");

        try {
            String userInput = reader.readLine();
            if(isValidMenuSelection(userInput))
                options.get(Integer.parseInt(userInput) - 1).run();
            else
                printStream.println("Select a valid option!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidMenuSelection(String selection) {
        if(selection.matches("\\d+")) {
            int numericSelection = Integer.parseInt(selection);
            return 0 < numericSelection && numericSelection <= options.size();
        }
        else
            return false;
    }
}
