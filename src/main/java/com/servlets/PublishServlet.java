package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.SharedNotesDAO;


public class PublishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PublishServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int noteID = Integer.parseInt(request.getParameter("note_id").trim());
		SharedNotesDAO sd = new SharedNotesDAO();
		sd.shareNote(noteID);
		response.sendRedirect("sharedNotes.jsp");
	}

	

}
