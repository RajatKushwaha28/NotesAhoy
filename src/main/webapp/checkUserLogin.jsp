<%@page  errorPage="error.html" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.DAO.UserDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="icon" type="image/x-icon" href="icons/NotesAhoy.ico">
</head>
<link rel="stylesheet" href="css/CheckLoginStyle.css">

<%

	String email = request.getParameter("email");
	String pass = request.getParameter("password");
	UserDAO ud = new UserDAO();
	if(ud.verifyUser(email, pass)==true)
	{
		session.setAttribute("email", email);
		response.sendRedirect("Home.jsp");
	}
	else
		
%>

<body background="img/img3.jpg" height="100%" width="100%">
	<div class="header">
	<h1><center>Invalid email or password</center></h1>
</div>
	<div class="header1">
	<h2><center>Credentials you entered does not match with our records</center></h2>
	</div>
	<div class="button">
	<button onclick="history.back()">
	Try Again
	</button>
	</div>
	<div class="header2">
	<h2><center>if you are not a member,then sign up here</center></h2>
	</div>
	<div class="button">
	<button>
	<a href="Register.jsp">Sign up</a>
	</button>
	</div>
	
</body>
</html>