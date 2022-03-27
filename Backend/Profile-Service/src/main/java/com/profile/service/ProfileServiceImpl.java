package com.profile.service;

import com.profile.exception.UserNotFoundException;
import com.profile.model.Role;
import com.profile.model.UserProfile;
import com.profile.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;




@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    ProfileRepo repo;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public UserProfile addNewCustomerProfile(UserProfile user) {
        user.setUserPassword(this.passwordEncoder().encode(user.getUserPassword()));
        user.setUserRole(Role.customer);
        repo.save(user);
        this.restTemplate.postForObject("http://cart-service/cart/addCart/" + user.getUserId(), user, Void.class);
        return user;
    }

    @Override
    public void addNewMerchantProfile(UserProfile user) {
        user.setUserPassword(this.passwordEncoder().encode(user.getUserPassword()));
        user.setUserRole(Role.merchant);
        repo.save(user);
    }

    @Override
    public void addNewDeliveryProfile(UserProfile user) {
        user.setUserPassword(this.passwordEncoder().encode(user.getUserPassword()));
        user.setUserRole(Role.deliveryAgent);
        repo.save(user);
    }

    @Override
    public List<UserProfile> getAllProfiles() {
        return repo.findAll();
    }

    @Override
    public UserProfile getByProfileId(String userId) throws UserNotFoundException {
        return repo.findById(userId).orElseThrow(() -> new UserNotFoundException("UserNotFoundWithId: " + userId));
    }

    @Override
    public UserProfile getByUserName(String userFullName) throws UserNotFoundException {
        System.out.println(userFullName);
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

    //    @Override
//    public UserProfile findByMobileNo(long userMobileNo) throws MobileNoNotFoundException {
//        UserProfile user;
//        user = repo.findByuserMobileNo(userMobileNo);
//        if (user == null) throw new MobileNoNotFoundException("No user found with Mobile No : " + userMobileNo);
//        return repo.findByuserMobileNo(userMobileNo);
//    }

    //HELPER METHODS
//    void addAddressToOrderDB(UserProfile user) {
//        int noOfAddress = user.getUserAddresses().size();
//        for (int i = 0; i < noOfAddress; i++) {
//            OrderAddress newOrderAddress = new OrderAddress(user.getUserId(), user.getUserFullName(), user.getUserMobileNo(), user.getUserAddresses().get(i).getHouseNo(), user.getUserAddresses().get(i).getStreetName(), user.getUserAddresses().get(i).getColonyName(), user.getUserAddresses().get(i).getCity(), user.getUserAddresses().get(i).getState(), user.getUserAddresses().get(i).getPinCode());
//            this.restTemplate.postForObject("http://order-service/order/storeAddress", newOrderAddress, Void.class);
//        }
//
//    }

}
