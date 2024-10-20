package com.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.DAO.NoteDAO;
import com.entity.Note;
import com.helper.FactoryProvider;

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		try {
			
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String date = request.getParameter("eveDate");
			String time = request.getParameter("eveTime");
			int ID = Integer.parseInt(request.getParameter("noteId"));
			NoteDAO nd = new NoteDAO();
			nd.updateNote(title, content, ID, date, time);
			response.sendRedirect("all_notes.jsp");
			
		} 
		catch (Exception e) {
			
		}
	}

}
