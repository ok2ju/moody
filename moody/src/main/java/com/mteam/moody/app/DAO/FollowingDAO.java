package com.mteam.moody.app.DAO;

import com.mteam.moody.app.model.follow.Following;

public interface FollowingDAO {
	
	public static final String COLLECTION_NAME = "following";
	
	public void saveFollowing(Following following);
	
	public Following findFollowingByUserId(String userId);
	
}
