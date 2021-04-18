<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="users.UserBean"%>  
    <%@page import="post.PostFeed"%>  
<%@page import = "java.util.ArrayList" %>

  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Feed</title>
<jsp:include page="bootstrapInclude.jsp"></jsp:include>
</head>
<body>


<div class="row" id="postDiv">

<%
  
  // Check to see if the session has a user bean.
  if(session.getAttribute("user") == null){
	
	// if there is not one, goto the logout servlet
	RequestDispatcher rd = request.getRequestDispatcher("Logout");
	rd.forward(request, response);
	
	
  }
	  
	
 // Get The feed via feed-servlet
 // Print feed
  ArrayList <PostFeed> printFeed = (ArrayList <PostFeed>)request.getAttribute("feed");
	if(printFeed != null) {
		
		for(int i = 0; i<printFeed.size(); i++) {
						out.println(
									"<div class=\"card-body\"><div class=\"card shadow-sm\"> " +
											printFeed.get(i).getPostStr()+" "+ printFeed.get(i).getTagStr()+  "</div> </div>");
									out.print(" ");
		}
	}

%>


<div class="row">

<!-- Go back to  success-page  -->
<form action="<%= request.getContextPath() %>/PostController" method="post" > 
   	<input type="submit" name="goBackBtn" class="w-20 btn btn-lg btn-primary" value="Go back"/>  
</form>

</div>

</div>

 

</body>
</html>