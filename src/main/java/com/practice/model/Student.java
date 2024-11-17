package com.practice.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Student {
	
	private int id;
	@Id
	private int rollno;

	private String name;

	private String address;

	private String mobileNo;

	private String gender;

	private double marks;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int rollno, String name, String address, String mobileNo, String gender, double marks) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
		this.gender = gender;
		this.marks = marks;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

}
