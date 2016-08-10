package com.thoughtworks.tfoster.twu;

import org.junit.Before;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainMenuTest {

    private PrintStream printStream;
    private MainMenu mainMenu;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        mainMenu = new MainMenu(printStream);
    }

    @Test
    public void shouldShowListBooksWhenStarted() throws Exception {
        mainMenu.start();

        verify(printStream).print("List Books");
    }

    @Test
    public void shouldAcceptUsersChoice() throws Exception {


    }

    //    @Test
//    public void shouldPrintBooksWhenOption1IsChosen() throws Exception {
//        mainMenu.start();
//
//        BufferedReader reader = mock(BufferedReader.class);
//        when(reader.readLine()).thenReturn("1");
//
//        MenuOption option1 = mock(MenuOption.class);
//        verify(option1).run();
//
//    }
}