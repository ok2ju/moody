package com.mteam.moody.app.DAO;

import java.util.List;

import com.mteam.moody.app.model.user.User;

public interface UserDAO {
	
	public void cleanCollection();
	
	public void saveUser(User user);
	
	public void saveUsers(List<User> users);
	
	public User findUserByUsername(String username);
	
	public User findUserByUserid(String userId);
	
	public List<User> listUsers();
	
	public void removeUser(User user);
	
	public void removeUser(String username);
	
	public void updateUser(User user);	
}
