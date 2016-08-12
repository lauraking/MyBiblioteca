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

    public void checkoutBook(String bookTitle) {
        for(Book book : books) {
            if(book.hasTitle(bookTitle)) {
                books.remove(book);
                return;
            }
        }
    }
}
