package uo.mp.lab04.dome.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Constructor with parameters
 * Scenarios
 * 
 * - Valid arguments
 * - Invalid title, null.
 * - Invalid title, blanks.
 * - Invalid director, null
 * - Invalid director, blanks
 * - Invalid playingTime < 0
 * - Invalid playingTime = 0
 */
class DVDConstructorTests {

    private DVD aDvd;
    private String theTitle;
    private String theDirector;
    private int theTime;
    private double thePrice;

    @BeforeEach
    public void setUp() {
        theTitle = "Star Wars";
        theDirector = "George Lucas";
        theTime = 125;
        thePrice = 28.99;
    }

    /**
     * GIVEN valid arguments
     * WHEN new Dvd(arguments)
     * THEN a new Dvd is created with that attributes
     */
    @Test
    public void validParams() {
        aDvd = new DVD(theTitle, theDirector, theTime, thePrice);

        assertEquals(theTitle, aDvd.getTitle());
        assertEquals(theDirector, aDvd.getDirector());
        assertEquals(theTime, aDvd.getPlayingTime());
        assertFalse(aDvd.isGotIt());
        assertEquals("No comment", aDvd.getComment());
    }

    /**
     * GIVEN valid arguments, except title = null
     * WHEN new Dvd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void nullTitle() {
        theTitle = null;
        try {
            new DVD(theTitle, theDirector, theTime, thePrice);
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid title (cannot be null nor blank)",
                    e.getMessage());
        }
    }

    /**
     * GIVEN valid arguments, except title = " "
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void blankTitle() {
        theTitle = "    ";
        try {
            new DVD(theTitle, theDirector, theTime, thePrice);
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid title (cannot be null nor blank)",
                    e.getMessage());
        }
    }

    /**
     * GIVEN valid arguments, except title = ""
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void emptyTitle() {
        theTitle = "";
        try {
            new DVD(theTitle, theDirector, theTime, thePrice);
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid title (cannot be null nor blank)",
                    e.getMessage());
        }
    }

    /**
     * GIVEN valid arguments, except director = null
     * WHEN new Dvd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void nullDirector() {
        theDirector = null;
        try {
            new DVD(theTitle, theDirector, theTime, thePrice);
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid director (cannot be null nor blank)",
                    e.getMessage());
        }
    }

    /**
     * GIVEN valid arguments, except director = " "
     * WHEN new Dvd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void blankDirector() {
        theDirector = "   ";
        try {
            new DVD(theTitle, theDirector, theTime, thePrice);
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid director (cannot be null nor blank)",
                    e.getMessage());
        }
    }

    /**
     * GIVEN valid arguments, except director = ""
     * WHEN new Dvd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test

    public void emptyDirector() {
        theDirector = "";
        try {
            new DVD(theTitle, theDirector, theTime, thePrice);
            fail("Exception expected");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid director (cannot be null nor blank)",
                    e.getMessage());
        }
    }

    /**
     * GIVEN valid arguments, except time = 0
     * WHEN new Dvd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void zeroTime() {
        theTime = 0;

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new DVD(theTitle, theDirector, theTime, thePrice),
                "Exception expected");
        assertEquals("Invalid playing time 0 (must be a positive integer)",
                e.getMessage());
    }

    /**
     * GIVEN valid arguments, except time < 0
     * WHEN new Dvd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void negativeTime() {
        theTime = -1;

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new DVD(theTitle, theDirector, theTime, thePrice),
                "Exception expected");
        assertEquals("Invalid playing time -1 (must be a positive integer)",
                e.getMessage());
    }

}
