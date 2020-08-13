package com.somupvotes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.somupvotes.domain.User;
import com.somupvotes.repository.UserRepository;
import com.somupvotes.websecurity.CustomSecurityUser;

@Service 
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	User user = userRepo.findByUsername(username);
	
	if(user == null) 
		throw new UsernameNotFoundException("Username and Password");
	
	
		return new CustomSecurityUser(user);
	}

}
