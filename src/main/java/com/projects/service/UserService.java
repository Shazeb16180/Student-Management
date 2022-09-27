package com.projects.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projects.entity.User;
import com.projects.repository.IUserRepository;

@Service
public class UserService implements IUserService{
	@Autowired
	private IUserRepository userRepository;

	@Override
	//@Transactional
	public String addUser(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode( user.getPassword()));
		System.out.println(user.getRole());
		return "User Registered With Id " +userRepository.save(user).getId();
	}

}
