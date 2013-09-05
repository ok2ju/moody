package com.mteam.moody.app.model.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mteam.moody.app.model.user.security.UserDetailsImpl;
import com.mteam.moody.app.model.user.smile.Smile;
 
@Document
public class User {
 
    @Id
    private String id;
    
    private String name = "oleg";
        
    private UserDetailsImpl userDetails;
    
    private List<Smile> smiles;
    
    public User() {
    	this.userDetails = new UserDetailsImpl();
    	this.smiles = new ArrayList<Smile>();
    }
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public UserDetailsImpl getUserDetails() {
		return userDetails;
	}
	
	public void setUserDetails(UserDetailsImpl userDetails) {
		this.userDetails = userDetails;
	}

	public List<Smile> getSmiles() {
		return smiles;
	}

	public void setSmiles(List<Smile> smiles) {
		this.smiles = smiles;
	}	
}
