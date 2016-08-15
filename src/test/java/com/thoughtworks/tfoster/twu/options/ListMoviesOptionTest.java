package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.Library;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListMoviesOptionTest {

    private Library library;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private ListMoviesOption option;

    @Before
    public void setUp() throws Exception {
        library = mock(Library.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        option = new ListMoviesOption(library, printStream, bufferedReader);
    }

    @Test
    public void shouldListMoviesWhenOptionSelected() throws Exception {
        option.run();

        verify(library).printAvailableMedia();
    }

    @Test
    public void shouldReturnTitle() throws Exception {
        assertEquals(option.title(), "List Movies");

    }
}