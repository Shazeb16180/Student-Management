package com.projects.commons;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.projects.entity.User;
import com.projects.repository.IUserRepository;

@Component
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private IUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println(userRepository);
		User user = userRepository.findByUsername(username);
		System.out.println(user);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.getRole().stream().map(role -> new SimpleGrantedAuthority(role))
						.collect(Collectors.toList()));
	}


}
