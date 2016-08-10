package com.thoughtworks.tfoster.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainMenuTest {

    private PrintStream printStream;
    private MainMenu mainMenu;
    private ArrayList<MenuOption> options;
    private BufferedReader reader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);

        options = new ArrayList<>();
        options.add(mock(MenuOption.class));
        reader = mock(BufferedReader.class);

        mainMenu = new MainMenu(printStream, reader, options);
    }

    @Test
    public void shouldShowListBooksWhenStarted() throws Exception {
        mainMenu.showMenu();

        verify(printStream).print("1: List Books");
    }

//    @Test
//    public void shouldAcceptUsersChoiceWhenOption1Selected() throws Exception {
//
//
//    }

    @Test
    public void shouldPrintBooksWhenOption1IsChosen() throws Exception {
        when(reader.readLine()).thenReturn("1");

        mainMenu.userOptionSelection();

        verify(options.get(0)).run();
    }
}