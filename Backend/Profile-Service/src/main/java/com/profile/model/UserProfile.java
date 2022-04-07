package com.profile.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "profile")
public class UserProfile {

    @Id
    private String userId;

    @NotBlank(message = "Name must be Provided")
    private String userFullName;

    private String userImage;

    @Email(message = "Email format should be xyz@email.com")
    @NotBlank(message = "Email must be Provided")
    private String userEmail;

    @Min(value = 999999999, message = "Mobile no must be of 10 digits")
    @Max(value = 9999999999L, message = "Mobile no must be of 10 digits")
    private long userMobileNo;

    private String about;
    private String dateOfBirth;
    private String gender;

    @NotBlank(message = "Role can't be empty")
    private String userRole;

    @NotBlank(message = "Password can't be null")
    private String userPassword;

    @Valid
    private List<Address> userAddresses;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public long getUserMobileNo() {
        return userMobileNo;
    }

    public void setUserMobileNo(long userMobileNo) {
        this.userMobileNo = userMobileNo;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public List<Address> getUserAddresses() {
        return userAddresses;
    }

    public void setUserAddresses(List<Address> userAddresses) {
        this.userAddresses = userAddresses;
    }
}
