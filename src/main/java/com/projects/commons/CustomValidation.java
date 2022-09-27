package com.projects.commons;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.projects.entity.Student;

@Component
public class CustomValidation implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Student.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Student student = (Student) target;
		if (student.getStudentName().isBlank())
			errors.rejectValue("studentName", "student.name.blank");
		if (student.getStudentName().length() < 3)
			errors.rejectValue("studentName", "student.name.length");
		if (student.getJoiningDate() == null)
			errors.rejectValue("joiningDate", "student.date");
		if (student.getStudentClass().isBlank())
			errors.rejectValue("studentClass", "student.class");
		if (!(student.getStudentClass().matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")))
			errors.rejectValue("studentClass", "student.class.invalid");
		if (student.getStudentGrade().isBlank())
			errors.rejectValue("studentGrade", "student.grade");
		if (!(student.getStudentGrade().matches("[A-C][+-]?|D")))
			errors.rejectValue("studentGrade", "student.invalid.grade");
		if (student.getFees() == null)
			errors.rejectValue("fees", "student.fees");
		if (student.getCountry().isBlank())
			errors.rejectValue("country", "student.country");
		System.out.println(student);
		if (student.getColorHouse() == null || student.getColorHouse().isBlank())
			errors.rejectValue("colorHouse", "student.color");
		if(student.getResumeLocation().isBlank())
			errors.rejectValue("resumeLocation", "student.resume");
	}

}
