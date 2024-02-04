package com.practice.service;

import java.util.List;

import com.practice.model.Student;

public interface StudentService {

	Student saveStudent(Student student);

	Student getStudent(int rollno);

	List<Student> getAllStudent();

	boolean deleteStudent(int rollno);

	boolean updateStudent(Student student);

}
