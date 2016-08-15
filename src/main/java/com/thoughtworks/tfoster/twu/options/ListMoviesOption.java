package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.Library;

import java.io.BufferedReader;
import java.io.PrintStream;

public class ListMoviesOption implements MenuOption {

    private Library movieLibrary;
    private PrintStream printStream;
    private BufferedReader reader;

    public ListMoviesOption(Library movieLibrary, PrintStream printStream, BufferedReader reader) {
        this.movieLibrary = movieLibrary;
        this.printStream = printStream;
        this.reader = reader;
    }

    @Override
    public String title() {
        return "List Movies";
    }

    @Override
    public void run() {
        movieLibrary.printAvailableMedia();
    }

}
