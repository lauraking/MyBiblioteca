package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.Book;

import java.util.Collection;

public class PrintLibraryOption implements MenuOption {

    private Collection<Book> books;

    public PrintLibraryOption(Collection<Book> books) {
        this.books = books;
    }

    @Override
    public String title() {
        return "List Books";
    }

    @Override
    public void run() {
        for (Book book : books){
            book.print();
        }
    }
}
