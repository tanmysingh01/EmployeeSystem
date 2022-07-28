package com.example.demo.empservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.example.demo.empentity.User;
import com.example.demo.repo.UserRepositoty;
@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepositoty repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = repo.findByUsername(username);
		
		if(user==null) throw new UsernameNotFoundException("USer 404");
		return new UserPrinciple(user);
	}

}
