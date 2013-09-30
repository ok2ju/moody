package com.mteam.moody.app.DAO;

import java.util.List;

import com.mteam.moody.app.model.status.Status;

public interface StatusesDAO {
	
	public static final String COLLECTION_NAME = "statuses";
	
	public void saveStatus(Status status);
	
	public Status findStatuseById(String statusId);
	
	public List<Status> findStatusesByUserId(String userId);
	
	public void removeStatus(String statusId);
	
}
