package com.mteam.moody.model.user;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mteam.moody.model.user.smile.Smile;
 
@Document
public class User {
 
    @Id
    private String id;
    
    private String username;
    
    private List<Smile> smiles;
    
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

	public List<Smile> getSmiles() {
		return smiles;
	}

	public void setSmiles(List<Smile> smiles) {
		this.smiles = smiles;
	}
	
	
}
