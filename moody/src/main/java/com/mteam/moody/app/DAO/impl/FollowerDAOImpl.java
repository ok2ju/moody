package com.mteam.moody.app.DAO.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.mteam.moody.app.DAO.FollowerDAO;
import com.mteam.moody.app.model.follow.Follower;

@Repository
public class FollowerDAOImpl implements FollowerDAO {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public void saveFollower(Follower follower) {
		mongoTemplate.save(follower);
	}

	@Override
	public Follower findFollowersByUserId(String userId) {
		Criteria criteria = where("userId").is(userId);
    	Query query = new Query(criteria);
    	Follower follower = mongoTemplate.findOne(query, Follower.class);
    	return follower;
	}

}
