package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entities.student;
import com.getConnection.getConn;

public class DAO {

	public static Connection con = getConn.getConnection();

	public static boolean addStudent(student stu) {

		try {
			String addQuery = "insert into studentdetails(fullname, DOB, qualification, address, email) values (?,?,?,?,?) ";
			PreparedStatement pstm = con.prepareStatement(addQuery);
			// setting values into database
			pstm.setString(1, stu.getName());
			pstm.setString(2, stu.getDob());
			pstm.setString(3, stu.getQualification());
			pstm.setString(4, stu.getAddress());
			pstm.setString(5, stu.getEmail());

			int result = pstm.executeUpdate();

			if (result == 1) {
				return true;

			} else {
				return false;

			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}
	
	
    // getting All students details from database store and return list
	public static List<student> getAllStudent() {

		ArrayList<student> arrayList = new ArrayList<>();
		student stu=null;

		try {
			String query = "select * from studentdetails";
			PreparedStatement pstm = con.prepareStatement(query);
			ResultSet resultSet = pstm.executeQuery();

			while (resultSet.next()) {
				// creating new student object in every iteration
				stu = new student();
				
				// setting values in student object in every iteration
				stu.setId(resultSet.getInt(1));
				stu.setName(resultSet.getString(2));
				stu.setDob(resultSet.getString(3));
				stu.setQualification(resultSet.getString(4));
				stu.setAddress(resultSet.getString(5));
				stu.setEmail(resultSet.getString(6));

				// adding that object in arrayList in every iteration
				arrayList.add(stu);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayList;
	}
    
	
	public static student getStudentById(int id) {
		student student=null;
		
		try {
			String query="select * from studentdetails where id=?";
			PreparedStatement pstm= con.prepareStatement(query);
			// Setting Argument value
			pstm.setInt(1, id);
			// fetching object from database
			ResultSet resultSet = pstm.executeQuery();
			while (resultSet.next()) {
				// creating new student object
				student =new student();
				
				// setting values in student object fetched from database
				student.setId(resultSet.getInt(1));   
				student.setName(resultSet.getString(2));
				student.setDob(resultSet.getString(3));
				student.setQualification(resultSet.getString(4));
				student.setAddress(resultSet.getString(5));
				student.setEmail(resultSet.getString(6));
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return student;
	}

	
    public static boolean updateStudent(int id, student stu) {
    	 try {
			
    		String query="update studentdetails set fullname=?, DOB=?, qualification=?, address=?,  email=? where id=?";
		    // create statement
    		PreparedStatement pstm=	con.prepareStatement(query);
		    
		    // setting values in query
		    pstm.setString(1, stu.getName());
		    pstm.setString(2, stu.getDob());
		    pstm.setString(3, stu.getQualification());
		    pstm.setString(4, stu.getAddress());
		    pstm.setString(5, stu.getEmail());
		    pstm.setInt(6, id);
		    
		    // execute the query
		    int executeUpdate = pstm.executeUpdate();
		    
		    if (executeUpdate ==1) {
		    	return true;
		    }
		    else {
		    	return false;
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    	return false;
    }	 
    
    public static boolean deleteStudent(int id) {
    	try {
			String query="delete from studentdetails where id =?";
			PreparedStatement pstm=con.prepareStatement(query);
			// setting values for arguments
			pstm.setInt(1, id);
			// executing query
			int delete = pstm.executeUpdate();
			
			if (delete == 1) {
				return true;
			}else {
				return false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return false;
    }
    
}
