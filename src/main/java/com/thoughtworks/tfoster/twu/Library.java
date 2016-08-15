package com.thoughtworks.tfoster.twu;

import com.thoughtworks.tfoster.twu.util.MediaCollection;

public class Library {

    private MediaCollection availableBooks;
    private MediaCollection checkedOutBooks;

    public Library(MediaCollection availableBooks, MediaCollection checkedOutBooks) {
        this.availableBooks = availableBooks;
        this.checkedOutBooks = checkedOutBooks;
    }

    public void print() {
        for(Book book : availableBooks)
            book.print();
    }

    public void checkoutBook(String title) {
        availableBooks.moveToCollection(title, checkedOutBooks);
    }

    public void returnBook(String title) {
        checkedOutBooks.moveToCollection(title, availableBooks);
    }

    public boolean isBookAvailable(String title) {
        return availableBooks.contains(title);
    }

    public boolean isBookCheckedOut(String title) {
        return checkedOutBooks.contains(title);
    }

}
