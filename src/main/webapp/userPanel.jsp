<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
 <%@include file="all_js_css.jsp" %>
 <%@page import="com.DAO.UserDAO" %>
 <%@page import="com.entity.User" %>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/userPanel.css">
</head>
<%

String email = (String) session.getAttribute("email");
UserDAO ud = new UserDAO();
User u = ud.getUser(email);

%>
<body>
<div class="container">
  <%@include file="navbar.jsp" %>
  <div class="containner">
  <br><br><br><br><br>
		<h1>Edit Profile</h1>
		
		<form action="updateUser.jsp" method="post">
			
			<input type="text" id="first_name" name="first_name" value="<%out.print(u.getFname());%>" required><br>
			
			<input type="text" id="last_name" name="last_name" value="<%out.print(u.getLname());%>" required><br>
			
			<input type="email" id="email" name="email" value="<%out.print(u.getEmail());%>" required><br>
			
			<input type="text" name="otp">
			<input type="submit" value="Update">
			<input type="reset" value="Reset">
		</form>
	<br><br><br><br><br><br><br><br>
	</div>
</div>
</body>
</html>
