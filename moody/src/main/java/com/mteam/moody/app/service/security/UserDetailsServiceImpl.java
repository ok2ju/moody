package com.mteam.moody.app.service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mteam.moody.app.DAO.UserDAO;
import com.mteam.moody.app.model.user.User;

@Service(value="myUserDetailsService")
@Configurable
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("UserDetailsServiceImpl loadUserByUsername: " + username);
		LOGGER.info("UserDetailsServiceImpl loadUserByUsername userService: " + userDAO);
		User user = userDAO.findUserByUsername(username);
		if(user!=null){
			return user;
		}else {
			LOGGER.error("User Service loadUserByUsername(SS method) UERNOTFOUND name: " + username);
			throw new UsernameNotFoundException("Can`t found user with username: "+username);
		}
	}
}
