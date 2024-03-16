package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.serviceLayer.*;
import com.entities.student;

@WebServlet("/updateData")
public class editServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
// fetching form data from editstudent.jsp
		
		String input = req.getParameter("id");
		  input = input.trim(); // Remove leading and trailing whitespace
// converting from String to int
		  int id = Integer.parseInt(input);
		  String name= req.getParameter("name");
		  String dob= req.getParameter("dob");
		  String qualification= req.getParameter("qua");
		  String address= req.getParameter("address");
		  String email = req.getParameter("email");
		  
		  
// create and store values in student object
		  student obj=new student(name, dob, qualification, address, email);
		 
	      
//sending id and student object to service layer and fetching boolean true means data updated
		  boolean updateStudent = service.updateStudent(id, obj);
		  
//creating session object
		 HttpSession session = req.getSession();
		  if (updateStudent == true) {
//set message value in session object method which we get in index.jsp
		  	  session.setAttribute("update_success", "Data Updated successfully.......");
//redirecting to add index.jsp page
			  resp.sendRedirect("index.jsp");
			  
			  
		  }
		  else {
//set message value in session object method which we get in index.jsp
			  session.setAttribute("update_error", "Something error.......");
// redirecting to add editStudent.jsp page which we get in addStudent.jsp
			 	  resp.sendRedirect("index.jsp");
			  
		}
		  
		 
	}
	
	

}
