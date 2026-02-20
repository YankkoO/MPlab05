package uo.mp.lab05.shapes;

import java.io.PrintStream;

import uo.mp.lab05.drawing.software.Drawable;
import uo.mp.util.check.ArgumentChecks;

public abstract class AbstractShape implements Drawable {

    private int x;
    private int y;
    private Colour colour;
    
    /**
     * Super constructor of the class AbstractShape for the
     * child classes
     * 
     * @param x X coordinate for the shape in the canvas
     * @param y Y coordinate for the shape in the canvas
     * @param colour Colour for the shape in the canvas
     */
    public AbstractShape(int x, int y, Colour colour) {
        ArgumentChecks.isTrue(x >= 0);
        ArgumentChecks.isTrue(y >= 0);
        this.x = x;
        this.y = y;
        this.colour = colour;
    }

    /**
     * Public getter for the AbstractShape class
     * @return color of the shape
     */
    public Colour getColour() {
        return colour;
    }

    /**
     * Public getter for the x coordinate
     * @return x coordinate of the shape
     */
    public int getX() {
        return x;
    }

    /**
     * public getter for the y coordinate
     * @return y coordinate of the shape
     */
    public int getY() {
        return y;
    }

    /**
     * Public setter for the colour of the shape
     * @param colour colour to be assigned
     */
    public void setColour(Colour colour) {
        this.colour = colour;
    }

    /**
     * Public setter for the X coordinate
     * @param x X coordinate to be assigned
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Public setter for the Y coordinate
     * @param y Y coordinate to be assigned
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Simulates drawing into a canvas
     */
    public void draw(PrintStream out) {
        out.println( this );
    }
    
    
    public abstract String toString();
    
    

}
