package com.profile.model;

import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserProfileTest {


    static UserProfile userProfile = new UserProfile();

    @Test
    @Order(1)
    void userId() {
        userProfile.setUserId("userId1");
        assertEquals("userId1",userProfile.getUserId());
    }

    @Test
    @Order(2)
    void userImage() {
        userProfile.setUserImage("img");
        assertEquals("img",userProfile.getUserImage());
    }

    @Test
    @Order(3)
    void userFullName() {
        userProfile.setUserFullName("Name");
        assertEquals("Name",userProfile.getUserFullName());
    }

    @Test
    @Order(4)
    void about() {
        userProfile.setAbout("about");
        assertEquals("about",userProfile.getAbout());
    }


    @Test
    @Order(5)
    void userMobileNo() {
        userProfile.setUserMobileNo(123456789L);
        assertEquals(123456789L,userProfile.getUserMobileNo());
    }

    @Test
    @Order(6)
    void userEmail() {
        userProfile.setUserEmail("abc@email.com");
        assertEquals("abc@email.com",userProfile.getUserEmail());
    }

    @Test
    @Order(7)
    void dateOfBirth() {
        userProfile.setDateOfBirth("12-02-1993");
        assertEquals("12-02-1993",userProfile.getDateOfBirth());
    }

    @Test
    @Order(8)
    void gender() {
        userProfile.setGender("Male");
        assertEquals("Male",userProfile.getGender());
    }

    @Test
    @Order(9)
    void userPassword() {
        userProfile.setUserPassword("1234");
        assertEquals("1234",userProfile.getUserPassword());
    }

    @Test
    @Order(10)
    void userAddresses() {
        Address address = new Address(1, "Street", "Colony", "city", "state", 123456);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address);
        userProfile.setUserAddresses(addressList);
        assertEquals(addressList.size(),userProfile.getUserAddresses().size());
    }

    @Test
    @Order(11)
    void userRole() {
        userProfile.setUserRole("Merchant");
        assertEquals("Merchant",userProfile.getUserRole());
    }

    @Test
    @Order(12)
    void testToString() {
        assertEquals(userProfile.toString(),userProfile.toString());
    }



}