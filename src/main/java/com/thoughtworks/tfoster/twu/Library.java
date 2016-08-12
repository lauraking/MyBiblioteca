package com.thoughtworks.tfoster.twu;

import java.util.Collection;

public class Library {


    private Collection<Book> books;

    public Library(Collection<Book> books) {
        this.books = books;
    }

    public void print() {
        for(Book book : books)
            book.print();
    }
}
