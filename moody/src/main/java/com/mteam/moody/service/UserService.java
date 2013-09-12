package com.mteam.moody.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mteam.moody.model.user.User;
 
@Repository
public class UserService {
     
	public static final String COLLECTION_NAME = "person";
	
    @Autowired
    private MongoTemplate mongoTemplate;
    
    public void clean() {
    	mongoTemplate.dropCollection(COLLECTION_NAME);
    }
    
    public void addPerson(User person) {
        if (!mongoTemplate.collectionExists(User.class)) {
            mongoTemplate.createCollection(User.class);
        }
        person.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(person, COLLECTION_NAME);
    }
    
    public List<User> findByUsername(String name) {
    	Criteria criteria = where("name").is("oleg");
    	Query query = new Query(criteria);
    	List<User> users = mongoTemplate.find(query, User.class, COLLECTION_NAME);

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
}