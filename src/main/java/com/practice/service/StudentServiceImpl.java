package com.practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.dao.StudentRepository;
import com.practice.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repo;

	@Override
	public Student saveStudent(Student student) {

		Student stu = repo.save(student);

		return stu;
	}

	@Override
	public Student getStudent(int rollno) {

		Optional<Student> optional = repo.findById(rollno);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			return new Student();
		}

	}

	@Override
	public List<Student> getAllStudent() {

		List<Student> stuList = repo.findAll();

		return stuList;
	}

	@Override
	public boolean deleteStudent(int rollno) {

		if (repo.existsById(rollno)) {
			repo.deleteById(rollno);
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean updateStudent(Student student) {

		if (repo.existsById(student.getRollno())) {
			repo.save(student);
			return true;
		} else {
			return false;
		}
	}

}
