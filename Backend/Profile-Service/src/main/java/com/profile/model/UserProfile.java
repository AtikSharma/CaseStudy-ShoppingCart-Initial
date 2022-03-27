package com.profile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "profile")
public class UserProfile {

    @Id
    private String userId;
    private String userFullName;
    private String userImage;
    private String userEmail;
    private long userMobileNo;
    private String about;
    private String dateOfBirth;
    private String gender;
    private String userRole;
    private String userPassword;
    private List<Address> userAddresses;


}
