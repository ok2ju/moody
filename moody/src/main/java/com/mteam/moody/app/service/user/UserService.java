package com.mteam.moody.app.service.user;

import java.util.List;

import com.mteam.moody.app.model.follow.Follower;
import com.mteam.moody.app.model.follow.Following;
import com.mteam.moody.app.model.status.Status;
import com.mteam.moody.app.model.user.User;


public interface UserService {
	
	public void addStatus(Status status);
	
	public void removeStatus(String statusId);
	
	public void follow(String userId, String followId);
	
	public void unFollow(String userId, String followId);
	
	public List<Status> findStatusesByUserId(String userId);
	
	public Follower findFollower(String userId);
	
	public Following findFollowing(String userId);
	
	public User findUserByUsername(String username);
	
	public User findUserByUserId(String userId);
	
}
