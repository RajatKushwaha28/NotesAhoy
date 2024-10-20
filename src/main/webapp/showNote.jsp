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
  	<h1 class="tec=xt-uppercase">View Note</h1>
  	<div class="row">
  	<div class="col-12">
  	<%
  		NoteDAO nd = new NoteDAO();
  		int noteID = Integer.parseInt(request.getParameter("note_id"));
  		
  		Note note = nd.getNote(noteID);
  		
  			%>
  			<div class="card mt-3">
  <img class="card-img-top m-4 mx-auto " style="max-width:100px;"src="img/notepad.png" class="card-img-top" alt="...">
  <div class="card-body px-5">
    <h5 class="card-title"><%=note.getTitle() %></h5>
    <p class="card-text"><%=note.getContent() %></p>
    <p>Add Date: <b class="text-primary"><%=note.getAddDate() %></b></p>
    <p>Event Date: <b class="text-primary"><%=note.getEventDate() %></b></p>
    <p>Event Time: <b class="text-primary"><%=note.getTime() %></b></p>
    
    
    <div class="container text-center mt-2">
    <a href="calendar.jsp" class="btn btn-primary">Back</a>
     
    </div>
  </div>
</div>	
  	
  	</div>
  	
  	</div>
  	
  	</div>
</body>
</html>