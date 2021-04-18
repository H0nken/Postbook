package post;

import java.util.ArrayList;
import database.SQLconPosts;


public class UserPost {
	
	private String postStr;
	private String postTag;
	
	private ArrayList<String> listOfPost = new ArrayList<String>();
	private ArrayList<String> listOfPosts = new ArrayList<String>();
	private ArrayList<String> listOfTags = new ArrayList<String>();
	
	
	
	public UserPost(String postStr, String postTag) {
		super();
		this.postStr = postStr;
		this.postTag = postTag;
		
	}


	public ArrayList<String> getListOfTags() {
		return listOfTags;
	}


	public void setListOfTags(ArrayList<String> listOfTags) {
		this.listOfTags = listOfTags;
	}
	
	private ArrayList<UserPost> feedList = new ArrayList<UserPost>();
	
	

	public void addPostToFeed(UserPost toFeed) {
		feedList.add(toFeed);
		
	}
	
	public void printFeed(ArrayList<UserPost> listOfPost) {
		for(int i = 0; i<listOfPost.size(); i++) {
						System.out.println((i+1)+". "+ listOfPost.get(i).postStr);
						System.out.print(" ");
				}
	}
	

	public ArrayList<UserPost> getFeedList() {
		return feedList; 
	}
	

	public void setFeedList(ArrayList<UserPost> feedList) {
		this.feedList = feedList;
	}

	
	//Add-methods
	
	public void addTagsToList(String tag) {
		
		listOfTags.add(tag);
	}
	
	public void addPostsToList(String post) {
		
		listOfPosts.add(post);
	}

	public void addPostToArr(String post) {
		
		listOfPost.add(post);
	}
	
	
	
	
	
	
	
	
	public String getPostTag() {
		return postTag;
	}

	public void setPostTag(String postTag) {
		this.postTag = postTag;
	}
	
	public String getPostStr() {
		return postStr;
	}

	public void setPostStr(String postStr) {
		this.postStr = postStr;
	}
	
	public ArrayList<String> getListOfPost() {
		return listOfPost;
	}

	public ArrayList<String> postFeed() {
		return listOfPost;
	}
	
	public void setListOfPost(ArrayList<String> listOfPost) {

		this.listOfPost = listOfPost;
	}
	
	
	
	public boolean validatePost(UserPost bean)  {
		
		if (SQLconPosts.connectSQLPost()) {
			
			return SQLconPosts.stateSQLPost(bean);
    	}
	
		return false;
	}


	public ArrayList<String> getListOfPosts() {
		return listOfPosts;
	}


	public void setListOfPosts(ArrayList<String> listOfPosts) {
		this.listOfPosts = listOfPosts;
	}  




	
	
	


}
