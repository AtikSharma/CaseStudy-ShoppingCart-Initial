package com.webcontroller.security.model;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class AuthenticationResponse {
    private final String jwt;
    private final String role;
    private final UserDetails profile;

    public AuthenticationResponse(String jwt , String role , UserDetails profile) {
        this.jwt = jwt;
        this.role = role.substring(6,role.length()-1);
        this.profile = profile;
    }

}
