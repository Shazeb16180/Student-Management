package com.projects.entity;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class StudentModel {
	private Integer id;
	private String studentName;
	private String studentClass;
	private String studentGrade;
	private LocalDate joiningDate;
	private Long fees;
	private String country;
	private String colorHouse;
	private MultipartFile resumeLocation;


}
