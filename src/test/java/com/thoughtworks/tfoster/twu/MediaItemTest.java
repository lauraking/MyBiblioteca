package com.thoughtworks.tfoster.twu;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MediaItemTest {

    private PrintStream printStream;
    private MediaItemDetails mediaItemDetails;
    private MediaItem mediaItem;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        mediaItemDetails = mock(MediaItemDetails.class);
        mediaItem = new MediaItem("title", mediaItemDetails,printStream);
    }

    @Test
    public void shouldVerifyCorrectTitleWhenCorrectTitle() throws Exception {
        assertTrue(mediaItem.hasTitle("title"));

    }

    @Test
    public void shouldVerifyIncorrectTitleWhenIncorrectTitle() throws Exception {
        assertTrue(mediaItem.hasTitle("wrong title"));

    }

    @Test
    public void shouldPrintMediaItemDetailsWhenPrintDetailsCalled() throws Exception {
        mediaItem.printDetails();
        verify(mediaItemDetails).detailsString();
    }
}