package com.mteam.moody.app.DAO;

import com.mteam.moody.app.model.follow.Follower;

public interface FollowerDAO {
	
	public static final String COLLECTION_NAME = "followes";
	
	public void saveFollower(Follower follower);
	
	public Follower findFollowersByUserId(String userId);
	
}
