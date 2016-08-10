package com.thoughtworks.tfoster.twu;

import java.util.Collection;

public class PrintLibraryOption implements MenuOption {

    private Collection<Book> books;

    public PrintLibraryOption(Collection<Book> books) {
        this.books = books;
    }

    @Override
    public void run() {
        for (Book book : books){
            book.print();
        }
    }
}
