package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.Library;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class CheckoutBookOptionTest {

    private PrintStream printStream;
    private CheckoutBookOption option;
    private BufferedReader bufferedReader;
    private Library library;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        library = mock(Library.class);
        option = new CheckoutBookOption(library, printStream, bufferedReader);
    }

    @Test
    public void shouldInformUserOfPromptForBookTitleWhenRun() throws Exception {
        option.run();

        verify(printStream).println("Type in the title of the book you want to check out:");
    }

    @Test
    public void shouldPromptUserForBookTitleWhenRun() throws Exception {
        option.run();

        verify(bufferedReader).readLine();
    }

    @Test
    public void shouldCheckoutSpecifiedBookFromLibraryWhenRun() throws Exception {
        String bookTitle = "Title of Book";
        when(bufferedReader.readLine()).thenReturn(bookTitle);
        when(library.isBookAvailable(bookTitle)).thenReturn(true);
        option.run();

        verify(library).checkoutBook(bookTitle);
    }

    @Test
    public void shouldCheckIfBookWithTitleIsAvailableWhenRun() throws Exception {
        String bookTitle = "Title of Book";
        when(bufferedReader.readLine()).thenReturn(bookTitle);
        option.run();

        verify(library).isBookAvailable(bookTitle);
    }

    @Test
    public void shouldPrintSuccessMessageIfBookHasBeenCheckedOut() throws Exception {
        String bookTitle = "Title of Book";
        when(bufferedReader.readLine()).thenReturn(bookTitle);
        when(library.isBookAvailable(bookTitle)).thenReturn(true);
        option.run();

        verify(printStream).println("Thank you! Enjoy the book.");
    }

    @Test
    public void shouldPrintErrorMessageIfBookIsNotAvailable() throws Exception {
        String bookTitle = "Title of Book";
        when(bufferedReader.readLine()).thenReturn(bookTitle);
        when(library.isBookAvailable(bookTitle)).thenReturn(false);
        option.run();

        verify(printStream).println("That book is not available.");
    }
}