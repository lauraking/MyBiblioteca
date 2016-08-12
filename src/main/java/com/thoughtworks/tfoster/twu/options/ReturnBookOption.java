package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.Library;

import java.io.BufferedReader;
import java.io.IOException;

public class ReturnBookOption implements MenuOption {

    private Library library;
    private BufferedReader reader;

    public ReturnBookOption(Library library, BufferedReader reader) {
        this.library = library;
        this.reader = reader;
    }

    @Override
    public String title() {
        return "Return book";
    }

    @Override
    public void run() {

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
