package com.webcontroller.controller;

import com.webcontroller.security.model.AuthenticationRequest;
import com.webcontroller.security.model.AuthenticationResponse;
import com.webcontroller.security.service.MyUserDetailService;
import com.webcontroller.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class HelloResource {

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private MyUserDetailService userDetailService;
    @Autowired
    private AuthenticationManager authenticationManager;

    //Authentication and generating JWT token
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            System.out.println("`before` authenticate");
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
            System.out.println("after authenticate");
        } catch (Exception e) {
            return new ResponseEntity("Incorrect Username or password", HttpStatus.NOT_FOUND);
        }

        final UserDetails userDetails = userDetailService.loadUserByUsername(authenticationRequest.getUsername());

        System.out.println("loaduser " + userDetails.getUsername() + " " + userDetails.getPassword() + " " + userDetails.getAuthorities());

        final String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt, userDetails.getAuthorities().toString(), userDetails));
    }
}

