package com.mteam.moody.model.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mteam.moody.model.user.information.Information;
import com.mteam.moody.model.user.settings.Settings;
 
@Document
public class User {
 
    @Id
    private String id;
    
    private String username;
    
    public User(String username) {
    	this.username = username;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
