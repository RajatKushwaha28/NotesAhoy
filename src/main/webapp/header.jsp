<%@page  errorPage="error.html" %>
<%@ page import="javax.servlet.http.*" %>
<%
    HttpSession sessn = request.getSession();
    String emailll = (String) session.getAttribute("email");

    if (emailll == null) {
        response.sendRedirect("index.jsp"); // Redirect to login page if not logged in
    }

    
%>
<html>
<head>
<link rel="icon" type="image/x-icon" href="icons/NotesAhoy.ico">
</head>
</html>