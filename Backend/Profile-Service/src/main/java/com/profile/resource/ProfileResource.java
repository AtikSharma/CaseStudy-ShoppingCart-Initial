package com.profile.resource;

import com.profile.exception.UserNotFoundException;
import com.profile.model.UserProfile;
import com.profile.service.ProfileService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@OpenAPIDefinition
@RestController
@CrossOrigin
@RequestMapping("profile")
public class ProfileResource {

    @Autowired
    ProfileService profileService;


    //ADDING PROFILES
    @PostMapping("/addCustomer")
    UserProfile addNewCustomerProfile(@Valid  @RequestBody UserProfile user) {
        return profileService.addNewCustomerProfile(user);
    }

    @PostMapping("/addMerchant")
    void addNewMerchantProfile(@Valid @RequestBody UserProfile user) {
        profileService.addNewMerchantProfile(user);
    }

    @PostMapping("/addDeliveryAgent")
    void addNewDeliveryProfile(@Valid @RequestBody UserProfile user) {
        profileService.addNewDeliveryProfile(user);
    }


    //GETTING PROFILES
    @GetMapping("/getAllProfiles")
    List<UserProfile> getAllProfiles() {
        return profileService.getAllProfiles();
    }


    @GetMapping("/getProfile/{userid}")
    ResponseEntity<UserProfile> getByProfileId(@PathVariable("userid") String userId) {
        UserProfile user;
        try {
            user = profileService.getByProfileId(userId);
        } catch (UserNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    @GetMapping("/getProfile/username/{username}")
    ResponseEntity<UserProfile> getByUserName(@PathVariable("username") String userName) {
        UserProfile user;
        try {
            user = profileService.getByUserName(userName);
        } catch (UserNotFoundException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(user);
    }


    //UPDATE PROFILE
    @PutMapping("/updateProfile")
    void updateProfile(@Valid @RequestBody UserProfile user) {
        profileService.updateProfile(user);
    }


    //DELETE PROFILE
    @DeleteMapping("/deleteProfile/{userid}")
    void deleteProfile(@Valid @PathVariable("userid") String userId) {
        profileService.deleteProfile(userId);
    }


}
