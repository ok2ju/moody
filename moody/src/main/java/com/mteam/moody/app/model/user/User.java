package com.mteam.moody.app.model.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;

import com.mteam.moody.app.model.user.security.UserDetailsImpl;
import com.mteam.moody.app.model.user.status.Status;
 
@Document
public class User {
 
    @Id
    private String id;
        
    private UserDetailsImpl userDetails;
    
    private List<Status> statuses;
    
    private List<Follower> following;
    
    public User() {
    	this.userDetails = new UserDetailsImpl();
    	this.setStatuses(new ArrayList<Status>());
    }
    
    public User(String username, String password, List<GrantedAuthority> authorities) {
    	this.userDetails = new UserDetailsImpl(username, password, authorities);
    	this.setStatuses(new ArrayList<Status>());
    }
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public UserDetailsImpl getUserDetails() {
		return userDetails;
	}
	
	public void setUserDetails(UserDetailsImpl userDetails) {
		this.userDetails = userDetails;
	}

	public List<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}
}
