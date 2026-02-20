package uo.mp.lab04.dome.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Dvd::setComment(arg)
 * 
 * - Right comment
 * - null argument
 * - empty string
 * - argument does not contain meaningful chars
 */
class DVDSetCommentTests {
    private DVD aDVD;
    private String theTitle;
    private String theDirector;
    private int theTime;
    private double thePrice;

    @BeforeEach
    public void setUp() {
        theTitle = "Star Wars";
        theDirector = "George Lucas";
        theTime = 125;
        thePrice = 40.99;
        aDVD = new DVD(theTitle, theDirector, theTime, thePrice);
    }

    /**
     * GIVEN dvd with "No comment" comment
     * WHEN call setComment with other comment full of meaningful chars
     * THEN comment is changed to new string
     */
    @Test
    public void validComment() {
        aDVD.setComment("Excellent");

        assertEquals("Excellent", aDVD.getComment());
    }

    /**
     * GIVEN dvd with a comment
     * WHEN call setComment with null
     * THEN comment unchanged
     */
    @Test
    public void nullComment() {
        aDVD.setComment("Excellent");
        aDVD.setComment(null);

        assertEquals("Excellent", aDVD.getComment());
    }

    /**
     * GIVEN dvd with a comment
     * WHEN call setComment with ""
     * THEN comment unchanged
     */
    @Test
    public void emptyComment() {
        aDVD.setComment("Excellent");
        aDVD.setComment("");

        assertEquals("Excellent", aDVD.getComment());
    }

    /**
     * GIVEN dvd with a comment
     * WHEN call setComment with " "
     * THEN comment unchanged
     */
    @Test
    public void blankComment() {
        aDVD.setComment("Excellent");
        aDVD.setComment("      ");

        assertEquals("Excellent", aDVD.getComment());
    }
}