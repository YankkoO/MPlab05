package uo.mp.lab05.dome.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.CD;
import uo.mp.lab05.dome.model.DVD;
import uo.mp.lab05.dome.model.VideoGame;
import uo.mp.lab05.dome.model.VideoGame.Platform;

/**
 * Test scenarios:
 * 1- Empty library -> Returns empty list
 * 2- Library with items -> Returns list with the responsible of each item
 */
class MediaLibraryGetResponsiblesTest {

    private MediaLibrary library;
    private CD cd1;
    private DVD dvd1;
    private VideoGame vg1;

    @BeforeEach
    void beforeEach() {
        library = new MediaLibrary();
        cd1 = new CD("Title1", "Artist1", 10, 10, 0);
        dvd1 = new DVD("Title2", "Director1", 20, 0);
        vg1 = new VideoGame("Title3", "Author1", Platform.NINTENDO, 1, 0);
    }

    /**
     * GIVEN: Empty library
     * WHEN: getResponsibles() is called
     * THEN: Returns empty list
     */
    @Test
    void testGetResponsiblesEmpty() {
        List<String> responsibles = library.getResponsibles();
        assertTrue(responsibles.isEmpty(), "Should return an empty list");
    }

    /**
     * GIVEN: Library with CD, DVD and VideoGame
     * WHEN: getResponsibles() is called
     * THEN: Returns list containing Artist, Director and Author in order
     */
    @Test
    void testGetResponsiblesWithItems() {
        library.add(cd1);
        library.add(dvd1);
        library.add(vg1);

        List<String> expected = new ArrayList<>();
        expected.add("Artist1");
        expected.add("Director1");
        expected.add("Author1");

        assertEquals(expected, library.getResponsibles());
    }
}