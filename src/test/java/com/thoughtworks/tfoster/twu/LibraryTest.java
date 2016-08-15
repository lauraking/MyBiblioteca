package com.thoughtworks.tfoster.twu;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.mockito.Mockito.*;

public class LibraryTest {

    private MediaCollection availableMedia;
    private MediaCollection checkedOutMedia;
    private Library library;

    @Before
    public void setUp() throws Exception {
        availableMedia = mock(MediaCollection.class);
        checkedOutMedia = mock(MediaCollection.class);

        library = new Library(availableMedia, checkedOutMedia);
    }

    @Test
    public void shouldConsultAvailableBooksWhenCheckingIfABookIsAvailable() throws Exception {
        library.isBookAvailable("Title");

        verify(availableMedia).contains("Title");
    }

    @Test
    public void shouldConsultCheckedOutBooksWhenCheckingIfABookIsCheckedOut() throws Exception {
        library.isBookCheckedOut("Title");

        verify(checkedOutMedia).contains("Title");
    }

    @Test
    public void shouldMoveBookToCheckedOutBooksWhenCheckingOutABook() throws Exception {
        library.checkoutBook("Title");

        verify(availableMedia).moveToCollection("Title", checkedOutMedia);
    }

    @Test
    public void shouldMoveBookToAvailableBooksWhenReturningABook() throws Exception {
        library.returnBook("Title");

        verify(checkedOutMedia).moveToCollection("Title", availableMedia);
    }

    @Test
    public void shouldPrintAvailableBooksWhenPrinted() throws Exception {
        MediaItem mediaItem1 = mock(MediaItem.class);
        MediaItem mediaItem2 = mock(MediaItem.class);
        MediaItem mediaItem3 = mock(MediaItem.class);
        Collection<MediaItem> availableBackend = new ArrayList<>();
        availableBackend.add(mediaItem1);
        availableBackend.add(mediaItem2);
        Collection<MediaItem> checkedOutBackend = new ArrayList<>();
        checkedOutBackend.add(mediaItem3);

        library = new Library(new MediaCollection(availableBackend), new MediaCollection(checkedOutBackend));
        library.printAvailableMedia();

        verify(mediaItem1).printDetails();
        verify(mediaItem2).printDetails();
        verify(mediaItem3, never()).printDetails();
    }

}