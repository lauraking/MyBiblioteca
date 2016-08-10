package com.thoughtworks.tfoster.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private Book book1;
    private Book book2;
    private Book book3;

    private ArrayList<Book> makeEmptyLibrary() {
        return new ArrayList<>();
    }

    private ArrayList<Book> makePopulatedLibrary() {
        ArrayList<Book> library = makeEmptyLibrary();
        library.add(book1);
        library.add(book2);
        library.add(book3);
        return library;
    }

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        book1 = mock(Book.class);
        book2 = mock(Book.class);
        book3 = mock(Book.class);

        biblioteca = new Biblioteca(printStream, makePopulatedLibrary());
    }

    @Test
    public void shouldSeeWelcomeMessageWhenStarted() throws Exception {
        biblioteca.start();

        verify(printStream).println("Welcome!");
    }

//    @Test
//    public void shouldSeeListOfBooksInLibraryAfterWelcome() throws Exception {
//        biblioteca.start();
//
//        verify(book1).print();
//        verify(book2).print();
//        verify(book3).print();
//    }

    @Test
    public void shouldSeeListBooksWhenStarted() throws Exception {
        biblioteca.start();

        verify(printStream).print("List Books");
    }
}