package com.entities;

public class student {
	
	private int id;
	private String name;
	private String dob;
	private String Qualification;
	private String Address;
	private String email;
	
	
	public student(String name, String dob, String qualification, String address, String email) {
		this.name = name;
		this.dob = dob;
		Qualification = qualification;
		Address = address;
		this.email = email;
	}


	public student() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getQualification() {
		return Qualification;
	}


	public void setQualification(String qualification) {
		Qualification = qualification;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", dob=" + dob + ", Qualification=" + Qualification
				+ ", Address=" + Address + ", email=" + email + "]";
	}
	
	
	
	
	

}
