<%@page import="controller.PostController"%>
<%@page import="users.UserBean"%>  
<%@page import="post.UserPost"%>  
<%@page import="post.UserPost"%> 
    
<%@page import="post.PostFeed"%>  
<%@page import = "java.util.ArrayList" %>



<!DOCTYPE html>
<html>

<jsp:include page="bootstrapInclude.jsp"></jsp:include>

</head>
<body>  

<div class="container">




<div class="row">
<%
  
  // Check to see if the session has a user bean.
  if(session.getAttribute("user") == null){
	
	// if there is not one, goto the logout servlet
	RequestDispatcher rd = request.getRequestDispatcher("Logout");
	rd.forward(request, response);
	
	
  } else {
	  
	  
	// if there is a session, then all is well  
	
	// get the bean to unpack the user data
	UserBean bean = (UserBean) request.getAttribute("user");
	
		
	  out.print("<h3>Welcome to Postbook, " + bean.getName() + " !</h3>"); 
	
  }
%>

</div>

<div class="row" id="postDiv">

</div>

<!-- Post-form and send post to Post-servlet on "Post-input"  -->
<div class="row">
<form action="<%=request.getContextPath()%>/PostController" id="userform" method="post">
  <textarea name="userPost" form="userform" rows="7" cols="50" placeholder="Write a post"></textarea>
  
  <!-- Tag-form and send post to Post-servlet on "post-input"  -->
 <div class="col">
  <textarea name="postTag" form="userform" rows="1" cols="30" >#</textarea>
  
  <!-- Post-input.  -->
  <div class="col">Make one tag if you want</div>
  <input type="submit" class="w-20 btn btn-lg btn-primary" value="Post">
  </div>
</form>
	</div>
	
<br>

<!-- Goto the Feed-servlet to see Feed..  -->
<div class="row">
<form action="<%= request.getContextPath() %>/FeedController" method="get"> 
   	<input type="submit" class="w-20 btn btn-lg btn-primary" name="feedBtn" value="Feed"/>  
</form>
</div>
<br>

<!-- Goto the logout servlet to logout..  -->
<div class="row">
<form action="<%= request.getContextPath() %>/Logout" method="post"> 
   	<input class="w-20 btn btn-lg btn-primary" type="submit" value="logout"/>  
</form>
</div>
<br>



<br>
      
      
</div>


</body>
</html>