package com.mteam.moody.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import com.mteam.moody.model.user.User;
 
@Repository
public class PersonService {
     
    @Autowired
    private MongoTemplate mongoTemplate;
     
    public static final String COLLECTION_NAME = "person";
    
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
    
    public List<User> findByName(String name) {
    	Criteria criteria = where("username").is(name);
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