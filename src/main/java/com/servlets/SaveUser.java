package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.DAO.UserDAO;
import com.entity.User;
import com.helper.FactoryProvider;

public class SaveUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SaveUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String email = request.getParameter("email");
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String pass = request.getParameter("pass");
			User u = new User(email, fname, lname, pass);
			UserDAO ud = new UserDAO();
			if(ud.saveUser(u))	
				response.sendRedirect("index.jsp");
			else
				response.sendRedirect("Register.jsp");
		} 
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
