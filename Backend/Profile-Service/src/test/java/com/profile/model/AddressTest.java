package com.profile.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    Address address = new Address();

    @Test
    void houseNo() {
        address.setHouseNo(123);
        assertEquals(123,address.getHouseNo());
    }

    @Test
    void streetName() {
        address.setStreetName("Street");
        assertEquals("Street",address.getStreetName());
    }


    @Test
    void colonyName() {
        address.setColonyName("Colony");
        assertEquals("Colony",address.getColonyName());
    }


    @Test
    void city() {
        address.setCity("city");
        assertEquals("city",address.getCity());
    }


    @Test
    void state() {
        address.setState("State");
        assertEquals("State",address.getState());
    }


    @Test
    void pinCode() {
        address.setPinCode(123456);
        assertEquals(123456,address.getPinCode());
    }

}