package com.mteam.moody.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.mteam.moody.model.user.User;
 
@Repository
public class UserService implements UserDetailsService {
    
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	public static final String COLLECTION_NAME = "person";
	
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public void clean() {
    	LOGGER.debug("User Service - clean collection: " + COLLECTION_NAME);
    	mongoTemplate.dropCollection(COLLECTION_NAME);
    }
    
    public void addPerson(User person) {
        if (!mongoTemplate.collectionExists(User.class)) {
            mongoTemplate.createCollection(User.class);
        }

        mongoTemplate.insert(person, COLLECTION_NAME);
    }
    
    public User findByUsername(String name) {
    	LOGGER.debug("User Service - findByUsername name: " + name);
    	Criteria criteria = where("userDetails.username").is(name);
    	Query query = new Query(criteria);
    	User users = mongoTemplate.findOne(query, User.class, COLLECTION_NAME);

    	return users;
    }
    
    public List<User> listPerson() {
        return mongoTemplate.findAll(User.class, COLLECTION_NAME);
    }
     
    public void deletePerson(User person) {
        mongoTemplate.remove(person, COLLECTION_NAME);
    }
     
    public void updatePerson(User person) {
        mongoTemplate.insert(person, COLLECTION_NAME);      
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.debug("User Service loadUserByUsername(SS method) name: " + username);
		User user = findByUsername(username);
		if(user!=null){
			return user.getUserDetails();
		}else {
			LOGGER.error("User Service loadUserByUsername(SS method) UERNOTFOUND name: " + username);
			throw new UsernameNotFoundException("Can`t found user with username: "+username);
		}
	}
}