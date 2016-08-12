package com.thoughtworks.tfoster.twu;

import com.thoughtworks.tfoster.twu.options.PrintLibraryOption;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Test
    public void shouldSeeBooksWhenPrinted() throws Exception {
        Collection<Book> books = new ArrayList<>();
        Book book1 = mock(Book.class);
        Book book2 = mock(Book.class);
        Book book3 = mock(Book.class);
        books.add(book1);
        books.add(book2);
        books.add(book3);

        Library library = new Library(books);
        library.print();

        verify(book1).print();
        verify(book2).print();
        verify(book3).print();
    }

}