package com.projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.projects.commons.CustomUserDetailsService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class CustomConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private CustomUserDetailsService customUserDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests().antMatchers("/").authenticated()
	 * .antMatchers("/add", "/edit", "/download").hasAnyAuthority("USER")
	 * .antMatchers("/delete").hasAnyAuthority("ADMIN") .and() .formLogin(); }
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable(). authorizeRequests().antMatchers("/showLogin","/register").permitAll().antMatchers("/").authenticated()
		.antMatchers("/add","/edit","/download").hasAuthority("USER")
		.antMatchers("/delete","/add").hasAuthority("ADMIN")
		.and()
		.formLogin()
		.loginPage("/showLogin").loginProcessingUrl("/login").defaultSuccessUrl("/").failureUrl("/showLogin?error=2")
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/signout"))
		.logoutSuccessUrl("/showLogin?logout=2");
		
		
		
	}

}
