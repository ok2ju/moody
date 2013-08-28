package com.mteam.moody.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mteam.moody.model.user.information.Information;
import com.mteam.moody.model.user.settings.Settings;
 
@Document
public class User {
 
    @Id
    private String id;
    
    private Information information;
     
    private Settings settings;
    
    /**
	 * Getters and setters. <!---------------------------------------------------------------!>
	 */
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }   
}
