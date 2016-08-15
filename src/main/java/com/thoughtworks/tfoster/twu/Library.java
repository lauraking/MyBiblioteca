package com.thoughtworks.tfoster.twu;


public class Library {

    private MediaCollection availableMediaItems;
    private MediaCollection checkedOutMediaItems;

    public Library(MediaCollection availableMediaItems, MediaCollection checkedOutMediaItems) {
        this.availableMediaItems = availableMediaItems;
        this.checkedOutMediaItems = checkedOutMediaItems;
    }

    public void printAvailableMedia() {
        for(MediaItem mediaItem : availableMediaItems)
            mediaItem.printDetails();
    }

    public void checkoutBook(String title) {
        availableMediaItems.moveToCollection(title, checkedOutMediaItems);
    }

    public void returnBook(String title) {
        checkedOutMediaItems.moveToCollection(title, availableMediaItems);
    }

    public boolean isBookAvailable(String title) {
        return availableMediaItems.contains(title);
    }

    public boolean isBookCheckedOut(String title) {
        return checkedOutMediaItems.contains(title);
    }

}
