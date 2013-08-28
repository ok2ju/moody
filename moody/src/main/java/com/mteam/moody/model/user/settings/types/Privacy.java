package com.mteam.moody.model.user.settings.types;

import com.mteam.moody.model.user.enums.TypesOfUser;

public class Privacy {
	
	private TypesOfUser WhoCanViewTheMainInformationOnMyProfile;
	
	private TypesOfUser WhoCanSendMePrivateMessages;

	public Privacy() {
		this.WhoCanViewTheMainInformationOnMyProfile = TypesOfUser.EveryOne;
		this.WhoCanSendMePrivateMessages = TypesOfUser.EveryOne;
	}
	
	/**
	 * Getters and setters. <!---------------------------------------------------------------!>
	 */
	
	public TypesOfUser getWhoCanViewTheMainInformationOnMyProfile() {
		return WhoCanViewTheMainInformationOnMyProfile;
	}

	public void setWhoCanViewTheMainInformationOnMyProfile(
			TypesOfUser whoCanViewTheMainInformationOnMyProfile) {
		WhoCanViewTheMainInformationOnMyProfile = whoCanViewTheMainInformationOnMyProfile;
	}

	public TypesOfUser getWhoCanSendMePrivateMessages() {
		return WhoCanSendMePrivateMessages;
	}

	public void setWhoCanSendMePrivateMessages(
			TypesOfUser whoCanSendMePrivateMessages) {
		WhoCanSendMePrivateMessages = whoCanSendMePrivateMessages;
	}
	
}
