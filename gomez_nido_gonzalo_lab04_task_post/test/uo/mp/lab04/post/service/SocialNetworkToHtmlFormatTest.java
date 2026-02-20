package uo.mp.lab04.post.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uo.mp.lab04.post.model.Photo;
import uo.mp.lab04.post.model.TextMessage;

/**
 * SocialNetwork::toHtmlFormat()
 * Scenarios:
 * - Empty network
 * - Network with one TextMessage
 * - Network with one Photo
 * - Network with mixed posts
 */
public class SocialNetworkToHtmlFormatTest {

	private SocialNetwork sn;

	@BeforeEach
	public void setUp() {
		sn = new SocialNetwork();
	}

	/**
	 * GIVEN: Empty network
	 * WHEN: toHtmlFormat()
	 * THEN: Returns empty list
	 */
	@Test
	public void testEmpty() {
		List<String> html = sn.toHtmlFormat();
		assertEquals(0, html.size());
	}

	/**
	 * GIVEN: Network with 1 text message
	 * WHEN: toHtmlFormat()
	 * THEN: Returns list with 1 correct HTML string
	 * Note: Follows Sample Output format <p> message </p>
	 */
	@Test
	public void testOneTextMessage() {
		sn.addPost(new TextMessage("user", "Hello"));
		List<String> html = sn.toHtmlFormat();
		
		assertEquals(1, html.size());
		assertEquals("<p>Hello</p>", html.get(0)); 
	}

	/**
	 * GIVEN: Network with 1 photo
	 * WHEN: toHtmlFormat()
	 * THEN: Returns list with 1 correct HTML string
	 */
	@Test
	public void testOnePhoto() {
		sn.addPost(new Photo("user", "pic.jpg", "Sunset"));
		List<String> html = sn.toHtmlFormat();
		
		assertEquals(1, html.size());
		assertEquals("<img src=pic.jpg> Sunset </img>", html.get(0));
	}

	/**
	 * GIVEN: Mixed posts
	 * WHEN: toHtmlFormat()
	 * THEN: Returns list with all formatted strings in order
	 */
	@Test
	public void testMixed() {
		sn.addPost(new TextMessage("user1", "Text"));
		sn.addPost(new Photo("user2", "img.png", "Caption"));
		
		List<String> html = sn.toHtmlFormat();
		
		assertEquals(2, html.size());
		assertEquals("<p>Text</p>", html.get(0));
		assertEquals("<img src=img.png> Caption </img>", html.get(1));
	}
	
	/**
	 * GIVEN: A null post
	 * WHEN: addPost is called
	 * THEN: Throws IllegalArgumentException
	 */
	@Test
	public void testAddNullPostThrowsException() {
	    assertThrows(IllegalArgumentException.class, () -> sn.addPost(null));
	}
}