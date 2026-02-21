package uo.mp.lab05.dome.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.CD;
import uo.mp.lab05.dome.model.DVD;
import uo.mp.lab05.dome.model.Item;
import uo.mp.lab05.dome.model.VideoGame;
import uo.mp.lab05.dome.model.VideoGame.Platform;

/**
 * Test scenarios:
 * 1- Null Item -> IllegalArgumentException
 * 2- Found item -> Returns the Item
 * 3- Not found item -> Returns null
 * 4- Empty library -> Returns null
 */
class MediaLibrarySearchItemsTests {

    private MediaLibrary library;
    private CD cd1;
    private DVD dvd1;
    private VideoGame vg1;
    private VideoGame vgNotAdded;

    @BeforeEach
    void beforeStart() {
        library = new MediaLibrary();

        cd1 = new CD("CD-Title-1", "CD-Artist-1", 5, 10, 0);
        dvd1 = new DVD("DVD-Title-1", "DVD-Director-1", 15, 0);
        vg1 = new VideoGame("GAME-Title-1", "GAME-Author-1",
                Platform.PLAYSTATION, 2, 0);

        vgNotAdded = new VideoGame("GAME-Title-2", "GAME-Author-2",
                Platform.XBOX, 4, 0);

        library.add(cd1);
        library.add(dvd1);
        library.add(vg1);
    }

    /**
     * GIVEN: A library with items
     * WHEN: searchItem is called with null
     * THEN: IllegalArgumentException
     */
    @Test
    void testSearchNullThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> library.searchItem(null));
    }

    /**
     * GIVEN: A library with items
     * WHEN: searchItem is called with an item that exists in the library
     * THEN: The item is returned
     */
    @Test
    void testSearchExistingItem() {
        Item result = library.searchItem(vg1);
        assertEquals(vg1, result);
    }

    /**
     * GIVEN: A library with items
     * WHEN: searchItem is called with an item that DOES NOT exist in the
     * library
     * THEN: null is returned
     */
    @Test
    void testSearchNonExistingItem() {
        Item result = library.searchItem(vgNotAdded);
        assertNull(result);
    }

    /**
     * GIVEN: An empty library
     * WHEN: searchItem is called with any valid item
     * THEN: null is returned
     */
    @Test
    void testSearchInEmptyLibrary() {
        MediaLibrary emptyLib = new MediaLibrary();

        Item result = emptyLib.searchItem(cd1);
        assertNull(result);
    }

    /**
     * GIVEN: Two instances of the CD class, with the same attribute values,
     * one in the library.
     * WHEN: Searching for copy in the library.
     * THEN: The method returns the matching instance found in the library.
     */
    @Test
    void libContainsItemSearchExactCopy() {
        CD cd = new CD("Come together", "The Beatles", 8, 120, 0);
        CD copy = new CD(cd.getTitle(), cd.getArtist(), cd.getNumberOfTracks(),
                cd.getPlayingTime(), 0);
        library.add(cd);

        Item found = library.searchItem(copy);
        assertTrue(cd == found);
    }
}