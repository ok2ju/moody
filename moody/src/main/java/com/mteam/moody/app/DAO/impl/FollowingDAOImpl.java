package com.mteam.moody.app.DAO.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mteam.moody.app.DAO.FollowingDAO;
import com.mteam.moody.app.model.follow.Following;

@Repository
public class FollowingDAOImpl implements FollowingDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void saveFollowing(Following following) {
		mongoTemplate.save(following, COLLECTION_NAME);		
	}

	@Override
	public Following findFollowingByUserId(String userId) {
		Criteria criteria = where("userId").is(userId);
    	Query query = new Query(criteria);
    	Following follower = mongoTemplate.findOne(query, Following.class, COLLECTION_NAME);
    	return follower;
	}

}
