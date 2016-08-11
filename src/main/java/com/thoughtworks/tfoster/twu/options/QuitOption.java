package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.Biblioteca;

public class QuitOption implements MenuOption {
    private Biblioteca biblioteca;

    public QuitOption(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    @Override
    public String title() {
        return "Quit";
    }

    @Override
    public void run() {
        biblioteca.quit();
    }
}
