package com.mteam.moody.model.user.information;

import com.mteam.moody.model.user.information.types.BasicInfo;
import com.mteam.moody.model.user.information.types.ContactInfo;

public class Information {
	
	private BasicInfo basicInfo;
	
	private ContactInfo contactInfo;
	
	/**
	 * Getters and setters. <!---------------------------------------------------------------!>
	 */
	
	public BasicInfo getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(BasicInfo basicInfo) {
		this.basicInfo = basicInfo;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactINfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	
}
