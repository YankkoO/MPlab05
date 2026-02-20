package uo.mp.lab04.post.service;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.lab04.post.model.Post;
import uo.mp.util.check.ArgumentChecks;

public class SocialNetwork {

	private List<Post> posts = new ArrayList<>();

	/**
	 * Public getter for posts
	 * @return list with all posts
	 */
	public List<Post> getPosts() {
		return new ArrayList<>(posts);
	}
	
	/**
	 * Method for adding posts to the social network
	 * @param p post to add
	 */
	public void addPost(Post p) {
		ArgumentChecks.isNotNull(p);
		posts.add(p);	
	}
	
	/**
	 * Given an user id, searches for all their posts
	 * 
	 * @param id The id of the user we want to look for 
	 * @return a list with all user's posts
	 */
	public List<Post> findPostsByUser(String id) {
		
		ArgumentChecks.isNotBlank(id);
		ArgumentChecks.isNotNull(id);
		
		List<Post> idPosts = new ArrayList<>();
		
		for(Post post : posts) {
			if(post.getUser().equals(id)) {
				idPosts.add(post);
			}
		}
		return idPosts;
	}

	/**
	 * Prints all the posts in the social network to the given PrintStream.
	 * 
	 * @param out the output stream, cannot be null
	 * @throws IllegalArgumentException if out is null
	 */
	public void listAllPosts(PrintStream out) {
		ArgumentChecks.isNotNull(out);
		
		for(Post post : posts) {
			out.println(post.toString());
		}
	}
	
	/**
	 * Turns info of a Post into html format.
	 * 
	 * @return a list of Strings with all 'code' lines.
	 * 
	 */
	public List<String> toHtmlFormat(){
		List<String> htmlPosts = new ArrayList<>();
		
		for(Post p : posts) {
			ArgumentChecks.isNotNull(p, "Post can't be null"); //I feel is redundant but excel asks for it
			htmlPosts.add(p.toHtmlFormat());
		}
		return htmlPosts;
	}
}
