package uo.mp.lab05.dome.ui;

import uo.mp.lab05.dome.model.Book;
import uo.mp.lab05.dome.model.CD;
import uo.mp.lab05.dome.model.DVD;
import uo.mp.lab05.dome.model.VideoGame;
import uo.mp.lab05.dome.model.VideoGame.Platform;
import uo.mp.lab05.dome.service.MediaLibrary;

public class MediaPlayer {

    private MediaLibrary library = new MediaLibrary();

    public void start() {
        CD cd1 = new CD("title CD 1", "Artist 1", 1, 10, 32);
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

        Book b1 = new Book("La sombra del viento", 20.0, "Zafón", "Planeta",
                "A1234");
        b1.setGotIt(true);
        Book b2 = new Book("Cien años de soledad", 25.0, "G. Márquez",
                "Sudamericana", "B5678");
        b2.setGotIt(true);
        Book b3 = new Book("El Quijote", 15.0, "Cervantes", "RAE", "C9012");
        Book b4 = new Book("1984", 12.0, "Orwell", "Seix Barral", "D3456");
        Book b5 = new Book("Fahrenheit 451", 11.0, "Bradbury", "Minotauro",
                "E7890");

        library.add(b1);
        library.add(b2);
        library.add(b3);
        library.add(b4);
        library.add(b5);

        CD cd10 = new CD("Thriller", "Michael Jackson", 9, 42, 18.0);
        cd10.setGotIt(true);
        CD cd11 = new CD("Back in Black", "AC/DC", 10, 41, 15.0);
        cd11.setGotIt(true);
        CD cd12 = new CD("Blue Train", "John Coltrane", 5, 32, 12.0);

        library.add(cd10);
        library.add(cd11);
        library.add(cd12);

        library.borrow(b1);
        library.borrow(cd10);

        System.out.println("--- FULL LIBRARY ---");
        library.list(System.out);

        System.out.println("\n--- BORROWABLES (getBorrowables) ---");
        System.out.println(library.getBorrowables());

        System.out.println("\n--- AVAILABLES (getAvailables) ---");
        System.out.println(library.getAvailables());
    }

}
