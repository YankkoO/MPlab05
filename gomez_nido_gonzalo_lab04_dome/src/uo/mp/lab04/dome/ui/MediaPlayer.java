package uo.mp.lab04.dome.ui;

import uo.mp.lab04.dome.model.Book;
import uo.mp.lab04.dome.model.CD;
import uo.mp.lab04.dome.model.DVD;
import uo.mp.lab04.dome.model.VideoGame;
import uo.mp.lab04.dome.model.VideoGame.Platform;
import uo.mp.lab04.dome.service.MediaLibrary;

public class MediaPlayer {

    private MediaLibrary library = new MediaLibrary();

    public void start() {
        CD cd1 = new CD("title CD 1", "Artist 1", 1, 10, 32);
        CD cd2 = new CD("title CD 2", "Artist 2", 2, 20, 40);
        CD cd3 = new CD("title CD 3", "Artist 2", 3, 30, 50);
        CD cd4 = new CD("title CD 4", "Artist 1", 4, 40, 10);

        CD newCD5 = new CD("title CD 4", "Artist 1", 4, 40, 10);
        CD newCD6 = new CD("title CD 4", "Artist 1", 4, 40, 10);

        library.add(cd1);
        library.add(cd2);
        library.add(cd3);
        library.add(cd4);
        newCD5.setGotIt(true);
        newCD6.setGotIt(true);
        library.add(newCD5);
        library.add(newCD6);

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

        Book b1 = new Book("Harry Potter 1", 18.0, "J.K. Rowling",
                "Publisher A", "A56324");
        Book b2 = new Book("Harry Potter 2", 18.0, "J.K. Rowling",
                "Publisher B", "A39716");
        Book b3 = new Book("Harry Potter 3", 18.0, "J.K. Rowling",
                "Publisher C", "A96471");
        Book b4 = new Book("Harry Potter 4", 18.0, "J.K. Rowling",
                "Publisher D", "A56132");
        Book b5 = new Book("Harry Potter 5", 18.0, "J.K. Rowling",
                "Publisher E", "A79613");

        b1.setGotIt(true);
        library.add(b1);
        b2.setGotIt(true);
        library.add(b2);
        library.add(b3);
        library.add(b4);
        library.add(b5);

        library.list(System.out);

        newCD5.borrow();
        b2.borrow();

        System.out.println(library.getBorrowables());
        System.out.println(library.getAvailables());

    }

}
