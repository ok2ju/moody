package com.mteam.moody.app.service;

import java.util.List;

import com.mteam.moody.app.model.user.User;

public interface UserService {
	
	public static final String COLLECTION_NAME = "person";
	
	public void cleanCollection();
	
	public void addUser(User user);
	
	public User findByUsername(String username);
	
	public List<User> listUsers();
	
	public void deleteUser(User user);
	
	public void deleteUser(String username);
	
	public void updateUser(User user);	
}
