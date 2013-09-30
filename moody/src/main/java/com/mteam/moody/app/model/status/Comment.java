package com.mteam.moody.app.model.status;

import java.util.Date;

/**
 * Comments can be added by another peoples to some statuses.
 * @author Aleh_Atsman
 *
 */
public class Comment {
	
	private String author;
	
	private Date date;
	
	private String text;
	
	public Comment(String author, Date date, String text) {
		this.author = author;
		this.date = date;
		this.text = text;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}	
}
