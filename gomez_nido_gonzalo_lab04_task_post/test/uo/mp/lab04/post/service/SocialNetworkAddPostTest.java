package uo.mp.lab04.post.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.post.model.Photo;
import uo.mp.lab04.post.model.Post;
import uo.mp.lab04.post.model.TextMessage;

/**
 * Test scenarios for addPOst():
 * 1. Valid post (TM) -> Added
 * 2. Valid post (Ph) -> Added
 * 3. Another valid post -> Added without deleting others
 * 4. Null post -> IAE
 */
class SocialNetworkAddPostTest {

	private SocialNetwork sn;
	private Post textPost;
	private Post photoPost;

	@BeforeEach
	void setUp() {
		sn = new SocialNetwork();
		textPost = new TextMessage("user1", "Hello world");
		photoPost = new Photo("user2", "coding.jpg", "Coding...");
	}

	/**
	 * GIVEN: An empty social network
	 * WHEN: A valid post is added
	 * THEN: Post is correctly added to the SN
	 */
	@Test
	public void testAddTextMessage() {
		sn.addPost(textPost);
		
		assertTrue(sn.getPosts().contains(textPost));
		assertEquals(1, sn.getPosts().size());
	}
	
	/**
	 * GIVEN: An empty social network
	 * WHEN: A valid post is added
	 * THEN: Post is correctly added to the SN
	 */
	@Test
	public void testAddPhoto() {
		sn.addPost(photoPost);
		
		assertTrue(sn.getPosts().contains(photoPost));
		assertEquals(1, sn.getPosts().size());
	}
	
	/**
	 * GIVEN: An empty social network
	 * WHEN: Two valid post are added
	 * THEN: Posts are correctly added to the SN
	 */
	@Test
	public void testAddTwoPosts() {
		sn.addPost(textPost);
		
		assertTrue(sn.getPosts().contains(textPost));
		assertEquals(1, sn.getPosts().size());
		
		sn.addPost(photoPost);
		
		assertTrue(sn.getPosts().contains(photoPost));
		assertTrue(sn.getPosts().contains(textPost));
		assertEquals(2, sn.getPosts().size());
	}
	
	/**
	 * GIVEN: An empty social network
	 * WHEN: A null post is added
	 * THEN: IAE
	 */
	@Test
	public void testAddNullPosts() {
		Post nullTM = null;
		
		assertThrows(IllegalArgumentException.class, () -> sn.addPost(nullTM));
	}
}