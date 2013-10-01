package com.mteam.moody.app.model.follow;

public class FollowModel {
	
	private String userId;
	
	private boolean checked;
	
	public FollowModel(String userId, boolean checked) {
		super();
		this.userId = userId;
		this.checked = checked;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}	
}
