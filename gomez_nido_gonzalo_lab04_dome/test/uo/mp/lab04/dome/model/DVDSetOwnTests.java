package uo.mp.lab04.dome.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Dvd::setOwn(boolean)
 *
 * - being own to own
 * - being own to not own
 * - being not own to not own
 * - being not own to own
 */
class DVDSetOwnTests {
    private DVD aDVD;
    private String theTitle;
    private String theDirector;
    private int theTime;
    private double thePrice;

    @BeforeEach
    public void setUp() {
        theTitle = "La guerra de las Galaxias";
        theDirector = "George Lucas";
        theTime = 125;
        thePrice = 35.99;
        aDVD = new DVD(theTitle, theDirector, theTime, thePrice);
    }

    /**
     * GIVEN dvd owned
     * WHEN call setOwn ( true )
     * THEN dvd not changed
     * 
     */
    @Test
    public void trueToTrue() {
        aDVD.setGotIt(true);
        aDVD.setGotIt(true);
        assertTrue(aDVD.isGotIt());
    }

    /**
     * GIVEN dvd owned
     * WHEN call setOwn ( false )
     * THEN dvd not owned
     * 
     */
    @Test
    public void trueToFalse() {
        aDVD.setGotIt(true);
        aDVD.setGotIt(false);
        assertFalse(aDVD.isGotIt());
    }

    /**
     * GIVEN dvd not owned
     * WHEN call setOwn ( false )
     * THEN dvd not changed
     * 
     */
    @Test
    public void falseToFalse() {
        aDVD.setGotIt(false);
        aDVD.setGotIt(false);
        assertFalse(aDVD.isGotIt());
    }

    /**
     * GIVEN dvd not owned
     * WHEN call setOwn ( true )
     * THEN dvd owned
     * 
     */
    @Test
    public void falseToTrue() {
        aDVD.setGotIt(false);
        aDVD.setGotIt(true);
        assertTrue(aDVD.isGotIt());
    }

}