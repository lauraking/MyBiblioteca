package com.thoughtworks.tfoster.twu;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class LibraryTest {

    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Collection<Book> books;
    private Collection<Book> checkedOutBooks;
    private Library library;

    @Before
    public void setUp() throws Exception {
        book1 = mock(Book.class);
        book2 = mock(Book.class);
        book3 = mock(Book.class);
        book4 = mock(Book.class);
        books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        checkedOutBooks = new ArrayList<>();
        checkedOutBooks.add(book4);

        library = new Library(books, checkedOutBooks);
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
        when(book2.hasTitle(title)).thenReturn(true);
        library.checkoutBook(title);

        assertFalse(books.contains(book2));
    }

    @Test
    public void shouldReturnTrueWhenBookIsInLibrary() throws Exception {
        when(book2.hasTitle("Title")).thenReturn(true);

        assertThat(library.isBookAvailable("Title"), is(true));
    }

    @Test
    public void shouldReturnFalseWhenBookIsNotInLibrary() throws Exception {
        assertThat(library.isBookAvailable("Title"), is(false));
    }

    @Test
    public void shouldReturnTrueWhenBookIsCheckedOut() throws Exception {
        when(book4.hasTitle("Title")).thenReturn(true);

        assertThat(library.isBookCheckedOut("Title"), is(true));
    }

    @Test
    public void shouldReturnFalseWhenBookIsNotCheckedOut() throws Exception {
        assertThat(library.isBookCheckedOut("Title"), is(false));
    }
}