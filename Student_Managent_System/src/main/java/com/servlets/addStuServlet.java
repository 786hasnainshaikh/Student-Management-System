package com.servlets;
import com.serviceLayer.*;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entities.student;
import com.mysql.cj.Session;



@WebServlet("/addStudent")
public class addStuServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// fetching form data of addStudent.jsp
		  String name= req.getParameter("name");
		  String dob= req.getParameter("dob");
		  String qualification= req.getParameter("qua");
		  String address= req.getParameter("address");
		  String email = req.getParameter("email");
		  
		  
//create and store values in student object
		  student obj=new student(name, dob, qualification, address, email);
//sending student object to service layer it return true if data saved into database	  
		  boolean addStudent = service.addStudent(obj);
		  
		  HttpSession session = req.getSession();
		  if (addStudent == true) {
//set message value in session object method which we get in addStudent.jsp
			  session.setAttribute("success_message", "Data Inserted.......");
			  // redirecting to add student page
			  resp.sendRedirect("addStudent.jsp");
		  }
		  else {
//set message value in session object method which we get in addStudent.jsp
			  session.setAttribute("error_message", "Error.......");
// redirecting to add student page
			  resp.sendRedirect("addStudent.jsp");
		}
		  
		
	}
	
    
	
	
}
