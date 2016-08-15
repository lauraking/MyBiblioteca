package com.thoughtworks.tfoster.twu;

import java.io.PrintStream;

public class MediaItem {


    private String title;
    private MediaItemDetails mediaItemDetails;
    private String author;
    private String yearPublished;
    private PrintStream printStream;


    public MediaItem(String title, MediaItemDetails mediaItemDetails, PrintStream printStream) {
        this.title = title;
        this.mediaItemDetails = mediaItemDetails;
        this.printStream = printStream;
    }


    public void printDetails() {

    }



    public boolean hasTitle(String title) {
        return this.title.equals(title);
    }
}
