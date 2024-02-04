package com.practice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.practice.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}
