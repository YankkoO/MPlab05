package uo.mp.lab05.dome.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.CD;
import uo.mp.lab05.dome.model.DVD;
import uo.mp.lab05.dome.model.VideoGame;
import uo.mp.lab05.dome.model.VideoGame.Platform;

/**
 * Generate codes tests
 * Scenarios:
 * - Empty library (returns empty string)
 * - One item with short title (length < 3)
 * - One item with long title (length >= 3)
 * - Multiple items (checks separator "-" logic and no trailing hyphen)
 */

public class MediaLibraryGenerateCodesTest {

    private MediaLibrary ml;

    @BeforeEach
    public void setUp() {
        ml = new MediaLibrary();
    }

    /**
     * GIVEN: A library with no items
     * WHEN: generateCodes() is called
     * THEN: Returns an empty string (not null, not "-")
     */
    @Test
    public void testGenerateCodesEmptyLibrary() {
        assertEquals("", ml.generateCodes());
    }

    /**
     * GIVEN: A library with one item with a short title (< 3 chars)
     * WHEN: generateCodes() is called
     * THEN: Returns the full title + position "0" (e.g., "It0")
     */
    @Test
    public void testGenerateCodesOneItemShortTitle() {
        ml.add(new CD("It", "Artist", 10, 60, 10.0));
        assertEquals("It0", ml.generateCodes());
    }

    /**
     * GIVEN: A library with one item with a long title (>= 3 chars)
     * WHEN: generateCodes() is called
     * THEN: Returns the first 3 chars + position "0"
     */
    @Test
    public void testGenerateCodesOneItemLongTitle() {
        ml.add(new CD("Satisfaction", "Stones", 10, 60, 10.0));
        assertEquals("Sat0", ml.generateCodes());
    }

    /**
     * GIVEN: A library with multiple items
     * WHEN: generateCodes() is called
     * THEN: Returns codes separated by "-" without a trailing "-"
     */
    @Test
    public void testGenerateCodesMultipleItems() {
        ml.add(new CD("A", "Artist", 10, 60, 10.0));
        ml.add(new DVD("Matrix", "Director", 120, 20.0));
        ml.add(new VideoGame("Halo", "Bungie", Platform.XBOX, 1, 50.0));

        assertEquals("A0-Mat1-Hal2", ml.generateCodes());
    }
}