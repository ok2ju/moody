package com.mteam.moody.app.service.anonym.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mteam.moody.app.DAO.FollowerDAO;
import com.mteam.moody.app.DAO.FollowingDAO;
import com.mteam.moody.app.DAO.UserDAO;
import com.mteam.moody.app.model.user.User;
import com.mteam.moody.app.service.anonym.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RegisterServiceImpl.class);
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private FollowingDAO followingDAO;
	
	@Autowired
	private FollowerDAO followerDAO;

	
	@Override
	public void registerUser(User user) {
		userDAO.saveUser(user);
		
	}

}
