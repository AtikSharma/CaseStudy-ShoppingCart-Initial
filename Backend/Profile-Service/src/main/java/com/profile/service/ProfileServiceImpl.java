package com.profile.service;

import com.profile.exception.UserNotFoundException;
import com.profile.model.UserProfile;
import com.profile.repository.ProfileRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProfileServiceImpl implements ProfileService {

    Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);


    @Autowired
    ProfileRepo repo;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public UserProfile addNewCustomerProfile(UserProfile user) {
        user.setUserPassword(this.passwordEncoder().encode(user.getUserPassword()));
        user.setUserRole("ROLE_Customer");
        repo.save(user);
        kafkaTemplate.send("CartId", user.getUserId());
        logger.info(user.getUserId(), "{} is published to kafka topic ");
        return user;
    }

    @Override
    public void addNewMerchantProfile(UserProfile user) {
        user.setUserPassword(this.passwordEncoder().encode(user.getUserPassword()));
        user.setUserRole("ROLE_Merchant");
        repo.save(user);
    }

    @Override
    public void addNewDeliveryProfile(UserProfile user) {
        user.setUserPassword(this.passwordEncoder().encode(user.getUserPassword()));
        user.setUserRole("ROLE_DeliveryAgent");
        repo.save(user);
    }

    @Override
    public List<UserProfile> getAllProfiles() {
        return repo.findAll();
    }

    @Override
    public UserProfile getByProfileId(String userId) throws UserNotFoundException {
        Optional<UserProfile> user = repo.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else throw new UserNotFoundException("User Not Found with UserId " + userId);
    }

    @Override
    public UserProfile getByUserName(String userFullName) throws UserNotFoundException {
        if (repo.findByuserFullName(userFullName) == null) {
            throw new UserNotFoundException("User Not Found with UserName " + userFullName);
        }

        return repo.findByuserFullName(userFullName);
    }


    @Override
    public void updateProfile(UserProfile user) {
        repo.save(user);
    }

    @Override
    public void deleteProfile(String userId) {
        repo.deleteById(userId);
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

}
