package com.mteam.moody.app.model.status;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Status. Every prsons post theirs statuses: text, smile, tags.
 * @author Oleg Atsman
 */
@Document(collection = "statuses")
public class Status {
	
	@Id
    private String id;
	
	private String userId;
	
	private Date date;
	
	private String text;
	
	private List<String> tags;
	
	private SmileTypes smileType;
	
	private List<Comment> comments;

	public Status(String userId, Date date, String text, SmileTypes smileType) {
		super();
		this.userId = userId;
		this.date = date;
		this.text = text;
		this.smileType = smileType;
	}

	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public void removeComment(Comment comment) {
		comments.remove(comment);
	}
	
	public String getId() {
		return id;
	}

	public String getAuthor() {
		return userId;
	}

	public void setAuthor(String userId) {
		this.userId = userId;
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