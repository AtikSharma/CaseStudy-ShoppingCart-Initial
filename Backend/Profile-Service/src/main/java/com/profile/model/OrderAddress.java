package com.profile.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderAddress {
	
	private String customerId;
	private	String fullName;
	private long mobileNumber;
	private int houseNo;
	private String streetName;
	private String colonyName;
	private String city;
	private String state;
	private int pinCode;
}
