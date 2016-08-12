package com.thoughtworks.tfoster.twu.options;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class CheckoutBookOption implements MenuOption {

    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public CheckoutBookOption(PrintStream printStream, BufferedReader bufferedReader) {
        this.printStream = printStream;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public String title() {
        return "Checkout book";
    }

    @Override
    public void run() {
        printStream.println("Type in the title of the book you want to check out:");

        try {
            bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
