package com.mteam.moody.app.DAO;

import com.mteam.moody.app.model.follow.Following;

public interface FollowingDAO {
	
	public void saveFollowing(Following following);
	
	public Following findFollowingByUserId(String userId);
	
}
