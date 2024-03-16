package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.serviceLayer.*;

@WebServlet("/delete")
public class deleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// fetch id from url  set in index.jsp in delete button using 
		String value=req.getParameter("id");
		int id=Integer.parseInt(value);
		System.out.println(id);
		
		// send this id service then dao layer and sent to database to delete particular student which boolean
		boolean result=service.deleteStudent(id);
		// created session object 
		HttpSession session=req.getSession();
		
		
		if (result == true) {
			// set value in session object which we get in index.jsp
			session.setAttribute("delete_successfull", "Student deleted........");
			resp.sendRedirect("index.jsp");
		}
		else {
			// set value in session object which we get in index.jsp
			session.setAttribute("delete_error", "Cant deleted!!!!!");
			resp.sendRedirect("index.jsp");
		}
		
		
	}

	
	
}
