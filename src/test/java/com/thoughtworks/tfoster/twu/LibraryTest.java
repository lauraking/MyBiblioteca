package com.thoughtworks.tfoster.twu;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class LibraryTest {

    private Book book1;
    private Book book2;
    private Book book3;
    private Collection<Book> books;
    private Library library;

    @Before
    public void setUp() throws Exception {
        book1 = mock(Book.class);
        book2 = mock(Book.class);
        book3 = mock(Book.class);
        books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        library = new Library(books);
    }

    @Test
    public void shouldSeeBooksWhenPrinted() throws Exception {
        library.print();

        verify(book1).print();
        verify(book2).print();
        verify(book3).print();
    }

    @Test
    public void shouldNotContainBookInAvailableBooksWhenBookIsCheckedOut() throws Exception {
        String title = "Title of book";
        when(book1.hasTitle(title)).thenReturn(false);
        when(book2.hasTitle(title)).thenReturn(true);
        when(book3.hasTitle(title)).thenReturn(false);
        library.checkoutBook(title);

        assertFalse(books.contains(book2));
    }

}