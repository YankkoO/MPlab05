package uo.mp.lab04.dome.model;

import java.io.PrintStream;
import java.util.Objects;

import uo.mp.util.check.ArgumentChecks;

public class DVD extends Item {

    public final static double DVD_TAX = 0.0;

    private String director;
    private int playingTime;

    /**
     * Creates a new Dvd with default values for gotIt and comment
     * 
     * @param theTitle    String for title
     * @param theDirector String for director
     * @param time        integer for time
     */
    public DVD(String theTitle, String theDirector, int time, double price) {
        super(theTitle, price);
        setDirector(theDirector);
        setPlayingTime(time);
    }

    /**
     * 
     * @param  arg                      String with the new director
     * @throws IllegalArgumentException if the argument is null, 0-length or
     *                                  does not contain meaningful characters
     */
    private void setDirector(String arg) {
        ArgumentChecks.isNotBlank(arg,
                "Invalid director (cannot be null nor blank)");
        this.director = arg;
    }

    /**
     * @return the director of the dvd
     */
    public String getDirector() {
        return this.director;
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
        super.print(out);
    }

    /**
     * Returns the responsible person for the DVD
     * 
     * @return The director
     */
    @Override
    public String getResponsible() {
        return this.director;
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
        result = prime * result + Objects.hash(director);
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
        DVD other = (DVD) obj;
        return Objects.equals(director, other.director);
    }

    /**
     * Turns all attributes into a string and returns it
     * 
     * @return String with all attributes of the object
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("DVD [");
        builder.append(super.toString());
        builder.append(", director=");
        builder.append(director);
        builder.append(", playingTime=");
        builder.append(playingTime);
        builder.append("]");
        return builder.toString();
    }

    /**
     * Calculates the price of the DVD once taxes are applied.
     * 
     * @return The price of the DVD after taxes
     */
    @Override
    public double getFinalPrice() {

        return this.getPrice() + DVD_TAX;
    }

}
