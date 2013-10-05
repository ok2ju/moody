package com.mteam.moody.app.service.user;

import com.mteam.moody.app.model.user.User;
import com.mteam.moody.app.model.user.status.Status;


public interface UserService {
	
	public void addStatus(User user, Status status);
	
	public void removeStatus(String statusId);
	
	public void follow(String userId);
	
	public void unFollow(String userId);
	
	public User findUserByUsername(String username);
	
}
