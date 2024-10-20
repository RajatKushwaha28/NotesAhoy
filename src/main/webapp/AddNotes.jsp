<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="css/AddNotesStyle.css">
<meta charset="ISO-8859-1">
<title>ADD NOTES</title>
<%@include file="all_js_css.jsp" %>
<%@page import = "com.DAO.NoteDAO"%>
<%@page import = "com.entity.Note"%>
<%@page import = "java.util.Date"%>


</head>
<body>
	<div class = "container">
  		<%@include file="navbar.jsp" %>
  		
  		<h1>ADD NOTE DETAILS</h1>
  		<form action="AddNotes.jsp" method="post">
  		<% String email=(String)session.getAttribute("email");%>
  <div class="mb-3">
    <label for="title" class="form-label">Note Title</label>
    <input type="text" name="email" value="<% out.print(email);%>" hidden>
    <input type="text" name="title" class="form-control" id="title" aria-describedby="emailHelp" placeholder="Enter Title Here" required>
   
  </div>
  <div class="mb-3">
    <label for="content" class="form-label">Note Content</label>
    <textarea id="content" name="content" placeholder="Enter content" class="form-control" style="height:300px;" required></textarea>
  </div>
  <div class="row mb-3">
  <div class="col-sm-1"></div>
  <label for="eveDate" class="col-sm-1 col-form-label">Event Date</label>
  <div class="col-sm-3">
    <input type="Date" name="eveDate" placeholder="" class="form-control"  required min="<%= java.time.LocalDate.now() %>">
  </div>
<div class="col-sm-2"></div>
  <label for="eveTime" class="col-sm-1 col-form-label">Event Time</label>
  <div class="col-sm-3">
    <input type="Time" name="eveTime" placeholder="" class="form-control" required>
  </div>
</div>
  
 
  <div class="container text-center">
  
  <button type="submit" class="btn btn-primary">ADD</button>
  	<textarea id="convert_text" hidden></textarea>
    <button class="btn btn-dark" id="click_to_convert">Voice to Text</button>
  </div>
  
  </form>
  
  	</div>
  	
  	
<script type="text/javascript" src="js/voice.js"></script>
  	
  	<%
	
	String title = (String)request.getParameter("title");
	String content = (String)request.getParameter("content");
	String date = (String)request.getParameter("eveDate");
	String time = (String)request.getParameter("eveTime");
	
	if(title!=null && content!=null)
	{
		Note n = new Note();
		n.setID();
		n.setTitle(title);
		n.setContent(content);
		n.setAddDate(new Date());
		n.setEventDate(date);
		n.setTime(time);
		
		NoteDAO nd = new NoteDAO();
		if(nd.saveNote(n, email))
		{
		
		out.println("<script>alert('Data inserted successfully');</script>");
		}
	}
	%>

</body>
</html>