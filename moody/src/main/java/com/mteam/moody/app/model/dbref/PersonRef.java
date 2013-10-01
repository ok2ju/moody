package com.mteam.moody.app.model.dbref;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class PersonRef {

	@Id
	private ObjectId id;
	
	@Indexed
	private Integer ssn;
	
	@DBRef
	private Account accounts;
	
	public PersonRef(ObjectId id, Integer ssn, Account accounts) {
		super();
		this.id = id;
		this.ssn = ssn;
		this.accounts = accounts;
	}

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public Integer getSsn() {
		return ssn;
	}

	public void setSsn(Integer ssn) {
		this.ssn = ssn;
	}

	public Account getAccounts() {
		return accounts;
	}

	public void setAccounts(Account accounts) {
		this.accounts = accounts;
	}



}