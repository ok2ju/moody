package com.mteam.moody.model.user.information.types;

public class BasicInfo {
	
	private String Username;
	
	private String firstName;
	
	private String secondName;

	public BasicInfo(String username, String firstName, String secondName) {
		super();
		Username = username;
		this.firstName = firstName;
		this.secondName = secondName;
	}

	/**
	 * Getters and setters. <!---------------------------------------------------------------!>
	 */
	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	
	
	
}
