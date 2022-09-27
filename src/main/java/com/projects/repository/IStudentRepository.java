package com.projects.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.projects.entity.Student;


public interface IStudentRepository  extends PagingAndSortingRepository<Student, Integer>{

}
