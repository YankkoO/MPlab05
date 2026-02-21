package uo.mp.lab05.dome.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Book;

/**
 * Test cases for the borrow() method in MediaLibrary class.
 * 1. testBorrowAvailableItem: Borrows an item that is owned and available.
 * Returns true.
 * 2. testBorrowAlreadyBorrowedItem: Tries to borrow an item already borrowed.
 * Returns false.
 * 3. testBorrowNotOwnedItem: Tries to borrow an item that is not owned. Returns
 * false.
 * 4. testBorrowNullParameter: Passes null as parameter. Throws
 * IllegalArgumentException.
 */
public class MediaLibraryBorrowTest {

    private MediaLibrary library;
    private Book ownedBook;
    private Book notOwnedBook;

    @BeforeEach
    public void setUp() {
        library = new MediaLibrary();

        ownedBook = new Book("Title 1", 10.0, "Writer", "Pub", "A1234");
        ownedBook.setGotIt(true);

        notOwnedBook = new Book("Title 2", 15.0, "Writer", "Pub", "B5678");

        library.add(ownedBook);
        library.add(notOwnedBook);
    }

    /**
     * GIVEN: A library with an owned and available item
     * WHEN: The item is borrowed
     * THEN: Returns true and the item is no longer available
     */
    @Test
    public void testBorrowAvailableItem() {
        boolean result = library.borrow(ownedBook);

        assertTrue(result);
        assertFalse(ownedBook.isAvailable());
    }

    /**
     * GIVEN: A library with an item that is already borrowed
     * WHEN: The item is borrowed again
     * THEN: Returns false
     */
    @Test
    public void testBorrowAlreadyBorrowedItem() {
        library.borrow(ownedBook);

        boolean result = library.borrow(ownedBook);

        assertFalse(result);
    }

    /**
     * GIVEN: A library with an item that is not owned
     * WHEN: The item is borrowed
     * THEN: Returns false
     */
    @Test
    public void testBorrowNotOwnedItem() {
        boolean result = library.borrow(notOwnedBook);

        assertFalse(result);
    }

    /**
     * GIVEN: A library
     * WHEN: Borrow is called with a null parameter
     * THEN: Throws IllegalArgumentException
     */
    @Test
    public void testBorrowNullParameter() {
        assertThrows(IllegalArgumentException.class, () -> {
            library.borrow(null);
        });
    }
}