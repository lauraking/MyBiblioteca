package com.thoughtworks.tfoster.twu.options;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckoutBookOptionTest {

    private PrintStream printStream;
    private CheckoutBookOption option;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        option = new CheckoutBookOption(printStream, bufferedReader);
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
}