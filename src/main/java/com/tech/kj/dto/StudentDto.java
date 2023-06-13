package com.tech.kj.dto;

import java.time.LocalDate;

public class StudentDto extends UserDto{
	private int age;
	private  int enrollClass;
	private String secton;
	private  LocalDate dob;
	private  String collageName;
	private String fathersName;
	private String mothersName;
	private String motherOccupation;
	private String fatherOccupation;
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getEnrollClass() {
		return enrollClass;
	}
	public void setEnrollClass(int enrollClass) {
		this.enrollClass = enrollClass;
	}
	public String getSecton() {
		return secton;
	}
	public void setSecton(String secton) {
		this.secton = secton;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public String getCollageName() {
		return collageName;
	}
	public void setCollageName(String collageName) {
		this.collageName = collageName;
	}
	public String getFathersName() {
		return fathersName;
	}
	public void setFathersName(String fathersName) {
		this.fathersName = fathersName;
	}
	public String getMothersName() {
		return mothersName;
	}
	public void setMothersName(String mothersName) {
		this.mothersName = mothersName;
	}
	public String getMotherOccupation() {
		return motherOccupation;
	}
	public void setMotherOccupation(String motherOccupation) {
		this.motherOccupation = motherOccupation;
	}
	public String getFatherOccupation() {
		return fatherOccupation;
	}
	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}
	
	
}
