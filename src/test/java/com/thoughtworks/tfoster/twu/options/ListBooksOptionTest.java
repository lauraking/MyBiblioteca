package com.thoughtworks.tfoster.twu.options;

import com.thoughtworks.tfoster.twu.Library;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksOptionTest {

    @Test
    public void shouldPrintLibraryWhenRun() throws Exception {
        Library library = mock(Library.class);
        ListBooksOption option = new ListBooksOption(library);
        option.run();

        verify(library).print();
    }

}