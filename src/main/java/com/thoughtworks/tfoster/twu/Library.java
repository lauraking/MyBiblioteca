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
        books.remove(getBookWithTitle(bookTitle));
    }

    public boolean isBookAvailable(String title) {
        return getBookWithTitle(title) != null;
    }

    private Book getBookWithTitle(String title) {
        for(Book book : books)
            if(book.hasTitle(title))
                return book;
        return null;
    }
}
