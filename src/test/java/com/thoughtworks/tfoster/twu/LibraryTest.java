package com.thoughtworks.tfoster.twu;

import com.thoughtworks.tfoster.twu.util.BookCollection;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.*;

public class LibraryTest {

    private BookCollection availableBooks;
    private BookCollection checkedOutBooks;
    private Library library;

    @Before
    public void setUp() throws Exception {
        availableBooks = mock(BookCollection.class);
        checkedOutBooks = mock(BookCollection.class);

        library = new Library(availableBooks, checkedOutBooks);
    }

    @Test
    public void shouldConsultAvailableBooksWhenCheckingIfABookIsAvailable() throws Exception {
        library.isBookAvailable("Title");

        verify(availableBooks).contains("Title");
    }

    @Test
    public void shouldConsultCheckedOutBooksWhenCheckingIfABookIsCheckedOut() throws Exception {
        library.isBookCheckedOut("Title");

        verify(checkedOutBooks).contains("Title");
    }

    @Test
    public void shouldMoveBookToCheckedOutBooksWhenCheckingOutABook() throws Exception {
        library.checkoutBook("Title");

        verify(availableBooks).moveToCollection("Title", checkedOutBooks);
    }

    @Test
    public void shouldMoveBookToAvailableBooksWhenReturningABook() throws Exception {
        library.returnBook("Title");

        verify(checkedOutBooks).moveToCollection("Title", availableBooks);
    }

    @Test
    public void shouldPrintAvailableBooksWhenPrinted() throws Exception {
        Book book1 = mock(Book.class);
        Book book2 = mock(Book.class);
        Book book3 = mock(Book.class);
        Collection<Book> availableBackend = new ArrayList<>();
        availableBackend.add(book1);
        availableBackend.add(book2);
        Collection<Book> checkedOutBackend = new ArrayList<>();
        checkedOutBackend.add(book3);

        library = new Library(new BookCollection(availableBackend), new BookCollection(checkedOutBackend));
        library.print();

        verify(book1).print();
        verify(book2).print();
        verify(book3, never()).print();
    }

}