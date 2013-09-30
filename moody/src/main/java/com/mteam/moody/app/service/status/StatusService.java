package com.mteam.moody.app.service.status;

import com.mteam.moody.app.model.status.Comment;

public interface StatusService {
	
	public void addComment(String statusId, Comment comment);
	
	public void deleteComment(String statusId, Comment comment);
	
}
