package com.mteam.moody.model.user.information.types;

public class ContactInfo {
	
	private String email;
	
	private String phoneNumber;
	
	public ContactInfo(String email, String phoneNumber) {
		super();
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Getters and setters. <!---------------------------------------------------------------!>
	 */
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
