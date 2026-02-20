package uo.mp.lab05.client.ui;

import java.io.PrintStream;

import uo.mp.lab05.drawing.software.Drawable;

public class Picture implements Drawable {

	private int x;
	private int y;
	private int width;
	private int height;
	private String filename;

	/**
	 * Public constructor for the Picture class
	 * @param x X coordinate of the picture origin
	 * @param y Y coordinate of the picture origin
	 * @param width Length in the X axis of the picture
	 * @param height Length  in the Y axis of the picture
	 * @param filename Path of the picture's file
	 */
	public Picture(int x, int y, int width, int height, String filename) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.filename = filename;
	}

	/**
	 * Gets the x coordinate value
	 * @return X coordinate
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x coordinate value
	 * @param x Coordinate we want to assign to X axis
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y coordinate value
	 * @return y coordinate
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the Y coordinate value
	 * @param Y Coordinate we want to assign to Y axis
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Gets the width value
	 * @return picture's width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width value
	 * @param width Width value to be assigned
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Gets the height value
	 * @return height value
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the desired height
	 * @param height Height to be assigned
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Gets the name of the file picture is stored in
	 * @return name of the file
	*/
	public String getFilename() {
		return filename;
	}

	/**
	 * Sets the name of the picture's file
	 * @param filename Name of the file to be assigned
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * Prints in the console data for the current instance
	 */
	@Override
	public void draw(PrintStream out) {
		out.println( this );
	}

	/**
	 * Creates a String with all attributes and returns it
	 * @return String with all attributes
	 */
	@Override
	public String toString() {
		return
				"Picture at (" + getX() + "," + getY() + ") "
				+ "Height: " + getHeight() 
				+ " Width: " + getWidth()
				+ " Picture: " + getFilename();
	}

}
