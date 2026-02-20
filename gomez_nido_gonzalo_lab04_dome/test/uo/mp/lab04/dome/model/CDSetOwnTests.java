package uo.mp.lab04.dome.model;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Cd::setOwn(boolean)
 * 
 * - when isOwned to owned
 * - when isNotOwned to owned
 * - when is not owned to owned
 * - when is not owned to not owned
 */

class CDSetOwnTests {
    private CD aCD;
    private String theTitle;
    private String theArtist;
    private int theTime;
    private int theTracks;
    private double thePrice;

    @BeforeEach
    public void setUp() {
        theTitle = "Come Together";
        theArtist = "Beatles";
        theTime = 70;
        theTracks = 4;
        aCD = new CD(theTitle, theArtist, theTracks, theTime, thePrice);
    }

    /**
     * GIVEN cd is owned
     * WHEN call setOwn with true
     * THEN unchanged
     * 
     */
    @Test
    public void trueToTrue() {
        aCD.setGotIt(true);
        aCD.setGotIt(true);
        assertTrue(aCD.isGotIt());
    }

    /**
     * GIVEN cd owned
     * WHEN call setOwn ( false )
     * THEN cd not owned
     * 
     */
    @Test
    public void trueToFalse() {
        aCD.setGotIt(true);
        aCD.setGotIt(false);
        assertFalse(aCD.isGotIt());
    }

    /**
     * GIVEN cd not owned
     * WHEN call setOwn ( false )
     * THEN cd not owned
     * 
     */
    @Test
    public void falseToFalse() {
        aCD.setGotIt(false);
        aCD.setGotIt(false);
        assertFalse(aCD.isGotIt());
    }

    /**
     * GIVEN cd not owned
     * WHEN call setOwn ( true )
     * THEN cd owned
     * 
     */
    @Test
    public void falseToTrue() {
        aCD.setGotIt(false);
        aCD.setGotIt(true);
        assertTrue(aCD.isGotIt());
    }
}
