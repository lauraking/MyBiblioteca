package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class CheckoutBookOption implements MenuOption {

    private Library library;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    public CheckoutBookOption(Library library, PrintStream printStream, BufferedReader bufferedReader) {
        this.library = library;
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

        String title = "";

        try {
            title = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        library.checkoutBook(title);
    }
}
