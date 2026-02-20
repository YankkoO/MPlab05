package uo.mp.lab04.dome.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.dome.model.CD;
import uo.mp.lab04.dome.model.DVD;

/**
 * 1.- Empty library -> 0
 * 2.- non empty library, no owned media -> 0
 * 3.- non empty library, x cd owned -> x
 * 4.- non empty library, x dvd owned -> x
 * 5.- non empty library, x cd owned, y dvd owned -> x + y
 */
class MediaLibraryNumberOfItemsTests {

    private static final int MAX_PLAYING_TIME = 150; // minutes
    private static final int MAX_TRACKS = 15;
    private MediaLibrary library;
    private CD cd, otherCD;
    private DVD dvd, otherDVD;
    private Random random = new Random();

    @BeforeEach
    void beforeEach() {
        library = new MediaLibrary();

        cd = generateRandomCD();
        otherCD = generateRandomCD();
        dvd = generateRandomDVD();
        otherDVD = generateRandomDVD();
    }

    private DVD generateRandomDVD() {
        String title = UUID.randomUUID().toString();
        String director = UUID.randomUUID().toString();
        int playingTime = random.nextInt(1, MAX_PLAYING_TIME);
        return new DVD(title, director, playingTime, 0);
    }

    private CD generateRandomCD() {
        String title = UUID.randomUUID().toString();
        String artist = UUID.randomUUID().toString();
        int numTracks = random.nextInt(1, MAX_TRACKS);
        int playingTime = random.nextInt(1, MAX_PLAYING_TIME);
        return new CD(title, artist, numTracks, playingTime, 0);
    }

    /**
     * GIVEN: empty library
     * WHEN: number of items owned
     * THEN: 0
     */
    @Test
    void emptyLibrary() {

        assertEquals(0, library.numberOfItemsOwned());
    }

    /**
     * GIVEN: a non empty library, no cd neither dvd owned
     * WHEN: number of items owned
     * THEN: 0
     */
    @Test
    void nothingOwned() {
        library.add(cd);
        library.add(dvd);

        assertEquals(0, library.numberOfItemsOwned());
    }

    /**
     * GIVEN: a non empty library, some cd owned, no dvd owned
     * WHEN: number of items owned
     * THEN: number of cd owned
     */
    @Test
    void severalCDOwned() {
        cd.setGotIt(true);
        library.add(cd);
        library.add(otherCD);
        library.add(dvd);

        assertEquals(1, library.numberOfItemsOwned());
    }

    /**
     * GIVEN: a non empty library, no cd owned, some dvd owned
     * WHEN: number of items owned
     * THEN: number of dvd owned
     */
    @Test
    void severalDVDOwned() {
        library.add(cd);
        dvd.setGotIt(true);
        library.add(dvd);
        library.add(otherDVD);

        assertEquals(1, library.numberOfItemsOwned());

    }

    /**
     * GIVEN: a non empty library, some cd and dvd owned
     * WHEN: number of items owned
     * THEN: number of cd owned + number of dvd owned
     */
    @Test
    void severalCDAndDVDOwned() {
        cd.setGotIt(true);
        library.add(cd);
        dvd.setGotIt(true);
        library.add(dvd);
        library.add(otherDVD);
        library.add(otherCD);

        assertEquals(2, library.numberOfItemsOwned());
    }

}
