package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.Biblioteca;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class QuitOptionTest {
    @Test
    public void shouldQuitBibliotecaWhenRun() throws Exception {
        Biblioteca biblioteca = mock(Biblioteca.class);
        QuitOption quitOption = new QuitOption(biblioteca);
        quitOption.run();

        verify(biblioteca).quit();
    }
}