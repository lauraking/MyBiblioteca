package com.thoughtworks.tfoster.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {

    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldSeeTitleAuthorAndYearPublishedWhenPrinted() throws Exception {
        Book book = new Book("Title", "Author", "2001", printStream);
        book.print();

        verify(printStream).print("          Title");
        verify(printStream).print("         Author");
        verify(printStream).print("2001");
    }

    @Test
    public void shouldSeeTruncatedTitleWhenTitleIsTooLong() throws Exception {
        Book book = new Book("Title is way too long", "Author", "2001", printStream);
        book.print();

        verify(printStream).print("Title is way to");
        verify(printStream).print("         Author");
        verify(printStream).print("2001");
    }
}