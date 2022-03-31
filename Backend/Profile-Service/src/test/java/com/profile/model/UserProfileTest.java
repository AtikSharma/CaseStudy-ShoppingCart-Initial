package com.profile.model;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestClassOrder(ClassOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserProfileTest {

    static UserProfile user = new UserProfile();


    @Nested
    @Order(1)
    class settersTest {
        @Test
        @Order(1)
        void setUserId() {
            user.setUserId("userId1");
        }

        @Test
        @Order(2)
        void setUserImage() {
            user.setUserImage("img");
        }

        @Test
        @Order(3)
        void setUserFullName() {
            user.setUserFullName("Name");
        }

        @Test
        @Order(4)
        void setAbout() {
            user.setAbout("about");
        }


        @Test
        @Order(5)
        void setUserMobileNo() {
            user.setUserMobileNo(123456789L);
        }

        @Test
        @Order(6)
        void setUserEmail() {
            user.setUserEmail("abc@email.com");
        }

        @Test
        @Order(7)
        void setDateOfBirth() {
            user.setDateOfBirth("12-02-1993");
        }

        @Test
        @Order(8)
        void setGender() {
            user.setGender("Male");
        }

        @Test
        @Order(9)
        void setUserPassword() {
            user.setUserPassword("1234");
        }

        @Test
        @Order(10)
        void setUserAddresses() {
            Address address = new Address(1, "Street", "Colony", "city", "state", 123456);
            List<Address> addressList = new ArrayList<>();
            addressList.add(address);
            user.setUserAddresses(addressList);
        }

        @Test
        @Order(11)
        void setUserRole() {
            user.setUserRole("Merchant");
        }

    }


    @Nested
    @Order(2)
    class gettersTest {
        @Test
        @Order(1)
        void getUserImage() {
            assertEquals("img", user.getUserImage());
        }

        @Test
        @Order(2)
        void getUserId() {
            assertEquals("userId1", user.getUserId());
        }

        @Test
        @Order(3)
        void getUserFullName() {
            assertEquals("Name", user.getUserFullName());
        }


        @Test
        @Order(4)
        void getUserEmail() {
            assertEquals("abc@email.com", user.getUserEmail());
        }

        @Test
        @Order(5)
        void getUserMobileNo() {
            assertEquals(123456789L, user.getUserMobileNo());
        }


        @Test
        @Order(6)
        void getAbout() {
            assertEquals("about", user.getAbout());
        }


        @Test
        @Order(7)
        void getDateOfBirth() {
            assertEquals("12-02-1993", user.getDateOfBirth());
        }


        @Test
        @Order(8)
        void getGender() {
            assertEquals("Male", user.getGender());
        }


        @Test
        @Order(9)
        void getUserRole() {
            assertEquals("Merchant", user.getUserRole());
        }


        @Test
        @Order(10)
        void getUserPassword() {
            assertEquals("1234", user.getUserPassword());
        }


        @Test
        @Order(11)
        void getUserAddresses() {

            List<Address> addressList = user.getUserAddresses();
            Address address = new Address();
            address.setCity(addressList.get(0).getCity());
            address.setColonyName(addressList.get(0).getColonyName());
            address.setHouseNo(addressList.get(0).getHouseNo());
            address.setState(addressList.get(0).getState());
            address.setPinCode(addressList.get(0).getPinCode());
            address.setStreetName(addressList.get(0).getStreetName());
        }


        @Test
        @Order(12)
        void testToString() {
            user.toString();
        }
    }

}