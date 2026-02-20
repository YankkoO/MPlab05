package uo.mp.lab04.post.model;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.util.check.ArgumentChecks;

public abstract class Post {

	private String user;
	private int likes;
	private List<String> comments;
	
	/**
	 * public constructor for the Post class. Likes and comments are set to 0
	 * @param user user's id
	 */
	public Post(String user) {
		ArgumentChecks.isNotBlank(user);
		ArgumentChecks.isNotNull(user);
		
		this.user = user;
		this.likes = 0;
		this.comments = new ArrayList<>();
	}


	/**
	 * public getter for the user field
	 * @return a string with the user's id
	 */
	public String getUser() {
		return user;
	}

	/**
	 * public getter for the likes field
	 * @return an integer with the likes
	 */
	public int getLikes() {
		return likes;
	}


	/**
	 * public setter for the likes field
	 * @param likes number of likes to be assigned to a post
	 */
	 public void setLikes(int likes) {
		this.likes = likes;
	}


	 /**
	 * public getter for the comments field
	 * @return a string's list with all comments in the post
	 */
	public List<String> getComments() {
		return comments;
	}


	/**
	 * public setter for the comments field
	 * @param comments list of comments to be added to the post
	 */
	public void setComments(List<String> comments) {
		this.comments = comments;
	}

	/**
	 * Method that turns all attributes into a string.
	 * 
	 * Method is by each post type method. 
	 * 
	 * @return Unknown if post is null. Attributes otherwise.
	 */
	public abstract String toString();

	/**
	 * Converts the Post into a HTML format
	 * @return A String with the HTML representation
	 */
	public abstract String toHtmlFormat();
	
	

	/**
	 * Prints the post to the given output stream.
	 * @param out The output stream where the post will be printed.
	 * @throws IllegalArgumentException if the output stream is null.
	 */
	public void print(PrintStream out) {

	    ArgumentChecks.isNotNull(out, "The output stream cannot be null");
	    
	    out.println(this.toString());
	}
	
	
	
}
