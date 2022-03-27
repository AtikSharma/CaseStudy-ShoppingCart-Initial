package com.profile.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.profile.model.UserProfile;

@Repository
public interface ProfileRepo extends MongoRepository<UserProfile, String>{
	
	UserProfile findByuserMobileNo(long userMobileNo);
	UserProfile findByuserFullName(String userFullName);
}