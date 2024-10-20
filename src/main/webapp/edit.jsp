<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@page import="org.hibernate.Session" %>
<%@page import="com.helper.FactoryProvider" %>
<%@page import="java.util.List" %>
<%@page import="org.hibernate.Query" %>
<%@page import="com.entity.Note" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <%@include file="all_js_css.jsp" %>
</head>
<body>
<div class = "container">
  	<%@include file="navbar.jsp" %>
  	
  	<h1>Edit your note</h1>
  	<br>
  	<%
  		int noteId=Integer.parseInt(request.getParameter("note_id"));
  		Session s=FactoryProvider.getSessionFactory().openSession();
  		Note note = (Note) s.get(Note.class, noteId);
  	%>
  	 	<form action="UpdateServlet" method="post">
  <input value="<%= note.getID() %>" name="noteId" type="hidden" />
  
  <div class="form-group mb-3">
    <label for="Tile">Note Title</label>
    <input required
    	name="title"
    	type="text"
    	 class="form-control" 
     	id="Title"
      aria-describedby="emailHelp"
      placeholder="enter here"
      value="<%= note.getTitle()%>">
   
  </div>
  <div class="form-group">
    <label for="content">Note Content</label>
    <textarea name="content" required id="content" class="form-control" style="height:300px"><%=note.getContent()%></textarea>
  </div>
  <label for="eveDate" class="col-sm-1 col-form-label">Event Date</label>
  <div class="col-sm-3">
    <input type="Date" name="eveDate" placeholder="" class="form-control"  required min="<%= java.time.LocalDate.now()%>" value="<%=note.getEventDate()%>">
  </div>
<div class="col-sm-2"></div>
  <label for="eveTime" class="col-sm-1 col-form-label">Event Time</label>
  <div class="col-sm-3">
    <input type="Time" name="eveTime" placeholder="" class="form-control" required value="<%=note.getTime()%>">
  </div>
  <div class="container text-center">
  <button type="submit" class="btn btn-success">Save your note</button>
  </div>
  
</form>
  	</div>
    
</body>
</html>