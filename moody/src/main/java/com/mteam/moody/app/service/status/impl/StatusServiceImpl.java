package com.mteam.moody.app.service.status.impl;

import com.mteam.moody.app.DAO.StatusesDAO;
import com.mteam.moody.app.model.status.Comment;
import com.mteam.moody.app.model.status.Status;
import com.mteam.moody.app.service.status.StatusService;

public class StatusServiceImpl implements StatusService {

	private StatusesDAO statusDAO;
	
	@Override
	public void addComment(String statusId, Comment comment) {
		Status status = statusDAO.findStatuseById(statusId);
		status.addComment(comment);
		statusDAO.saveStatus(status);
	}

	@Override
	public void deleteComment(String statusId, Comment comment) {
		Status status = statusDAO.findStatuseById(statusId);
		status.removeComment(comment);
		statusDAO.saveStatus(status);
	}

}
