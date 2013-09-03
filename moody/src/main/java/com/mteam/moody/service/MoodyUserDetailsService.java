package com.mteam.moody.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mteam.moody.model.user.User;
import com.mteam.moody.service.UserService;

public class MoodyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findByUsername(username);
		if(user!=null){
			return user.getUserDetails();
		}else {
			throw new UsernameNotFoundException("Can`t found user with username: "+username);
		}
	}
}
