<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
// check if there is a session with an user
if (session.getAttribute("user") != null) {
	// there is one goto the login servlet
	RequestDispatcher rd = request.getRequestDispatcher("Login");
	rd.forward(request, response);// this lands on the GET in the servlet
}
%>


<!DOCTYPE html>
<html>

<jsp:include page="bootstrapInclude.jsp"></jsp:include>

</head>
<body class="text-center">

	// Login-form and send to Login-servlet.
<main class="form-signin">
  <form action="<%=request.getContextPath()%>/Login" method="post">
    <h1 class="h3 mb-3 fw-normal">Please sign in</h1>

    <div class="form-floating">
      <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="email">
      <label for="floatingInput">Email address</label>
    </div>
    <div class="form-floating">
      <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
      <label for="floatingPassword">Password</label>
    </div>

    <div class="checkbox mb-3">
      
    </div>
    <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted">&copy; 2017–2021</p>
  </form>
</main>
	
	
</body>

</html>   


