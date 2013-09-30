package com.mteam.moody.app.service.user;

import com.mteam.moody.app.model.status.Status;
import com.mteam.moody.app.model.user.User;


public interface UserService {
	
	public void addStatus(Status status);
	
	public void removeStatus(String statusId);
	
	public void follow(String userId, String followId);
	
	public void unFollow(String userId, String followId);
	
	public User findUserByUsername(String username);
	
}
