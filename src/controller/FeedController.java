package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.SQLconGetPosts;
import post.PostFeed;
import users.UserBean;

/**
 * Servlet implementation class FeedController
 */
@WebServlet("/FeedController")
public class FeedController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Check if there is an user in session.
		if (request.getSession().getAttribute("user") != null) {		
			UserBean bean = (UserBean) request.getSession().getAttribute("user");
			
		// Check if there is connection and get The feed from database and set feed to ArrayList
		ArrayList<PostFeed> feed = new ArrayList <PostFeed>();
		if (SQLconGetPosts.connectSQLGetPost()) {
			feed =  SQLconGetPosts.stateSQLGetPosts();  }
	
		
		request.setAttribute("feed", feed);

		if (bean.validate(bean)) {
			
			// get the session and the request to go to the success page 
			HttpSession session = request.getSession();
			session.setAttribute("user", bean);
			request.setAttribute("user", bean);

			RequestDispatcher rd = request.getRequestDispatcher("PrintFeed.jsp");
			rd.forward(request, response);
			
		} else {
			// this only happens if the sessionid is removed, manually or because it timed out and you try to go directly to the "success.jsp"
			//  goto logout to clean up
		
			RequestDispatcher rd = request.getRequestDispatcher("Logout");
			rd.forward(request, response);
			
		}
	} else {
		// this should only happen if you try to goto "/Login" manually 
		response.sendRedirect("index.jsp");
	}
	
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


	}
	

}
