package com.mteam.moody.app.model.dbref;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {

	@Id
	private ObjectId id;
	
	private Float total;
	
	public Account(ObjectId id, Float total) {
		super();
		this.id = id;
		this.total = total;
	}
	
	public ObjectId getId() {
		return id;
	}
	
	public void setId(ObjectId id) {
		this.id = id;
	}
	
	public Float getTotal() {
		return total;
	}
	
	public void setTotal(Float total) {
		this.total = total;
	}

}
