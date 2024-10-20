<%@include file="header.jsp" %>
<%@page import="java.util.List" %>
<%@page import="com.entity.Note" %>
<%@page import="com.DAO.NoteDAO" %>
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
  	<h1 class="tec=xt-uppercase">Calendar</h1>
  	<div class="row">
  	<div class="col-12">
  	<%
  		NoteDAO nd = new NoteDAO();
  		String email = (String)session.getAttribute("email");
  		
  		List<Note> L = nd.getNoteDates(email);
  		for(Note note : L)
  		{
  			%>
  			<div class="card mt-3">
  <img class="card-img-top m-4 mx-auto " style="max-width:100px;"src="icons/calendarNote.svg" class="card-img-top" alt="...">
  <div class="card-body px-5">
    <h5 class="card-title"><%=note.getTitle() %></h5>
    <p>Add Date: <b class="text-primary"><%=note.getAddDate() %></b></p>
    <p>Event Date: <b class="text-primary"><%=note.getEventDate() %></b></p>
    <p>Event Time: <b class="text-primary"><%=note.getTime() %></b></p>
    
    
    <div class="container text-center mt-2">
    <a href="showNote.jsp?note_id=<%= note.getID() %>" class="btn btn-primary">View</a>
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