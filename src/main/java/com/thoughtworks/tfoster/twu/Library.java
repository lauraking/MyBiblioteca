package com.thoughtworks.tfoster.twu;

import java.util.Collection;

public class Library {

    private Collection<Book> books;
    private Collection<Book> checkedOutBooks;

    public Library(Collection<Book> books, Collection<Book> checkedOutBooks) {
        this.books = books;
        this.checkedOutBooks = checkedOutBooks;
    }

    public void print() {
        for(Book book : books)
            book.print();
    }

    public void checkoutBook(String bookTitle) {
        books.remove(getBookWithTitle(bookTitle));
    }

    public void returnBook(String bookTitle) {

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

    public boolean isBookCheckedOut(String title) {
        for(Book book : checkedOutBooks) {
            if(book.hasTitle(title))
                return true;
        }
        return false;
    }
}
