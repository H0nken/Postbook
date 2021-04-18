package controller;

import java.awt.List;
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
import post.UserPost;
import users.UserBean;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/PostController")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	UserPost postBean = new UserPost("", "");
	//ArrayList<PostFeed> feed = new ArrayList <PostFeed>();
	
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		// Check if there is an user in session.
		if (request.getSession().getAttribute("user") != null && SQLconGetPosts.connectSQLGetPost()) {
			UserBean bean = (UserBean) request.getSession().getAttribute("user");
			
	
			//Save post-parameters 
			String userPostStr = request.getParameter("userPost");
			String postTag = request.getParameter("postTag");
		
			
			//Set post-attributes
			postBean.setPostStr(userPostStr);
			postBean.setPostTag(postTag);
			
			//Send postObject method for DB-connect-validation 
			postBean.validatePost(postBean);	
			
			
			request.setAttribute("postBean", postBean);
			
			// Validate username and password again  
			if (bean.validate(bean)) {
								
				// get the session and the request to go to the success page 
				HttpSession session = request.getSession();
				session.setAttribute("user", bean);
				request.setAttribute("user", bean);

				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
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

	
	}

