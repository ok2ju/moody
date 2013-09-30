package com.mteam.moody.app.model.follow;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "following")
public class Following {
	
	@Id
	private String id;
	
	@Indexed(unique = true)
	private String userId;
	
	private List<String> followings;
	
	public Following(String userId) {
		this.userId = userId;
		this.followings = new ArrayList<String>();
	}

	public Following(String userId, List<String> followings) {
		super();
		this.userId = userId;
		this.followings = followings;
	}

	public void follow(String followId) {
		followings.add(followId);
	}
	
	public void unFollow(String followId) {
		followings.remove(followId);
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

	public List<String> getFollowings() {
		return followings;
	}

	public void setFollowings(List<String> followings) {
		this.followings = followings;
	}
}
