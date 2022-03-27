package com.webcontroller.security.service;

import com.webcontroller.model.UserProfile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@SuppressWarnings("serial")
public class MyUserDetails implements UserDetails {
    private String userId;
    private String username;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities; //list of granted Authorities of a user

    public MyUserDetails(UserProfile user) {
        this.userId = user.getUserId();
        this.username = user.getUserFullName();
        this.password = user.getUserPassword();
        this.authorities = Arrays.stream(user.getUserRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
        System.out.println("userdetail " + this.username + " " + this.password + " " + this.authorities + " ");
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities; // returning authorities
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public String getUserId() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
