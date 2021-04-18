package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import post.UserPost;


public class SQLconPosts {

	static Connection connPost = null;
	static PreparedStatement stmtPost = null;
	static ResultSet rsPost = null;
	static int rsPost2;

	public static boolean connectSQLPost() {
			

		try {
			
			// driver setup
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			// handle the error
			System.out.println("Exception Driver: " + ex);
			return false;
		}

		try {
			connPost = DriverManager.getConnection("jdbc:mysql://localhost:3306/userposts?serverTimezone=UTC",
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
	
	

	public static boolean stateSQLPost(UserPost bean) {
		
		// test a query
		try {
			
			//String requestQuery = "SELECT * FROM posts";
			String requestQuery = "INSERT INTO `posts` (Post, Tag) VALUES (?, ?);";
			

			stmtPost = connPost.prepareStatement(requestQuery);
			
			
			stmtPost.setString(1, bean.getPostStr());
			stmtPost.setString(2, bean.getPostTag());

			
			//rsPost = stmtPost.executeQuery(); //exectueUpdate
			stmtPost.executeUpdate();
			// ResultSet return
			
			
			
			/*while (rsPost.next()) {
				//String test = rsPost.getString(2);
				//System.out.println(rsPost.getString(1) + "  " + rsPost.getString(2) + test);
				//System.out.println(bean.getPostStr());

				//bean.setName(rsPost.getString("fullname"));
				return true;

			}*/
			connPost.endRequest();
			connPost.close();
			
		} 
		
		
		
		
		
		
		
		catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		}
		return false;

		}
		
		public static void closeSQL() throws SQLException {
			connPost.endRequest();
			connPost.close();



		
	}

}