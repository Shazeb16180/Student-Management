package com.projects.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "name")
	private String studentName;
	@Column(name = "class")
	private String studentClass;
	@Column(name = "grade")
	private String studentGrade;
	@Column(name = "admission_date")
	private LocalDate joiningDate;
	@Column(name = "fees_paid")
	private Long fees;
	@Column(name = "country")
	private String country;
	@Column(name = "house_color")
	private String colorHouse;
	private String resumeLocation;

}
