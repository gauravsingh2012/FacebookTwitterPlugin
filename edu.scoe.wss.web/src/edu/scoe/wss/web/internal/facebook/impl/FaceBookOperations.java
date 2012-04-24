package edu.scoe.wss.web.internal.facebook.impl;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.Parameter;
import com.restfb.types.FacebookType;
import com.restfb.types.Post;
import com.restfb.types.User;

public class FaceBookOperations {
	
	
	private String singleToken = ""; //$NON-NLS-1$
	private DefaultFacebookClient facebookClient;
	
	
	
	public FaceBookOperations() {
		this.facebookClient = new DefaultFacebookClient(
				singleToken);
	}
	
	public Connection<Post> getFeeds(){
		Connection<Post> myFeed = facebookClient.fetchConnection(
				"me/feed", Post.class); //$NON-NLS-1$
		
		return myFeed;
	}
	
	public Connection<Post> getFeeds1(){
		 Connection<Post> myFeedPage2 = facebookClient.fetchConnectionPage(getFeeds().getNextPageUrl(), Post.class);
		 return myFeedPage2;
		
	}
	
	public Connection<User> getUsers(){
		Connection<User> myFriends = facebookClient.fetchConnection(
				"me/friends", User.class); //$NON-NLS-1$
		return myFriends;
	}
	
	public User getMe(){
		User user = facebookClient.fetchObject("me", User.class); //$NON-NLS-1$
		return user;
	}
	public FacebookType getmessage(String text){
		FacebookType publishMessageResponse = facebookClient.publish("me/feed", FacebookType.class,Parameter.with("message", text)); //$NON-NLS-1$ //$NON-NLS-2$
		return publishMessageResponse;
	}
	
	public String login(String text){
		this.facebookClient = new DefaultFacebookClient(text);
		return text;
	}
}
