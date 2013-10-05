package com.mteam.moody.app.model.user.status;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Status. Every prsons post theirs statuses: text, smile, tags.
 * @author Oleg Atsman
 */
@Document
public class Status {
	
	@Id
    private Object id = new ObjectId();
	
	private String author;
	
	private Date date;
	
	private String text;
	
	private List<String> tags;
	
	private SmileTypes smileType;
	
	private List<Comment> comments;

	public Status(String author, Date date, String text, SmileTypes smileType) {
		super();
		this.author = author;
		this.date = date;
		this.text = text;
		this.smileType = smileType;
	}

	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
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

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public SmileTypes getSmileType() {
		return smileType;
	}

	public void setSmileType(SmileTypes smileType) {
		this.smileType = smileType;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
}