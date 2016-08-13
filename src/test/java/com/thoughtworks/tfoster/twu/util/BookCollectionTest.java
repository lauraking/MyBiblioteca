package com.thoughtworks.tfoster.twu.util;

import com.thoughtworks.tfoster.twu.Book;
import com.thoughtworks.tfoster.twu.Library;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookCollectionTest {

    private Book book;
    private Collection<Book> collectionBackend;
    private BookCollection collection;

    @Before
    public void setUp() throws Exception {
        book = mock(Book.class);
        collectionBackend = new ArrayList<>();
        collectionBackend.add(book);

        collection = new BookCollection(collectionBackend);
    }

    @Test
    public void shouldReturnTrueWhenBookIsInCollection() throws Exception {
        when(book.hasTitle("Title")).thenReturn(true);

        assertThat(collection.contains("Title"), is(true));
    }

    @Test
    public void shouldReturnFalseWhenBookIsNotInCollection() throws Exception {
        assertThat(collection.contains("Title"), is(false));
    }

    @Test
    public void shouldNotHaveTheBookAnymoreAfterMovingBookToAnotherCollection() throws Exception {
        String title = "Book Title";
        when(book.hasTitle(title)).thenReturn(true);
        collection.moveToCollection(title, new BookCollection(new ArrayList<Book>()));

        assertThat(collectionBackend.contains(book), is(false));
    }

    @Test
    public void shouldHaveBookInOtherCollectionAfterMovingBookToAnotherCollection() throws Exception {
        String title = "Book title";
        when(book.hasTitle(title)).thenReturn(true);
        Collection<Book> otherBackend = new ArrayList<>();
        collection.moveToCollection(title, new BookCollection(otherBackend));

        assertThat(otherBackend.contains(book), is(true));
    }
}