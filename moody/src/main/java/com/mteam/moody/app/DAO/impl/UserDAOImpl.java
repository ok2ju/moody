package com.mteam.moody.app.DAO.impl;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mteam.moody.app.DAO.UserDAO;
import com.mteam.moody.app.model.user.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);
	
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public UserDAOImpl() {
    	
    }

	@Override
	public void cleanCollection() {

	}

	@Override
	public void saveUser(User user) {
		LOGGER.info("User Service - addUser: " + user.getUsername());
        mongoTemplate.save(user);
	}

	@Override
	public List<User> listUsers() {
		LOGGER.info("User Service - listUsers");
		return mongoTemplate.findAll(User.class);
	}

	@Override
	public void removeUser(User user) {
		LOGGER.info("User Service - deleteUser");
		mongoTemplate.remove(user);
	}

	@Override
	public void removeUser(String username) {
		LOGGER.info("User Service - deleteUserByUserName: " + username);
		User user = findUserByUsername(username);
		mongoTemplate.remove(user);
	}

	@Override
	public void updateUser(User user) {
		LOGGER.info("User Service - updateUser username: " + user.getUsername());
		mongoTemplate.save(user);
	}

	@Override
	public User findUserByUsername(String username) {
		LOGGER.info("User Service - findByUsername name: " + username + " mongoTemplate: " + mongoTemplate);
    	LOGGER.info("Mongotemplate : " + mongoTemplate);
		Criteria criteria = where("username").is(username);
    	Query query = new Query(criteria);
    	User users = mongoTemplate.findOne(query, User.class);

    	return users;
	}

	@Override
	public void saveUsers(List<User> users) {
		LOGGER.info("User Service - addUsers. User.size : " + users.size());
		mongoTemplate.insert(users);
	}
}
