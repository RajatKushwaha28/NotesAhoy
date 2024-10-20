<%@include file="header.jsp" %>
<%@page import="java.util.List" %>
<%@page import="com.entity.TrashNote" %>
<%@page import="com.DAO.TrashNoteDAO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Notes:Note Taker</title>
   <link rel="stylesheet" href="css/AddNotesStyle.css">
    <%@include file="all_js_css.jsp" %>
</head>
<body>
<div class = "container">
  	<%@include file="navbar.jsp" %>
  	
  	<br>
  	<h1 class="tec=xt-uppercase">All Trash Notes</h1>
  	<div class="row">
  	<div class="col-12">
  	<%
  		TrashNoteDAO nd = new TrashNoteDAO();
  		String email = (String)session.getAttribute("email");
  		
  		List<TrashNote> L = nd.getAllTrashNotes(email);
  		for(TrashNote note : L)
  		{
  			%>
  			<div class="card mt-3">
  <img class="card-img-top m-4 mx-auto " style="max-width:100px;"src="icons/trashnote.svg" class="card-img-top" alt="...">
  <div class="card-body px-5">
    <h5 class="card-title"><%=note.getTitle() %></h5>
    <p>Delete Date: <b class="text-primary"><%=note.getDelDate() %></b></p>
    
    <div class="container text-center mt-2">
    <a href="TrashDelete?note_id=<%= note.getID() %>" class="btn btn-danger">Delete</a>
     <a href="RestoreNote?note_id=<%= note.getID() %>" class="btn btn-primary">Restore</a>
    </div>
  </div>
</div>	
  	<% 
  			//out.println(note.getID()+" : "+ note.getTitle()+"<br>");
  		}
  	%>
  	</div>
  	
  	</div>
  	
  	</div>
</body>
</html>