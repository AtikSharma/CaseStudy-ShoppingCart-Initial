package com.webcontroller.security.service;

import com.webcontroller.model.UserProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserProfile user = restTemplate.getForObject("http://profile-service/profile/getProfile/username/" + userName, UserProfile.class); //finding user by username
        System.out.println(user);
        if (user == null) {
            System.out.println("inside throw");
            throw new UsernameNotFoundException("Not Found" + userName);
        }
        return new MyUserDetails(user);
    }
}
