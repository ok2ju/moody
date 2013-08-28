package com.mteam.moody.model.user.settings;

import com.mteam.moody.model.user.settings.types.General;
import com.mteam.moody.model.user.settings.types.Notifications;
import com.mteam.moody.model.user.settings.types.Privacy;

public class Settings {
	
	private General general;
	
	private Notifications notifications;
	
	private Privacy privacy;
	
	public Settings(General general, Notifications notifications, Privacy privacy) {
		super();
		this.general = general;
		this.notifications = notifications;
		this.privacy = privacy;
	}

	/**
	 * Getters and setters. <!---------------------------------------------------------------!>
	 */
	
	public General getGeneral() {
		return general;
	}

	public void setGeneral(General general) {
		this.general = general;
	}

	public Notifications getNotifications() {
		return notifications;
	}

	public void setNotifications(Notifications notifications) {
		this.notifications = notifications;
	}

	public Privacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Privacy privacy) {
		this.privacy = privacy;
	}
}
