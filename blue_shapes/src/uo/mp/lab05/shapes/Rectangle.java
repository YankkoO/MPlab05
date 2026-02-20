package uo.mp.lab05.shapes;

import uo.mp.util.check.ArgumentChecks;

/**
 * A rectangle specifies an area in a coordinate space that is enclosed by the
 * the rectangle upper-left point (x, y) in the coordinate space, its width, and
 * its height.
 */
public class Rectangle extends AbstractShape {
	/**
	 * The width of the rectangle, in pixels.
	 */
	private int width;

	/**
	 * The height of the rectangle, in pixels.
	 */
	private int height;

	/**
         * Creates a new rectangle
         * 
         * @param  x      x coordinate of the lower left corner
         * @param  y      y coordinate of the lower left corner
         * @param  width  of the shape, in pixels
         * @param  height height of the rectangle, in pixels
         * @param  colour
         * @throws IAE    if some argument is illegal coordinates, width, height
         *                is 0 or
         *                under 0 colour is null
         */
        public Rectangle(int x, int y, int width, int height) {
            super(x, y, Colour.WHITE);
            this.width = width;
            this.height = height;
        }

	/**
	 * Creates a new rectangle
	 * 
	 * @param x      x coordinate of the lower left corner
	 * @param y      y coordinate of the lower left corner
	 * @param width  of the shape, in pixels
	 * @param height height of the rectangle, in pixels
	 * @param colour
	 * @throws IAE if some argument is illegal coordinates, width, height is 0 or
	 *             under 0 colour is null
	 */
        public Rectangle(int x, int y, int width, int height, Colour colour) {
            super(x, y, colour);
            ArgumentChecks.isTrue(x >= 0,
                    "x coordinate must be greater or equal than 0 (%d provided)"
                            .formatted(x));
            ArgumentChecks.isTrue(y >= 0,
                    "y coordinate must be greater or equal than 0 (%d provided)"
                            .formatted(y));
            ArgumentChecks.isTrue(width > 0,
                    "Width must be a natural number (%d provided)"
                            .formatted(width));
            ArgumentChecks.isTrue(height > 0,
                    "Height must be a natural number (%d provided)"
                            .formatted(height));
            ArgumentChecks.isNotNull(colour != null, "Colour cannot be null");

            
            this.width = width;
            this.height = height;
        }

        /**
         * Public getter for the width attribute
         * @return Width of the rectangle
         */
        public int getWidth() {
            return width;
        }

        /**
         * Public getter for the height attribute
         * @return Height of the rectangle
         */
        public int getHeight() {
            return height;
        }

        /**
         * Returns a string with the rectangle data
         */
        @Override
        public String toString() {
            return "Rectangle at (" + getX() + ", " + getY() +")" 
            + " Height: " + getHeight() 
            + " Width: " + getWidth()
            + " Colour: " + getColour();
        }

}
