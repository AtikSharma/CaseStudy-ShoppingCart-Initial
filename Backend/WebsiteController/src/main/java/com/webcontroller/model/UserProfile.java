package com.webcontroller.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserProfile {
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
