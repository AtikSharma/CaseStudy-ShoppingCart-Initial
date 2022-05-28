package com.profile.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	private int houseNo;
	private String streetName;
	private String colonyName;
	private String city;
	private String state;
	@Min(value = 99999 , message = "Pincode Must be of 6 digits")
	@Max(value = 999999L , message = "Pincode Must be of 6 digits")
	private int pinCode;

	public int getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getColonyName() {
		return colonyName;
	}

	public void setColonyName(String colonyName) {
		this.colonyName = colonyName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(@Valid int pinCode) {
		this.pinCode = pinCode;
	}
}
