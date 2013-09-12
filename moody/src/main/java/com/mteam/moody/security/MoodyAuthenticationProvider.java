package com.mteam.moody.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mteam.moody.model.user.User;
import com.mteam.moody.service.UserService;

@Service
public class MoodyAuthenticationProvider implements UserDetailsService{

	@Autowired
	private UserService personService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = personService.findByUsername(username).get(0);
		if(user!=null){
			return user.getUserDetails();
		}else {
			throw new UsernameNotFoundException("Can`t found user with username: "+username);
		}
	}
}