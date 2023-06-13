package com.tech.kj.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Table(name="STUDENT")
@Entity
@SQLDelete(sql = "UPDATE STUDENT SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Student extends User{
	private int age;
	private  int enrollClass;
	private String secton;
	private  LocalDate dob;
	private  String schoolName;
	private String fathersName;
	private String mothersName;
	private String motherOccupation;
	private String fatherOccupation;
	private Boolean deleted = Boolean.FALSE;
	
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
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
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
	@Override
	public String toString() {
		return "Student [age=" + age + ", enrollClass=" + enrollClass + ", secton=" + secton + ", dob=" + dob
				+ ", schoolName=" + schoolName + ", fathersName=" + fathersName + ", mothersName=" + mothersName
				+ ", motherOccupation=" + motherOccupation + ", fatherOccupation=" + fatherOccupation + ", getId()="
				+ getId() + ", getName()=" + getName() + ", getEmail()=" + getEmail() + ", getUserName()="
				+ getUserName() + ", getPassword()=" + getPassword() + ", getRoles()=" + getRoles() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
