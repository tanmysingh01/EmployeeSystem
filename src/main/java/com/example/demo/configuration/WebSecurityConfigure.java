package com.example.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfigure extends WebSecurityConfigurerAdapter {

	// In memory user approach //

	/*
	 * @Bean
	 * 
	 * @Override protected UserDetailsService userDetailsService() {
	 * 
	 * List<UserDetails> users = new ArrayList<>();
	 * users.add(User.withDefaultPasswordEncoder().username("Tanmay").password(
	 * "1234").roles("USER").build()); return new InMemoryUserDetailsManager(users);
	 * }
	 */

	// SQL USER APPROACH //

	
	  @Autowired
	  
	  public UserDetailsService userDetailService;
	  
	  
	  @Bean
	  public AuthenticationProvider authProvider() {
	  DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
	  provider.setUserDetailsService(userDetailService);
	  provider.setPasswordEncoder(new BCryptPasswordEncoder());
	  
	  return provider;
	  
	  }
	 

}
