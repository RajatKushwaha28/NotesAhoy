<%@ page import="javax.servlet.http.*" %>
<%
    HttpSession sessn = request.getSession();
    sessn.invalidate(); // Invalidate the session
    response.sendRedirect("login.jsp");
%>
