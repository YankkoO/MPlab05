package uo.mp.lab04.dome.ui;

import uo.mp.lab04.dome.model.CD;
import uo.mp.lab04.dome.model.DVD;
import uo.mp.lab04.dome.model.VideoGame;
import uo.mp.lab04.dome.model.VideoGame.Platform;
import uo.mp.lab04.dome.service.MediaLibrary;

public class MediaPlayer {

    private MediaLibrary library = new MediaLibrary();

    public void start() {
        CD cd1 = new CD("title CD 2", "Artist 1", 1, 10, 32);
        CD cd2 = new CD("title CD 2", "Artist 2", 2, 20, 40);
        CD cd3 = new CD("title CD 3", "Artist 2", 3, 30, 50);
        CD cd4 = new CD("title CD 4", "Artist 1", 4, 40, 10);

        library.add(cd1);
        library.add(cd2);
        library.add(cd3);
        library.add(cd4);

        DVD dvd1 = new DVD("title DVD 1", "Director 1", 100, 25);
        DVD dvd2 = new DVD("title DVD 2", "Director 2", 200, 30);

        library.add(dvd1);
        library.add(dvd2);

        VideoGame vg1 = new VideoGame("game title", "game author",
                Platform.NINTENDO, 2, 60);
        VideoGame vg2 = new VideoGame("game title2", "game author2",
                Platform.PLAYSTATION, 4, 79);
        VideoGame vg3 = new VideoGame("game title3", "game author3",
                Platform.XBOX, 4, 75);

        library.add(vg1);
        library.add(vg2);
        library.add(vg3);

        library.list(System.out);

        // set own cd1

        // Add the following comment to that dvd2:
        // "Incredible. One of the best films I’ve come across recently."

        // call to numberOfItemsOwned and print a message in the screen

        // call list again
    }

}
