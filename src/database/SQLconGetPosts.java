package database;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import post.PostFeed;
import post.UserPost;
import users.UserBean;

public class SQLconGetPosts {

	static Connection conn = null;
	static PreparedStatement stmt = null;
	static ResultSet rs = null;

	public static boolean connectSQLGetPost() {

		try {
			
			// driver setup
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			// handle the error
			System.out.println("Exception Driver: " + ex);
			return false;
		}

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/userposts?serverTimezone=UTC",
					DatabaseLogin.getuName(), DatabaseLogin.getuPass());
			return true;

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			return false;
		}

	}
	
	ArrayList<UserPost> posts = new ArrayList<UserPost>();
	
	private void printList () {
		for(int i = 0; i<stateSQLGetPosts().size(); i++) {
						System.out.println((i+1)+". "+ stateSQLGetPosts().get(i));
						System.out.print(" ");
				}
	}
	

	public static ArrayList<PostFeed> stateSQLGetPosts() {
		ArrayList<PostFeed> posts = new ArrayList<PostFeed>();
		
		// test a query
		try {
			String requestQuery = "SELECT * FROM posts";

			stmt = conn.prepareStatement(requestQuery);
			
			

			rs = stmt.executeQuery(); //exectueUpdate
			// ResultSet return
			while (rs.next()) {
			String postString = rs.getString(1);
			String tagString = rs.getString(2);
					
			PostFeed post = new PostFeed();
			post.setPostStr(postString);
			post.setTagStr(tagString);
			posts.add(post);
			
				
				
			}
			
			conn.endRequest();
			conn.close();
			
			return posts;
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		}
			return null;
			

		}
		
		public static void closeSQL() throws SQLException {
			conn.endRequest();
			conn.close();

		
		
		
		
		
		
		
		
	}

}