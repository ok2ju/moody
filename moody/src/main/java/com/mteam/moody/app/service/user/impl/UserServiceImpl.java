package com.mteam.moody.app.service.user.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mteam.moody.app.DAO.FollowerDAO;
import com.mteam.moody.app.DAO.FollowingDAO;
import com.mteam.moody.app.DAO.StatusesDAO;
import com.mteam.moody.app.DAO.UserDAO;
import com.mteam.moody.app.model.follow.FollowModel;
import com.mteam.moody.app.model.follow.Follower;
import com.mteam.moody.app.model.follow.Following;
import com.mteam.moody.app.model.status.Status;
import com.mteam.moody.app.model.user.User;
import com.mteam.moody.app.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private FollowerDAO followerDAO;
	
	@Autowired
	private FollowingDAO followingDAO;
	
	@Autowired
	private StatusesDAO statusesDAO;
	
	@Override
	public void addStatus(Status status) {
		statusesDAO.saveStatus(status);
	}

	@Override
	public void removeStatus(String statusId) {
		statusesDAO.removeStatus(statusId);
	}

	@Override
	public void follow(String userId, String followId) {
		Following following = followingDAO.findFollowingByUserId(userId);
		following.follow(followId);
		Follower follower = followerDAO.findFollowersByUserId(followId);
		FollowModel followModel = new FollowModel(followId, false);
		follower.addFollower(followModel);
		followerDAO.saveFollower(follower);
		followingDAO.saveFollowing(following);
	}

	@Override
	public void unFollow(String userId, String followId) {
		Following following = followingDAO.findFollowingByUserId(userId);
		following.unFollow(followId);
		Follower follower = followerDAO.findFollowersByUserId(followId);
		follower.removeFollower(userId);
		followerDAO.saveFollower(follower);
		followingDAO.saveFollowing(following);
	}
	
	@Override
	public User findUserByUsername(String username) {
		return userDAO.findUserByUsername(username);		
	}

	@Override
	public User findUserByUserId(String userId) {
		return userDAO.findUserByUserid(userId);
	}

	@Override
	public Follower findFollower(String userId) {
		return followerDAO.findFollowersByUserId(userId);
	}

	@Override
	public Following findFollowing(String userId) {
		return followingDAO.findFollowingByUserId(userId);
	}

	@Override
	public List<Status> findStatusesByUserId(String userId) {
		return statusesDAO.findStatusesByUserId(userId);
	}
}
