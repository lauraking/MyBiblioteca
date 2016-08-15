package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.Library;

public class ListBooksOption implements MenuOption {

    private Library library;

    public ListBooksOption(Library library) {
        this.library = library;
    }

    @Override
    public String title() {
        return "List Books";
    }

    @Override
    public void run() {
        library.print();
    }
}
