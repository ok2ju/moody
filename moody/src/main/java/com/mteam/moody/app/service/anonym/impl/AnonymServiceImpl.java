package com.mteam.moody.app.service.anonym.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mteam.moody.app.DAO.UserDAO;
import com.mteam.moody.app.model.user.User;
import com.mteam.moody.app.service.anonym.AnonymService;

@Service
public class AnonymServiceImpl implements AnonymService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AnonymServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void registerUser(User user) {
		LOGGER.info("Register user: " + user.getUsername());
		userDAO.saveUser(user);
	}

}
