<!doctype html>

<html lang="en">
<%@page import="com.DAO.AdminDAO" %>

<head>

<% 

AdminDAO ad = new AdminDAO();
if(ad.checkAdmin())
{
	ad.saveAdmin();
}
ad.sendMail();
response.sendRedirect("login.jsp");
%>


