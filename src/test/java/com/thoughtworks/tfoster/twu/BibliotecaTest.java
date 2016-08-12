package com.thoughtworks.tfoster.twu;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class BibliotecaTest {

    private PrintStream printStream;
    private Biblioteca biblioteca;
    private Book book1;
    private Book book2;
    private Book book3;
    private MainMenu mainMenu;

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

    private Answer<Void> quitBiblioteca() {
        return new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                biblioteca.quit();
                return null;
            }
        };
    }

    private void quitAfterFirstRun() {
        doAnswer(quitBiblioteca()).when(mainMenu).processUserSelection();
    }

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        book1 = mock(Book.class);
        book2 = mock(Book.class);
        book3 = mock(Book.class);
        mainMenu = mock(MainMenu.class);

        biblioteca = new Biblioteca(printStream, mainMenu);
    }

    @Test
    public void shouldSeeWelcomeMessageWhenStarted() throws Exception {
        quitAfterFirstRun();
        biblioteca.start();

        verify(printStream).println("Welcome!");
    }

    @Test
    public void shouldStartMenuWhenStarted() throws Exception {
        quitAfterFirstRun();
        biblioteca.start();

        verify(mainMenu).showMenu();
    }

    @Test
    public void shouldLetUserSelectFromOptionsWhenStarted() throws Exception {
        quitAfterFirstRun();
        biblioteca.start();

        verify(mainMenu).processUserSelection();
    }

    @Test
    public void shouldContinueAskingForUserSelectionUntilQuit() throws Exception {
        doNothing().doNothing().doAnswer(quitBiblioteca()).when(mainMenu).processUserSelection();

        biblioteca.start();

        verify(mainMenu, times(3)).processUserSelection();
    }
}