package uo.mp.lab04.post.ui;

import uo.mp.lab04.post.model.Photo;
import uo.mp.lab04.post.model.Post;
import uo.mp.lab04.post.model.TextMessage;
import uo.mp.lab04.post.service.SocialNetwork;

import java.util.List;

public class NetworkApp {

    

    public void simulateClient() {
    	SocialNetwork network = new SocialNetwork();
    	
    	
    	//Add posts
    	TextMessage id1TM1 = new TextMessage("user1", "Hello world");
    	TextMessage id1TM2 = new TextMessage("user1", "Bye world");
    	
    	TextMessage id2TM1 = new TextMessage("user2", "Hello Java");
    	TextMessage id2TM2 = new TextMessage("user2", "Bye Java");
    	
    	Photo id3P1 = new Photo("user3", "photo1", "This is photo1");
    	Photo id3P2 = new Photo("user3", "photo2", "This is photo2");
    	
    	Photo id4P1 = new Photo("user4", "photo3", "This is photo3");
    	Photo id4P2 = new Photo("user4", "photo4", "This is photo4");
    	
    	network.addPost(id1TM1);
    	network.addPost(id1TM2);
    	network.addPost(id2TM1);
    	network.addPost(id2TM2);
    	network.addPost(id3P1);
    	network.addPost(id3P2);
    	network.addPost(id4P1);
    	network.addPost(id4P2);
    	
    	//network.listAllPosts(System.out);
    	
    	System.out.println("---HTML FORMAT---");
    	
    	for(String line : network.toHtmlFormat()) {
    		System.out.println(line);
    	}
    	
    	
    	System.out.println();
    	
    	System.out.println("ALL POSTS BY user1");
    	
    	System.out.println();
    	
    	List<Post> user1Posts = network.findPostsByUser("user1");
    	
    	for(Post post : user1Posts) {
    		post.print(System.out);
    	}
    	
    }

}
