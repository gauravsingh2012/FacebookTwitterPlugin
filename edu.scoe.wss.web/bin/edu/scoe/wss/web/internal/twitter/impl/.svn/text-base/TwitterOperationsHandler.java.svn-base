package edu.scoe.wss.web.internal.twitter.impl;
import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import edu.scoe.wss.web.internal.twitter.impl.TwitterAccountManager;


public class TwitterOperationsHandler {

	private TwitterAccountManager manager;
	private Twitter twitter;

	public TwitterOperationsHandler(TwitterAccountManager manager) {
		this.manager = manager;
		this.twitter = this.manager.getTwitter();
	}
	
	public List<Status> getTimeLines() throws TwitterException{
		return this.twitter.getFriendsTimeline();
	}
}
