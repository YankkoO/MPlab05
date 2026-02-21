package uo.mp.lab05.dome.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab05.dome.model.CD;
import uo.mp.lab05.dome.model.DVD;
import uo.mp.lab05.dome.model.Item;

/**
 * 1.- Try to add a null CD -> IAE
 * 2.- Try to add a null DVD -> IAE
 * 3.- Add a CD into an empty library -> added
 * 4.- Add a DVD into an empty library -> added
 * 5.- Add one more CD -> increases size, contains new cd
 * 6.- Add one more DVD -> increases size, contains new dvd
 */
class MediaLibraryAddTests {

    private static final int MAX_PLAYING_TIME = 150; // minutes
    private static final int MAX_TRACKS = 15;
    private MediaLibrary library;
    private CD cd;
    private DVD dvd;
    private Random random = new Random();

    @BeforeEach
    void beforeEach() {
        library = new MediaLibrary();

        cd = generateRandomCD();
        dvd = generateRandomDVD();
    }

    private DVD generateRandomDVD() {
        String title = UUID.randomUUID().toString();
        String director = UUID.randomUUID().toString();
        int playingTime = random.nextInt(1, MAX_PLAYING_TIME);
        double price = random.nextDouble(Item.MIN_PRICE, Item.MAX_PRICE);
        return new DVD(title, director, playingTime, price);
    }

    private CD generateRandomCD() {
        String title = UUID.randomUUID().toString();
        String artist = UUID.randomUUID().toString();
        int numTracks = random.nextInt(1, MAX_TRACKS);
        int playingTime = random.nextInt(1, MAX_PLAYING_TIME);
        double price = random.nextDouble(Item.MIN_PRICE, Item.MAX_PRICE);
        return new CD(title, artist, numTracks, playingTime, price);
    }

    /**
     * GIVEN: a library
     * WHEN: add a null cd
     * THEN: IAE
     */
    @Test
    void nullCD() {
        CD cd = null;

        assertThrows(IllegalArgumentException.class, () -> library.add(cd));
    }

    /**
     * GIVEN: a library
     * WHEN: add a null dvd
     * THEN: IAE
     */
    @Test
    void nullDVD() {
        DVD dvd = null;

        assertThrows(IllegalArgumentException.class, () -> library.add(dvd));
    }

    /**
     * GIVEN: an empty library
     * WHEN: add a not null cd
     * THEN: library contains the cd
     */
    @Test
    void notNullCDEmptyLibrary() {
        library.add(cd);

        List<Item> cds = library.getCDs();

        assertEquals(1, cds.size());
        assertTrue(cds.contains(cd));

    }

    /**
     * GIVEN: an empty library
     * WHEN: add a not null dvd
     * THEN: library contains the dvd
     */
    @Test
    void notNullDVDEmptyLibrary() {
        library.add(dvd);

        List<Item> dvds = library.getDVDs();

        assertEquals(1, dvds.size());
        assertTrue(dvds.contains(dvd));
    }

    /**
     * WHEN: add a not null cd
     * THEN: library contains the cd, one more cd than before
     */
    @Test
    void severalCD() {
        library.add(cd);
        library.add(cd);
        library.add(cd);

        int count = library.getCDs().size();

        CD newCD = new CD("title", "artist", 200, 20, 20.5);

        library.add(newCD);

        List<Item> cds = library.getCDs();
        assertEquals(count + 1, cds.size());
        assertTrue(cds.contains(newCD));

    }

    /**
     * WHEN: add a not null dvd
     * THEN: library contains the dvd, one more dvd than before
     */
    @Test
    void severalDVD() {
        library.add(dvd);
        library.add(dvd);
        library.add(dvd);

        int count = library.getDVDs().size();

        DVD newDVD = new DVD("title", "director", 200, 20.5);

        library.add(newDVD);

        List<Item> dvds = library.getDVDs();
        assertEquals(count + 1, dvds.size());
        assertTrue(dvds.contains(newDVD));

    }

}
