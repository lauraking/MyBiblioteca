package com.thoughtworks.tfoster.twu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PrintLibraryOptionTest {

    @Test
    public void shouldSeeBooksWhenRun() throws Exception {
        Collection<Book> books = new ArrayList<>();
        Book book1 = mock(Book.class);
        Book book2 = mock(Book.class);
        Book book3 = mock(Book.class);
        books.add(book1);
        books.add(book2);
        books.add(book3);

        PrintLibraryOption printLibraryOption = new PrintLibraryOption(books);
        printLibraryOption.run();

        verify(book1).print();
        verify(book2).print();
        verify(book3).print();
    }


}