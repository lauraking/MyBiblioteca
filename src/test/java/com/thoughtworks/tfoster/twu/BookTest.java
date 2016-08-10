package com.thoughtworks.tfoster.twu;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BookTest {

    @Test
    public void shouldSeeTitleAuthorAndYearPublishedWhenPrinted() throws Exception {
        PrintStream printStream = mock(PrintStream.class);
        Book book = new Book("Title", "Author", "2001", printStream);
        book.print();

        verify(printStream).print("Title");
        verify(printStream).print("Author");
        verify(printStream).print("2001");
    }
}