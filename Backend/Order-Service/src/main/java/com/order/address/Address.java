package com.order.address;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "address")
public class Address {
	
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
