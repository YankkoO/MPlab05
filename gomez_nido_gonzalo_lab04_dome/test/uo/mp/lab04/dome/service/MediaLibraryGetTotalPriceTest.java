package uo.mp.lab04.dome.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.dome.model.CD;
import uo.mp.lab04.dome.model.DVD;
import uo.mp.lab04.dome.model.VideoGame;
import uo.mp.lab04.dome.model.VideoGame.Platform;

/**
 * get total price tests
 * Scenarios:
 * - Empty library (returns 0.0)
 * - Library with one CD (applies fixed tax)
 * - Library with one DVD (no tax applied)
 * - Library with one VideoGame (applies percentage tax)
 * - Library with mixed items (calculates sum of final prices)
 */

public class MediaLibraryGetTotalPriceTest {

    private MediaLibrary ml;
    private final double DELTA = 0.001;

    @BeforeEach
    public void setUp() {
        ml = new MediaLibrary();
    }

    /**
     * GIVEN: Empty library
     * WHEN: getTotalPrice()
     * THEN: Returns 0.0
     */
    @Test
    public void testGetTotalPriceEmpty() {
        assertEquals(0.0, ml.getTotalPrice(), DELTA);
    }

    /**
     * GIVEN: Library with one CD
     * WHEN: getTotalPrice()
     * THEN: Returns base price + 2.0 (Tax)
     */
    @Test
    public void testGetTotalPriceOneCD() {
        ml.add(new CD("Title", "Artist", 10, 60, 10.0));
        assertEquals(12.0, ml.getTotalPrice(), DELTA);
    }

    /**
     * GIVEN: Library with one DVD
     * WHEN: getTotalPrice()
     * THEN: Returns base price (No Tax)
     */
    @Test
    public void testGetTotalPriceOneDVD() {
        ml.add(new DVD("Title", "Director", 120, 15.0));
        assertEquals(15.0, ml.getTotalPrice(), DELTA);
    }

    /**
     * GIVEN: Library with one VideoGame
     * WHEN: getTotalPrice()
     * THEN: Returns base price + 10% (Tax)
     */
    @Test
    public void testGetTotalPriceOneVideoGame() {
        ml.add(new VideoGame("Game", "Author", Platform.PLAYSTATION, 1, 50.0));
        assertEquals(55.0, ml.getTotalPrice(), DELTA);
    }

    /**
     * GIVEN: Library with multiple mixed items
     * WHEN: getTotalPrice()
     * THEN: Returns sum of all final prices
     */
    @Test
    public void testGetTotalPriceMixed() {
        ml.add(new CD("CD", "A", 1, 1, 10.0)); // 12.0
        ml.add(new DVD("DVD", "D", 1, 20.0)); // 20.0
        ml.add(new VideoGame("VG", "A", Platform.NINTENDO, 1, 100.0)); // 110.0

        assertEquals(142.0, ml.getTotalPrice(), DELTA);
    }
}