package com.mteam.moody.app.model.follow;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "followers")
public class Follower {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String userId;
	
	private List<FollowModel> followers;
	
	public Follower(String userId) {
		this.userId = userId;
		this.followers = new ArrayList<FollowModel>();
	}

	public Follower(String userId, List<FollowModel> followers) {
		super();
		this.userId = userId;
		this.followers = followers;
	}
	
	public void addFollower(FollowModel follower) {
		followers.add(follower);
	}
	
	public void removeFollower(String followerId) {
		followers.remove(followerId);
	}
	
	public String getId() {
		return id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<FollowModel> getFollowers() {
		return followers;
	}

	public void setFollowers(List<FollowModel> followers) {
		this.followers = followers;
	}
}
