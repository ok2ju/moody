package com.mteam.moody.app.DAO.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mteam.moody.app.DAO.StatusesDAO;
import com.mteam.moody.app.model.status.Status;

@Repository
public class StatusesDAOImpl implements StatusesDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void saveStatus(Status status) {
		mongoTemplate.save(status);
	}

	@Override
	public Status findStatuseById(String statusId) {
		Criteria criteria = where("id").is(statusId);
    	Query query = new Query(criteria);
    	Status status = mongoTemplate.findOne(query, Status.class);
    	return status;
	}

	@Override
	public List<Status> findStatusesByUserId(String userId) {
		Criteria criteria = where("userId").is(userId);
    	Query query = new Query(criteria);
    	List<Status> statuses = mongoTemplate.find(query, Status.class);
    	return statuses;
	}

	@Override
	public void removeStatus(String statusId) {
		Criteria criteria = where("id").is(statusId);
    	Query query = new Query(criteria);
		mongoTemplate.remove(query, Status.class);
	}
}
