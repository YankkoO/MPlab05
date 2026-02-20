package uo.mp.lab04.post.model;


import uo.mp.util.check.ArgumentChecks;

public class TextMessage extends Post{

	private String message;
	
	/**
	 * Public constructor for the TextMessage class
	 * @param user user's id
	 * @param message message that is posted
	 */
	public TextMessage(String user, String message) {
		super(user);
		ArgumentChecks.isNotBlank(message);
		ArgumentChecks.isNotNull(message);
		this.message = message;
	}

	/**
	 * public getter for the Message
	 * @return a string with the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Method that turns every field in the current state into a string
	 * @return a string with all fields
	 */
	@Override
	public String toString() {
		return "TEXT MESSAGE Posted by: " + getUser() + ", Content: " + getMessage();
	}
	
	/**
	 * Makes the text message into a HTML format
	 * 
	 * @return Message in HTML format
	 */
	@Override
	public String toHtmlFormat() {
		return "<p>" + getMessage() + "</p>";
	}
	
	
}
