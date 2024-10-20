<%@include file="header.jsp" %>
<!doctype html>
<html lang="en">
  <head>
    
    <title>NOTE TAKER : HOME</title>
    
    <%@include file="all_js_css.jsp" %>
    <link rel="stylesheet" href="css/home.css">
  </head>
  <body>

  <div class="container">
  <%@include file="navbar.jsp" %>
    <br>
    <a href="userPanel.jsp"><h1>USER PANEL</h1></a>
    <div class="user-panel">
        <div class="panel-square">
            <a href="AddNotes.jsp"><img src="icons/add-note.svg"></a><br>
            <a href="AddNotes.jsp">ADD NOTES</a>
        </div>
        <div class="panel-square">
            <a href="draw.jsp"><img src="icons/draw.svg"><br></a>
            <a href="draw.jsp">DRAW</a>
        </div>
        <div class="panel-square">
            <a href="publishNote.jsp"><img src="icons/publish.svg"><br></a>
            <a href="publishNote.jsp">PUBLISH NOTE TO ALL</a>
        </div>
        <div class="panel-square">
            <a href="all_notes.jsp"><img src="icons/note.svg"><br></a>
            <a href="all_notes.jsp">SEE ALL NOTES</a>
        </div>
        <div class="panel-square">
            <a href="calendar.jsp"><img src="icons/calendar.svg" ><br></a>
            <a href="calendar.jsp">CALENDAR</a>
        </div>
        <div class="panel-square">
            <a href="showTrash.jsp"><img src="icons/trash.svg" ><br></a>
            <a href="showTrash.jsp">TRASH</a>
        </div>
    </div>
</div>
  	
  </body>
</html>