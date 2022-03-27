package com.profile.service;

import java.util.List;

import com.profile.exception.UserNotFoundException;
import com.profile.model.UserProfile;

public interface ProfileService {
	
	UserProfile addNewCustomerProfile(UserProfile user);
	void addNewMerchantProfile(UserProfile user);
	void addNewDeliveryProfile(UserProfile user);
	
	List<UserProfile> getAllProfiles();
	UserProfile getByProfileId(String userId) throws UserNotFoundException;
	UserProfile getByUserName(String userFullName) throws UserNotFoundException;

	void updateProfile(UserProfile user);
	
	void deleteProfile(String userId);
//	UserProfile findByMobileNo(long userMobileNo);
//	UserProfile findByMobileNo(long userMobileNo) throws  MobileNoNotFoundException;
}
