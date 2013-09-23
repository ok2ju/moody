package com.mteam.moody.app.model.user.smile;

import java.util.Date;


public class Smile {
	
	private SmileTypes smileType;
	
	private Date data;
	
	private String comment;
	
	public Smile(SmileTypes smileType, Date data, String comment) {
		super();
		this.smileType = smileType;
		this.data = data;
		this.comment = comment;
	}

	/**
	 * Getters and setters. <!---------------------------------------------------------------!>
	 */
	
	public SmileTypes getSmileType() {
		return smileType;
	}

	public void setSmileType(SmileTypes smileType) {
		this.smileType = smileType;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
