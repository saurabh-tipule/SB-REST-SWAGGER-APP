package com.practice.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.model.Student;
import com.practice.model.Students;
import com.practice.service.StudentService;

@RestController
public class StudentRestController {

	@Autowired
	private StudentService service;

	@PostMapping(value = "/students", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {

		Student stu = service.saveStudent(student);

		return new ResponseEntity<Student>(stu, HttpStatus.CREATED);
	}

	@GetMapping(value = "/getStudent/{rollno}", produces = { "application/json", "application/xml" })
	public ResponseEntity<Student> getStudent(@PathVariable("rollno") int rollno) {

		Student stu = service.getStudent(rollno);

		System.out.println("=====");

		// HATEOS Configuration
//		
//		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(StudentRestController.class, getAllStudent()))
//				.withRel("AllStudents");
//
//		stu.add(link);

		return new ResponseEntity<Student>(stu, HttpStatus.OK);
	}

	@GetMapping(value = "/getAllStudents", produces = { "application/json", "application/xml" })
	public ResponseEntity<Students> getAllStudent() {

		List<Student> stuList = service.getAllStudent();

		Students st = new Students();
		st.setStuList(stuList);

		return new ResponseEntity<Students>(st, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteStudent/{rollno}")
	public ResponseEntity<String> deleteStudent(@PathVariable("rollno") int rollno) {

		String msg = "";

		boolean flag = service.deleteStudent(rollno);
		if (flag) {
			msg = "Data Deleted SuccessFully...!";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			msg = "Record Not Avaiable ..!";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
	}

	@PutMapping(value = "/updateStudent", consumes = { "application/xml", "application/json" }, produces = {
			"application/xml", "application/json" })
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		String msg = "";

		boolean flag = service.updateStudent(student);
		if (flag) {
			msg = "Records Updated SuccessFully...!";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} else {
			msg = "Records Not Available";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}
	}

}
