package uo.mp.lab04.dome.model;

import java.io.PrintStream;
import java.util.Objects;

import uo.mp.util.check.ArgumentChecks;

public abstract class Item {

    public final static double MIN_PRICE = 0.0;
    public final static double MAX_PRICE = 1000.00;

    private String title;
    private double price;
    private boolean gotIt;
    private String comment = "No comment";

    /**
     * Creates a new Item with default values for gotIt and comment
     * 
     * @param theTitle String for title
     * @param time     integer for time
     */
    public Item(String theTitle, double price) {

        ArgumentChecks.isNotNull(theTitle);
        ArgumentChecks.isNotBlank(theTitle);

        setTitle(theTitle);
        setPrice(price);
    }

    public void print(PrintStream out) {
        this.toString();
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {

        ArgumentChecks.isTrue(price >= 0 && price <= 1000,
                "Price must be between " + MIN_PRICE + "-" + MAX_PRICE + ".");

        this.price = price;
    }

    /**
     * @return the comment (if any) or default
     */
    public String getComment() {
        return comment;
    }

    /**
     * @return number of tracks
     */
    public int getNumberOfTracks() {
        return this.getNumberOfTracks();
    }

    /**
     * @return title
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return true if we own a copy; false otherwise
     */
    public boolean isGotIt() {
        return gotIt;
    }

    /**
     * 
     * @param    arg String with a new comment to the element
     * @implNote     If the argument is null or does not contain meaningful
     *               characters (other than blanks, new lines, etc) previous
     *               comment stays as it is
     */
    public void setComment(String arg) {
        if (arg != null && !arg.isBlank()) {
            this.comment = arg;
        }
    }

    /**
     * 
     * @param boolean true means we own a copy; otherwise, false
     */
    public void setGotIt(boolean ownIt) {
        gotIt = ownIt;
    }

    /**
     * 
     * @param  arg                      String with the new title
     * @throws IllegalArgumentException if the argument is null, 0-length or
     *                                  does not contain meaningful characters
     */
    private void setTitle(String arg) {
        ArgumentChecks.isNotBlank(arg,
                "Invalid title (cannot be null nor blank)");
        this.title = arg;
    }

    public abstract String getResponsible();

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Item other = (Item) obj;
        return Objects.equals(title, other.title);
    }

    /**
     * Returns a string with all fields of the Item
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("title=");
        builder.append(title);
        builder.append(", price=");
        builder.append(price);
        builder.append(", gotIt=");
        builder.append(gotIt);
        builder.append(", comment=");
        builder.append(comment);
        return builder.toString();
    }

    public abstract double getFinalPrice();

    /**
     * Generates the item's code
     * 
     * @param  position The position of the item in the media library
     * 
     * @return          A string with first three letters in the title followed
     *                  by its position in the library
     */
    public String generateCode(int position) {
        String subTitle = "";

        if (this.title.length() >= 3) {
            subTitle = this.title.substring(0, 3);
        } else {
            subTitle = this.title;
        }
        return subTitle + position;
    }

}
