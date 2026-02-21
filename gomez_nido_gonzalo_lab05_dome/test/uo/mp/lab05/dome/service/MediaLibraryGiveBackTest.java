package uo.mp.lab05.dome.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Book;

/**
 * Test cases for the giveBack() method in MediaLibrary class.
 * 1. testGiveBackBorrowedItem: Gives back an item currently borrowed. Returns
 * true.
 * 2. testGiveBackAvailableItem: Gives back an item that is already available.
 * Returns false.
 * 3. testGiveBackNullParameter: Passes null as parameter. Throws
 * IllegalArgumentException.
 */
public class MediaLibraryGiveBackTest {

    private MediaLibrary ml;
    private Book borrowedBook;
    private Book availableBook;

    @BeforeEach
    public void setUp() {
        ml = new MediaLibrary();

        borrowedBook = new Book("Title 1", 10.0, "Writer", "Pub", "A1234");
        borrowedBook.setGotIt(true);
        ml.add(borrowedBook);
        ml.borrow(borrowedBook);

        availableBook = new Book("Title 2", 15.0, "Writer", "Pub", "B5678");
        availableBook.setGotIt(true);
        ml.add(availableBook);
    }

    /**
     * GIVEN: A library with a borrowed item
     * WHEN: The item is given back
     * THEN: Returns true and the item becomes available again
     */
    @Test
    public void testGiveBackBorrowedItem() {
        boolean result = ml.giveBack(borrowedBook);

        assertTrue(result);
        assertTrue(borrowedBook.isAvailable());
    }

    /**
     * GIVEN: A library with an item that is already available (not borrowed)
     * WHEN: The item is given back
     * THEN: Returns false
     */
    @Test
    public void testGiveBackAvailableItem() {
        boolean result = ml.giveBack(availableBook);

        assertFalse(result);
    }

    /**
     * GIVEN: A library
     * WHEN: Give back is called with a null parameter
     * THEN: Throws IllegalArgumentException
     */
    @Test
    public void testGiveBackNullParameter() {
        assertThrows(IllegalArgumentException.class, () -> {
            ml.giveBack(null);
        });
    }
}