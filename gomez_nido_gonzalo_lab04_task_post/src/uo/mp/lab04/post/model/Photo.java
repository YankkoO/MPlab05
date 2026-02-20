package uo.mp.lab04.post.model;

import uo.mp.util.check.ArgumentChecks;

public class Photo extends Post {
	
	private String fileName;
	private String caption;

	/**
	 * Constructor for Photo posts 
	 * @param user User's id
	 * @param filename name of the image file
	 * @param caption Message next to the photo
	 */
	public Photo(String user, String filename, String caption) {
		super(user);
		ArgumentChecks.isNotBlank(filename);
		ArgumentChecks.isNotNull(filename);
		ArgumentChecks.isNotBlank(caption);
		ArgumentChecks.isNotNull(caption);
		this.fileName = filename;
		this.caption = caption;
	}
	

	/**
	 * Public getter for filename
	 * @return a string with the file's name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Public getter for the caption
	 * @return a string with photo's caption
	 */
	public String getCaption() {
		return caption;
	}
	
	/**
	 * Turns all attributes of the current state into a string
	 * @return a string with all fields
	 */
	@Override
	public String toString() {
	    return "PHOTO Posted by: " + getUser() + ", File: " + getFileName() + ", Caption: " + getCaption();
	}
	
	/**
	 * Turns the photo info into HTML format
	 * 
	 * @return A String with the image-post information
	 */
	@Override
	public String toHtmlFormat() {
		return "<img src=" + getFileName() + "> " + getCaption() + " </img>";
	}

}
