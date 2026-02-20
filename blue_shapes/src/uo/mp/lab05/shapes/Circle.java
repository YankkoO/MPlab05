package uo.mp.lab05.shapes;

import uo.mp.util.check.ArgumentChecks;

public class Circle extends AbstractShape {
    
    private int radius;
    /**
     * Public constructor for the Circle class
     * @param x X coordinate for the circle
     * @param y Y coordinate for the circle
     * @param radious radius length for the circle
     * @param colour colour for the circle
     */
    public Circle(int x, int y, int radious, Colour colour) {
        super(x, y, colour);
        ArgumentChecks.isTrue( radious >= 0 );
        this.radius = radious;
    }

    /**
     * Public getter for the radius
     * @return Length of the radius
     */
    public int getRadious() {
        return radius;
    }

    /**
     * Public setter for the radius
     * @param radious Radius length to be assigned
     */
    public void setRadious(int radious) {
        this.radius = radious;
    }

    

    /**
     * Returns a string with all circle data
     */
    @Override
    public String toString() {
        return "Circle at (" + getX() + "," + getY() + ")"
        + " Radious: " + getRadious()
        + " Colour: " + getColour();
    }

    

}
