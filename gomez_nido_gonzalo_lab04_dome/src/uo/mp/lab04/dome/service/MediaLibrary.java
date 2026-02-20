package uo.mp.lab04.dome.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab04.dome.model.Borrowable;
import uo.mp.lab04.dome.model.CD;
import uo.mp.lab04.dome.model.DVD;
import uo.mp.lab04.dome.model.Item;
import uo.mp.lab04.dome.model.VideoGame;
import uo.mp.util.check.ArgumentChecks;

public class MediaLibrary {

    /*
     * Media library collection of medias (CD, DVD, etc)
     */
    private List<Item> items = new ArrayList<>();

    /**
     * @param media to add in the library
     */
    public void add(Item item) {
        ArgumentChecks.isNotNull(item);
        items.add(item);
    }

    /**
     * 
     * @return the number of owned medias in the library
     * 
     */
    public int numberOfItemsOwned() {

        int count = 0;

        for (Item item : items) {
            if (item.isGotIt()) {
                count++;
            }
        }

        return count;
    }

    /**
     * Flushes in the out object every media in the library
     * 
     * @param out PrintStrean to write
     */
    public void list(PrintStream out) {
        for (Item item : items) {
            out.println(item);
        }
    }

    /**
     * Returns all Items in the library.
     * 
     * @return Items in library.
     */
    public List<Item> getItems() {
        return new ArrayList<>(items);
    }

    public List<Item> getCDs() {
        List<Item> cds = new ArrayList<>();
        for (Item item : items) {
            if (item.getClass() == CD.class) {
                cds.add(item);
            }
        }
        return cds;
    }

    public List<Item> getDVDs() {
        List<Item> dvds = new ArrayList<>();
        for (Item item : items) {
            if (item.getClass() == DVD.class) {
                dvds.add(item);
            }
        }
        return dvds;
    }

    public List<Item> getVideoGames() {
        List<Item> games = new ArrayList<>();
        for (Item item : items) {
            if (item.getClass() == VideoGame.class) {
                games.add(item);
            }
        }
        return games;
    }

    /**
     * Searches in the library for the desired item passed as parameter
     * 
     * @param  item The item we want to look for
     * 
     * @return      The item found or null if it was not found
     */
    public Item searchItem(Item item) {
        ArgumentChecks.isNotNull(item);
        for (Item mediaItem : items) {

            if (mediaItem.equals(item)) {
                return mediaItem;
            }
        }
        return null;
    }

    /**
     * Returns a list with all the responsible for the media library
     * items
     * 
     * @return A list with all responsible
     */
    public List<String> getResponsibles() {
        List<String> responsibles = new ArrayList<>();

        for (Item item : items) {
            responsibles.add(item.getResponsible());
        }
        return responsibles;
    }

    /**
     * Total price of the media library after taxes
     * 
     * @return The total price of the library after taxes
     */
    public double getTotalPrice() {
        double totalPrice = 0.00;
        for (Item i : items) {
            totalPrice += i.getFinalPrice();
        }
        return totalPrice;
    }

    /**
     * Generates a code for each item in the library where title and position
     * are taken into account.
     * 
     * For example for CD [Title: ABCD, Position:0] [Title:WXYZ, Position 1] -->
     * ABC0-WXY1
     * 
     * @return All codes for every element in the media library
     */
    public String generateCodes() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            Item theItem = items.get(i);
            builder.append(theItem.generateCode(i));
            if (i != items.size() - 1) {
                builder.append("-");
            }
        }
        return builder.toString();
    }

    /**
     * Returns a list with all borrowable items
     * 
     * @return List of borrowable items
     */
    public List<Borrowable> getBorrowables() {
        List<Borrowable> borrowables = new ArrayList<>();

        for (Item i : items) {
            if (i instanceof Borrowable) {
                borrowables.add((Borrowable) i);
            }
        }
        return borrowables;
    }

    /**
     * Returns a list with all available items.
     */
    public List<Borrowable> getAvailables() {
        List<Borrowable> availables = new ArrayList<>();
        for (Borrowable b : getBorrowables()) {
            if (b.isAvailable()) {
                availables.add(b);
            }
        }
        return availables;
    }

    /**
     * 
     */
    public boolean borrow(Borrowable item) {
        ArgumentChecks.isNotNull(item, "Item can't be null");

        for (Borrowable b : getAvailables()) {
            if (b.equals(item)) {
                b.borrow();
                return true;
            }
        }
        return false;
    }

    /**
     * 
     */
    public boolean giveBack(Borrowable item) {
        ArgumentChecks.isNotNull(item, "Item can't be null");

        for (Borrowable b : getBorrowables()) {
            if (b.equals(item)) {
                b.giveBack();
                return true;
            }
        }
        return false;
    }

}
