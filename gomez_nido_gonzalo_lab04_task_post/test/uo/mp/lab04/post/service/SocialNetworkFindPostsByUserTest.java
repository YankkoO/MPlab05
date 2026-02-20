package uo.mp.lab04.post.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.post.model.Photo;
import uo.mp.lab04.post.model.Post;
import uo.mp.lab04.post.model.TextMessage;

/**
 * Test cases for findPostsByUser(String userId) method.
 */
class SocialNetworkFindPostsByUserTest {

	private SocialNetwork sn;
	private Post post1User1;
	private Post post1User2;
	private Post post2User1;

	@BeforeEach
	void setUp() {
		sn = new SocialNetwork();
		post1User1 = new TextMessage("user1", "Message 1 from user 1");
		post1User2 = new Photo("user2", "image.jpg", "User 2 photo");
		post2User1 = new TextMessage("user1", "Message 2 from user 1");
		
		sn.addPost(post1User1);
		sn.addPost(post1User2);
		sn.addPost(post2User1);
	}

	/**
	 * GIVEN: A social network with posts from different users
	 * WHEN: Searching for posts of an existing user
	 * THEN: A list with only that user's posts is returned
	 */
	@Test
	void testFindPostsUserExists() {
		List<Post> result = sn.findPostsByUser("user1");
		
		assertEquals(2, result.size());
		assertTrue(result.contains(post1User1));
		assertTrue(result.contains(post2User1));
		assertFalse(result.contains(post1User2));
	}

	/**
	 * GIVEN: A social network with posts
	 * WHEN: Searching for a user that has no posts
	 * THEN: An empty list is returned (not null)
	 */
	@Test
	void testFindPostsUserNotExists() {
		List<Post> result = sn.findPostsByUser("nonExistentUser");
		
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	/**
	 * GIVEN: A social network
	 * WHEN: Searching with a null or blank userId
	 * THEN: IllegalArgumentException is thrown
	 */
	@Test
	void testFindPostsInvalidUser() {
		assertThrows(IllegalArgumentException.class, () -> {
			sn.findPostsByUser(null);
		});
		assertThrows(IllegalArgumentException.class, () -> {
			sn.findPostsByUser("");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			sn.findPostsByUser("   ");
		});
	}
}