package com.projects.service;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.projects.entity.Student;

public interface IStudentService {
	public Page<Student> getAllStudents(Pageable page);

	public String addStudent(Student student);

	public Set<String> getCountries();

	public Set<String> getHouseColor();

	public Student getStudent(Integer id);

	public String editStudent(Student student);
	
	public String deletetStudent(Integer id);

}
