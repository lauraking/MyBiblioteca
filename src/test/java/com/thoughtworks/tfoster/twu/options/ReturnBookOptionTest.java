package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.Library;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReturnBookOptionTest {

    private Library library;
    private BufferedReader reader;
    private ReturnBookOption option;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        reader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        option = new ReturnBookOption(library, printStream, reader);
    }

    @Test
    public void shouldInformUserOfPromptWhenRun() throws Exception {
        option.run();

        verify(printStream).println("Type in the title of the book you want to return:");
    }

    @Test
    public void shouldPromptUserForBookTitleWhenRun() throws Exception {
        option.run();

        verify(reader).readLine();
    }

    @Test
    public void shouldReturnSpecifiedBookWhenRun() throws Exception {
        String title = "Title";
        when(reader.readLine()).thenReturn(title);
        when(library.isBookCheckedOut(title)).thenReturn(true);
        option.run();

        verify(library).returnBook(title);
    }

    @Test
    public void shouldCheckIfBookWithTitleIsCheckedOutWhenRun() throws Exception {
        String title = "Book Title";
        when(reader.readLine()).thenReturn(title);
        option.run();

        verify(library).isBookCheckedOut(title);
    }

}