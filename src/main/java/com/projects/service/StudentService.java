package com.projects.service;

import java.util.Locale;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projects.entity.Student;
import com.projects.repository.IStudentRepository;

@Service
public class StudentService implements IStudentService {
	@Autowired
	private IStudentRepository studentRepository;

	@Override
	public Page<Student> getAllStudents(Pageable page) {

		return studentRepository.findAll(page);
	}

	@Override
	public String addStudent(Student student) {

		return "Student With " + studentRepository.save(student).getId() + " Saved";
	}

	@Override
	public Student getStudent(Integer id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public String editStudent(Student student) {
		return "Student With " + studentRepository.save(student).getId() + " Edited";
	}

	@Override
	public String deletetStudent(Integer id) {
		studentRepository.deleteById(id);
		return "Record deleted Having Id " + id;

	}

	public Set<String> getCountries() {
		Locale[] country = Locale.getAvailableLocales();
		Set<String> countries = new TreeSet<String>();
		for (Locale l : country)
			countries.add(l.getDisplayCountry());
		return countries;
	}

	public Set<String> getHouseColor() {
		return Set.of("Red", "Black", "Green", "Yellow");
	}
}
