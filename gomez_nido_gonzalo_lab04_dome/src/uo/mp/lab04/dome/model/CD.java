package uo.mp.lab04.dome.model;

import java.io.PrintStream;
import java.util.Objects;

import uo.mp.util.check.ArgumentChecks;

public class CD extends Item implements Borrowable {

    public final static double CD_TAX = 2.00; //Fixed tax of 2.00€.

    private String artist;
    private int numberOfTracks;
    private int playingTime;
    private boolean isAvailable;

    /**
     * Creates a new CD with default values for gotIt and comment
     * 
     * @param theTitle  String for title
     * @param theArtist String for artist
     * @param tracks    integer for tracks
     * @param time      integer for time
     */
    public CD(String theTitle, String theArtist, int tracks, int time,
            double price) {
        super(theTitle, price);
        setArtist(theArtist);
        setNumberOfTracks(tracks);
        setPlayingTime(time);
    }

    /**
     * 
     * @param  arg                      String with the new artist name
     * @throws IllegalArgumentException if the argument is null, 0-length or
     *                                  does not contain meaningful characters
     */
    private void setArtist(String arg) {
        ArgumentChecks.isNotBlank(arg,
                "Invalid artist (cannot be null nor blank)");
        this.artist = arg;
    }

    /**
     * 
     * @param  arg                      integer with the number of tracks in the
     *                                  CD
     * @throws IllegalArgumentException if the argument is is lower or equal
     *                                  zero
     */
    private void setNumberOfTracks(int arg) {
        ArgumentChecks.isTrue(arg > 0,
                "Invalid number of tracks %d (must be a positive integer)"
                        .formatted(arg));
        this.numberOfTracks = arg;
    }

    /**
     * @return artist's name
     */
    public String getArtist() {
        return this.artist;
    }

    /**
     * @return number of tracks
     */
    public int getNumberOfTracks() {
        return this.numberOfTracks;
    }

    /**
     * 
     * @param  arg                      integer with the playing time in the CD
     * @throws IllegalArgumentException if the argument is is lower or equal
     *                                  zero
     */
    private void setPlayingTime(int arg) {
        ArgumentChecks.isTrue(arg > 0,
                "Invalid playing time %d (must be a positive integer)"
                        .formatted(arg));
        this.playingTime = arg;
    }

    /**
     * @return playing time
     */
    public int getPlayingTime() {
        return this.playingTime;
    }

    /**
     * Flushes into out information about the CD
     * 
     * @param out a PrintStream to flush output
     */
    public void print(PrintStream out) {
        out.println("[Type: CD]");
        super.print(out);
        out.println("Tracks: " + getNumberOfTracks());
    }

    /**
     * Returns the responsible person for the CD
     * 
     * @return Cd's artist
     */
    @Override
    public String getResponsible() {
        return this.artist;
    }

    /**
     * Returns the hash code of the object
     * 
     * @return Hash code of the object
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Objects.hash(artist);
        return result;
    }

    /**
     * Overrides the ".equals()" method to compare the desired fields in order
     * to check whether items are the same
     * but with a different reference
     * 
     * @return True if desired fields are the same. False otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        CD other = (CD) obj;
        return Objects.equals(artist, other.artist);
    }

    /**
     * Turns all attributes into a string and returns it
     * 
     * @return String with all attributes of the object
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CD [");
        builder.append(super.toString());
        builder.append(", artist=");
        builder.append(artist);
        builder.append(", numberOfTracks=");
        builder.append(numberOfTracks);
        builder.append(", playingTime=");
        builder.append(playingTime);
        builder.append("]");
        return builder.toString();
    }

    /**
     * Calculates the price of the CD once taxes are applied.
     * 
     * @return The price of the CD after taxes
     */
    @Override
    public double getFinalPrice() {

        return this.getPrice() + CD_TAX;
    }

    @Override
    public void borrow() {
        if (isAvailable()) {
            this.isAvailable = false;
        }
    }

    @Override
    public void giveBack() {
        if (isGotIt() && !this.isAvailable) {
            this.isAvailable = true;
        }
    }

    @Override
    public boolean isAvailable() {
        return this.isAvailable;
    }

}