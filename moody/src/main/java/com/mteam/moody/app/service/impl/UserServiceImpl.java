package com.mteam.moody.app.service.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mteam.moody.app.model.user.User;
import com.mteam.moody.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public UserServiceImpl() {
    	
    }

	@Override
	public void cleanCollection() {
		LOGGER.info("User Service - cleanCollection: " + COLLECTION_NAME);
    	mongoTemplate.dropCollection(COLLECTION_NAME);
	}

	@Override
	public void addUser(User user) {
		LOGGER.info("User Service - addUser: " + user.getUserDetails().getUsername());
		if (!mongoTemplate.collectionExists(User.class)) {
            mongoTemplate.createCollection(User.class);
        }
        mongoTemplate.insert(user, COLLECTION_NAME);
	}

	@Override
	public List<User> listUsers() {
		LOGGER.info("User Service - listUsers");
		return mongoTemplate.findAll(User.class, COLLECTION_NAME);
	}

	@Override
	public void deleteUser(User user) {
		LOGGER.info("User Service - deleteUser");
		mongoTemplate.remove(user, COLLECTION_NAME);
	}

	@Override
	public void deleteUser(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(User user) {
		LOGGER.info("User Service - updateUser username: " + user.getUserDetails().getUsername());
		mongoTemplate.insert(user, COLLECTION_NAME);
	}

	@Override
	public User findByUsername(String username) {
		LOGGER.info("User Service - findByUsername name: " + username + "mongoTemplate: " + mongoTemplate);
    	LOGGER.info("Mongotemplate : " + mongoTemplate);
		Criteria criteria = where("userDetails.username").is(username);
    	Query query = new Query(criteria);
    	User users = mongoTemplate.findOne(query, User.class, COLLECTION_NAME);

    	return users;
	}

	@Override
	public void addUsers(List<User> users) {
		LOGGER.info("User Service - addUsers. User.size : " + users.size());
		mongoTemplate.insert(users, COLLECTION_NAME);
	}
}
