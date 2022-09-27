package com.projects.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projects.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	public User findByUsername(String userName);

}
