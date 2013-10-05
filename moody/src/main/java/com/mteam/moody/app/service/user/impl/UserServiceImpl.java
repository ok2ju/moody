package com.mteam.moody.app.service.user.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mteam.moody.app.DAO.UserDAO;
import com.mteam.moody.app.model.user.User;
import com.mteam.moody.app.model.user.status.Status;
import com.mteam.moody.app.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public void addStatus(User user, Status status) {
		user.getStatuses().add(status);
		userDAO.updateUser(user);
	}

	@Override
	public void removeStatus(String statusId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void follow(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unFollow(String userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserByUsername(String username) {
		return userDAO.findByUsername(username);		
	}
}
