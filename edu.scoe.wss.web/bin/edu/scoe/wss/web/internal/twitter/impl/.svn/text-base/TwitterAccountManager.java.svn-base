package edu.scoe.wss.web.internal.twitter.impl;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterAccountManager {

	private ConfigurationBuilder cb = new ConfigurationBuilder();

	private Twitter twitter;

	private TwitterFactory twitterFactory;
	
	private AccessToken aToken;
	
	private RequestToken rToken;
	
	private static final String consumerKey = "zS8MJrjVhRxFNc4uHaGA"; //$NON-NLS-1$
	private static final String consumerSecret = "MMzirz5zvo23I1wWadufl8DIQcQ4Zv9eZqMMVq4Ar0"; //$NON-NLS-1$
	
	
	
	public TwitterAccountManager() {
		cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret);
		this.twitterFactory = new TwitterFactory(cb.build());
		this.twitter = twitterFactory.getInstance();
	}

	public Twitter getTwitter() {
		return twitter;
	}
	
	public RequestToken getRequestToken() throws TwitterException{
		if(rToken == null){
			rToken = getTwitter().getOAuthRequestToken();
		}
		return rToken;
	}
	
	public AccessToken getAccessToken(){
		return aToken;
	}
	
	public String getAuthorizationURL() throws TwitterException{
		return getRequestToken().getAuthenticationURL();
	}

	public void setupPIN(String pin) throws TwitterException {
		aToken = getTwitter().getOAuthAccessToken(pin);
	}
	
}
