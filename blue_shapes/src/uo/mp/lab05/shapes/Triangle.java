package uo.mp.lab05.shapes;

public class Triangle extends AbstractShape {
    
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    /**
     * Public constructor for the triangle class
     * @param x X coordinate for the triangle
     * @param y Y coordinate for the triangle
     * @param x1 X1 coordinate for the triangle
     * @param y1 Y1 coordinate for the triangle
     * @param x2 X2 coordinate for the triangle
     * @param y2 Y2 coordinate for the triangle
     * @param colour Colour for the triangle
     */
    public Triangle(int x, int y, int x1, int y1, int x2, int y2, Colour colour) {
        super(x, y, colour);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        
    }

    /**
     * Public getter for one of the triangle's corner
     * @return X1 coordinate
     */
    public int getX1() {
        return x1;
    }

    /**
     * Public setter for one of the triangle's corner
     * @param x1 X1 coordinate to be assigned
     */
    public void setX1(int x1) {
        this.x1 = x1;
    }

    /**
     * Public getter for one of the triangle's corner
     * @return Y1 coordinate
     */
    public int getY1() {
        return y1;
    }

    /**
     * Public setter for one of the triangle's corner
     * @param y1 Y1 coordinate to be assigned
     */
    public void setY1(int y1) {
        this.y1 = y1;
    }

    /**
     * Public getter one of the triangle's corner
     * @return X2 coordinate
     */
    public int getX2() {
        return x2;
    }

    /**
     * Public setter for one of the triangle's corner
     * @param x2 X2 coordinate to be assigned
     */
    public void setX2(int x2) {
        this.x2 = x2;
    }

    /**
     * Public getter one of the triangle's corner
     * @return y1 coordinate
     */
    public int getY2() {
        return y2;
    }

    /**
     * Public setter for one of the triangle's corner
     * @param y2 Y2 coordinate to be assigned
     */
    public void setY2(int y2) {
        this.y2 = y2;
    }

    /**
     * Returns a string with all data for the triangle in the canvas
     */
    @Override
    public String toString() {
        return "Triangle at (" + getX() + "," + getY() + ")"
                + ",(" + getX1() + ", " + getY1() + ")"
                + ",(" + getX2() + ", " + getY2() + ")"
                + " Colour: " + getColour();
                
    }
    
    

}
