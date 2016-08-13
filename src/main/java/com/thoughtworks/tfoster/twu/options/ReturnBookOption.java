package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.Library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class ReturnBookOption implements MenuOption {

    private Library library;
    private PrintStream printStream;
    private BufferedReader reader;

    public ReturnBookOption(Library library, PrintStream printStream, BufferedReader reader) {
        this.library = library;
        this.printStream = printStream;
        this.reader = reader;
    }

    @Override
    public String title() {
        return "Return book";
    }

    @Override
    public void run() {
        printStream.println("Type in the title of the book you want to return:");

        String userInput = "";

        try {
            userInput = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(library.isBookCheckedOut(userInput)) {
            library.returnBook(userInput);
        }
    }
}
