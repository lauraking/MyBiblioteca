package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.Book;
import com.thoughtworks.tfoster.twu.Library;
import com.thoughtworks.tfoster.twu.options.PrintLibraryOption;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PrintLibraryOptionTest {

    @Test
    public void shouldPrintLibraryWhenRun() throws Exception {
        Library library = mock(Library.class);
        PrintLibraryOption option = new PrintLibraryOption(library);
        option.run();

        verify(library).print();
    }
}