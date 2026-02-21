package uo.mp.lab05.dome.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.Book;
import uo.mp.lab05.dome.model.Borrowable;
import uo.mp.lab05.dome.model.CD;
import uo.mp.lab05.dome.model.DVD;
import uo.mp.lab05.dome.model.VideoGame;

/**
 * Test cases for the getBorrowables() method in MediaLibrary class.
 * * 1. testGetBorrowablesEmptyLibrary: Tests the method on an empty library.
 * Returns empty list.
 * 2. testGetBorrowablesMixedItems: Tests the method on a library with
 * borrowable and non-borrowable items. Returns only borrowables.
 */
public class MediaLibraryGetBorrowablesTest {

    private MediaLibrary ml;

    @BeforeEach
    public void setUp() {
        ml = new MediaLibrary();
    }

    /**
     * GIVEN: An empty library
     * WHEN: getBorrowables is called
     * THEN: Returns an empty list, not null
     */
    @Test
    public void testGetBorrowablesEmptyLibrary() {
        List<Borrowable> list = ml.getBorrowables();

        assertNotNull(list);
        assertTrue(list.isEmpty());
    }

    /**
     * GIVEN: A library with a mix of borrowable and non-borrowable items
     * WHEN: getBorrowables is called
     * THEN: Returns a list containing only the borrowable items
     */
    @Test
    public void testGetBorrowablesMixedItems() {
        Book b = new Book("Title 1", 10.0, "Writer", "Pub", "A1234");
        CD cd = new CD("Title 2", "Artist", 10, 10, 10.0);
        DVD dvd = new DVD("Title 3", "Director", 120, 15.0);
        VideoGame vg = new VideoGame("Title 4", "Author",
                VideoGame.Platform.XBOX, 1, 60.0);

        ml.add(b);
        ml.add(cd);
        ml.add(dvd);
        ml.add(vg);

        List<Borrowable> list = ml.getBorrowables();

        assertEquals(2, list.size());
        assertTrue(list.contains(b));
        assertTrue(list.contains(cd));
    }
}