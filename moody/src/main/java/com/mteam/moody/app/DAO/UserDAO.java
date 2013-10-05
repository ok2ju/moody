package com.mteam.moody.app.DAO;

import java.util.List;

import com.mteam.moody.app.model.user.User;

public interface UserDAO {
	
	public static final String COLLECTION_NAME = "person";
	
	public void cleanCollection();
	
	public void saveUser(User user);
	
	public void saveUsers(List<User> users);
	
	public User findByUsername(String username);
	
	public List<User> listUsers();
	
	public void deleteUser(User user);
	
	public void deleteUser(String username);
	
	public void updateUser(User user);	
}
