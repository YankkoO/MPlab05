package uo.mp.lab05.dome.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Constructor with parameters
 * Scenarios
 * 
 * - Valid arguments
 * - Invalid title, null.
 * - Invalid title, blanks.
 * - Invalid artist, null
 * - Invalid artist, blanks
 * - Invalid playingTime < 0
 * - Invalid playingTime = 0
 * - Invalid tracks < 0
 * - Invalid tracks = 0
 */
class CDConstructorTests {

    private String theTitle;
    private String theArtist;
    private int theTime;
    private int theTracks;

    @BeforeEach
    public void setUp() {
        theTitle = "Come Together";
        theArtist = "Beatles";
        theTime = 70;
        theTracks = 4;
    }

    /**
     * GIVEN valid arguments
     * WHEN new Cd(arguments)
     * THEN a new Cd is created with that attributes
     */
    @Test
    public void validParams() {
        CD cd = new CD(theTitle, theArtist, theTracks, theTime, 20.5);

        assertEquals("Come Together", cd.getTitle());
        assertEquals("Beatles", cd.getArtist());
        assertEquals(70, cd.getPlayingTime());
        assertEquals(4, cd.getNumberOfTracks());
        assertFalse(cd.isGotIt());
        assertEquals("No comment", cd.getComment());
    }

    /**
     * GIVEN valid arguments, except title = null
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void nullTitle() {
        theTitle = null;
        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new CD(theTitle, theArtist, theTracks, theTime, 20.5),
                "Exception expected");
        assertEquals("Invalid title (cannot be null nor blank)",
                e.getMessage());

    }

    /**
     * GIVEN valid arguments, except title = " "
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void blankTitle() {
        theTitle = "    ";

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new CD(theTitle, theArtist, theTracks, theTime, 20.5),
                "Exception expected");
        assertEquals("Invalid title (cannot be null nor blank)",
                e.getMessage());
    }

    /**
     * GIVEN valid arguments, except title = ""
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void emptyTitle() {
        theTitle = "";

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new CD(theTitle, theArtist, theTracks, theTime, 20.5),
                "Exception expected");
        assertEquals("Invalid title (cannot be null nor blank)",
                e.getMessage());
    }

    /**
     * GIVEN valid arguments, except artist = null
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void nullArtist() {
        theArtist = null;

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new CD(theTitle, theArtist, theTracks, theTime, 20.5),
                "Exception expected");
        assertEquals("Invalid artist (cannot be null nor blank)",
                e.getMessage());
    }

    /**
     * GIVEN valid arguments, except artist = " "
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void blankArtist() {
        theArtist = " ";

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new CD(theTitle, theArtist, theTracks, theTime, 20.5),
                "Exception expected");
        assertEquals("Invalid artist (cannot be null nor blank)",
                e.getMessage());
    }

    /**
     * GIVEN valid arguments, except artist = ""
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void emptyArtist() {
        theArtist = "";

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new CD(theTitle, theArtist, theTracks, theTime, 20.5),
                "Exception expected");
        assertEquals("Invalid artist (cannot be null nor blank)",
                e.getMessage());
    }

    /**
     * GIVEN valid arguments, except time = 0
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void zeroTime() {
        theTime = 0;

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new CD(theTitle, theArtist, theTracks, theTime, 20.5),
                "Exception expected");
        assertEquals("Invalid playing time 0 (must be a positive integer)",
                e.getMessage());
    }

    /**
     * GIVEN valid arguments, except time < 0
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void negativeTime() {
        theTime = -1;

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new CD(theTitle, theArtist, theTracks, theTime, 20.5),
                "Exception expected");
        assertEquals("Invalid playing time -1 (must be a positive integer)",
                e.getMessage());
    }

    /**
     * GIVEN valid arguments, except tracks < 0
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test

    public void negativeTracks() {
        theTracks = -1;

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new CD(theTitle, theArtist, theTracks, theTime, 20.5),
                "Exception expected");
        assertEquals("Invalid number of tracks -1 (must be a positive integer)",
                e.getMessage());
    }

    /**
     * GIVEN valid arguments, except tracks = 0
     * WHEN new Cd(arguments)
     * THEN throws IllegalArgumentException
     */
    @Test
    public void zeroTracks() {
        theTracks = 0;

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class,
                () -> new CD(theTitle, theArtist, theTracks, theTime, 20.5),
                "Exception expected");
        assertEquals("Invalid number of tracks 0 (must be a positive integer)",
                e.getMessage());
    }
}
