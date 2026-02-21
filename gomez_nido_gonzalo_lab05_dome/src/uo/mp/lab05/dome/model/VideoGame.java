package uo.mp.lab05.dome.model;

import java.io.PrintStream;
import java.util.Objects;

import uo.mp.util.check.ArgumentChecks;

public class VideoGame extends Item {

    public enum Platform {
        XBOX, PLAYSTATION, NINTENDO
    }

    public final static double VG_TAX = 0.1;

    private String author;
    private int numberOfPlayers;
    private Platform platform;

    public VideoGame(String theTitle, String author, Platform platform,
            int players, double price) {
        super(theTitle, price);
        setPlatform(platform);
        setAuthor(author);
        setNumberOfPlayers(players);
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        ArgumentChecks.isNotNull(platform, "Cannot be null");
        this.platform = platform;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        ArgumentChecks.isNotNull(author, "Cannot be null");
        ArgumentChecks.isNotBlank(author, "Cannot be blank");
        this.author = author;
    }

    public void print(PrintStream out) {
        out.println("[Type: VideoGame]");
        super.print(out);
        out.println("Platform: " + getPlatform());
        out.println("Number of players: " + getNumberOfPlayers());
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    /**
     * Returns the responsible for the video game
     * 
     * @return The videogame's author
     */
    @Override
    public String getResponsible() {
        return this.author;
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
        result = prime * result + Objects.hash(author, platform);
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
        VideoGame other = (VideoGame) obj;
        return Objects.equals(author, other.author)
                && Objects.equals(platform, other.platform);
    }

    /**
     * Turns all attributes into a string and returns it
     * 
     * @return String with all attributes of the object
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("VideoGame [");
        builder.append(super.toString());
        builder.append(", author=");
        builder.append(author);
        builder.append(", numberOfPlayers=");
        builder.append(numberOfPlayers);
        builder.append(", platform=");
        builder.append(platform);
        builder.append("]");
        return builder.toString();
    }

    /**
     * Calculates the price of the video game once taxes are applied.
     * 
     * @return The price of the video game after taxes
     */
    @Override
    public double getFinalPrice() {

        return this.getPrice() + (VG_TAX * this.getPrice());
    }
}
