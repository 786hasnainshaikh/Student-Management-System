package com.serviceLayer;

import java.util.List;

import com.DAO.DAO;
import com.entities.student;

public class service {
    
	
	// recieving student object from servlet and sending to dao layer
	public static boolean addStudent(student stu) {

//      sending student object from service to dao layer
		boolean addStudent = DAO.addStudent(stu);
		return addStudent;
	}

	
	// Getting List students from dao 
    public static List<student> getAllStudent(){
    	List<student> allStudent = DAO.getAllStudent();
    	return allStudent;
    }

    
   // Get student by Id
    public static student getStudentById(int id) {
    	
    	student studentById = DAO.getStudentById(id);
    	return studentById;
    }

    public static boolean updateStudent(int id , student stu) {
    	// sending id and student object to dao layer  and fetching boolean true means data updated
    	boolean updateStudent = DAO.updateStudent(id, stu);
    	
    	return updateStudent;
    }
    
    public static boolean deleteStudent(int id) {
    	boolean deleteStudent = DAO.deleteStudent(id);
    	return deleteStudent;
    }

  

}
