package com.profile;

import com.profile.exception.MobileNoNotFoundException;
import com.profile.exception.UserNotFoundException;
import com.profile.model.Address;
import com.profile.model.UserProfile;
import com.profile.repository.ProfileRepo;
import com.profile.service.ProfileServiceImpl;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@TestClassOrder(ClassOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class ProfileServiceApplicationTests {

    @Test
    void contextLoads() {
    }

//    static List<UserProfile> users;
//    @Mock
//    ProfileRepo repo;
//    @Mock
//    RestTemplate template;
//    @InjectMocks
//    ProfileServiceImpl service;
//
//    @BeforeAll
//    static void init() {
//        users = new ArrayList<>();
//
//        users.add(new UserProfile("id_1",
//                "UserFullName1",
//                "",
//                "user@email.com",
//                123456789L,
//                "aboutUser1",
//                null,
//                "Male",
//                "MERCHANT",
//                "password1",
//                null
//        ));
//
//        users.add(new UserProfile("id_2",
//                "UserFullName2",
//                "",
//                "user2@email.com",
//                987654321L,
//                "aboutUser2",
//                null,
//                "Female",
//                "CUSTOMER",
//                "password2",
//                null
//        ));
//
//        users.add(new UserProfile("id_3",
//                "UserFullName3",
//                "",
//                "user3@email.com",
//                9876512345L,
//                "aboutUser3",
//                null,
//                "Female",
//                "DELIVERYAGENT",
//                "password3",
//                null
//        ));
//
//    }
//
//    @Nested
//    @Order(1)
//    class addMethods{
//        @Test
//        @Order(1)
//        @DisplayName("AddCustomerProfile")
//        void addCustomerTest() {
//            UserProfile newCustomer =  new UserProfile("id_4",
//                    "UserFullName4",
//                    "",
//                    "user@email.com",
//                    123456789L,
//                    "aboutUser4",
//                    null,
//                    "Male",
//                    "CUSTOMER",
//                    "password4",
//                    new ArrayList<Address>()
//            );
//            when(repo.save(newCustomer)).thenReturn(newCustomer);
//            assertEquals(newCustomer,service.addNewCustomerProfile(newCustomer));
//        }
//
//        @Test
//        @Order(2)
//        @DisplayName("AddMerchantProfile")
//        void addMerchantTest() {
//            UserProfile newMerchant =  new UserProfile("id_6",
//                    "UserFullName6",
//                    "",
//                    "user6@email.com",
//                    123456789L,
//                    "aboutUser4",
//                    null,
//                    "Male",
//                    "MERCHANT",
//                    "password4",
//                    new ArrayList<Address>()
//            );
//
//            service.addNewMerchantProfile(newMerchant);
//            verify(repo,times(1)).save(newMerchant);
//        }
//
//
//        @Test
//        @Order(3)
//        @DisplayName("AddDeliveryProfile")
//        void addDeliveryAgentProfile() {
//            UserProfile newDeliveryAgent =  new UserProfile("id_5",
//                    "UserFullName8",
//                    "",
//                    "user6@email.com",
//                    123456789L,
//                    "aboutUser4",
//                    null,
//                    "Male",
//                    "DELIVERYAGENT",
//                    "password4",
//                    new ArrayList<Address>()
//            );
//
//            service.addNewDeliveryProfile(newDeliveryAgent );
//            verify(repo,times(1)).save(newDeliveryAgent);
//        }
//    }
//
//    @Nested
//    @Order(2)
//    class getMethods{
//        @Test
//        @Order(1)
//        @DisplayName("getAllProfiles")
//        void getAllprofiles() {
//            when(repo.findAll()).thenReturn(users);
//            assertEquals(users.size(), service.getAllProfiles().size());
//        }
//
//        @Test
//        @Order(2)
//        @DisplayName("getByProfileId")
//        void getById() throws UserNotFoundException {
//            String userId = "id_3";
//            when(repo.findById(userId)).thenReturn(users.stream().filter(userProfile -> userProfile.getUserId() == userId).findFirst());
//            assertEquals(userId, service.getByProfileId(userId).getUserId());
//        }
////        @Test
////        @Order(3)
////        @DisplayName("getByProfileId2")
////        void getById2() throws UserNotFoundException {
////            String userId = "id_6"; //intentionally provided wrong input
////            when(repo.findById(userId)).thenReturn(users.stream().filter(userProfile -> userProfile.getUserId() == userId).findFirst());
////            assertEquals(userId, service.getByProfileId(userId).getUserId());
////        }
//
//        @Test
//        @Order(4)
//        @DisplayName("getByUsername")
//        void getByusername() throws UserNotFoundException{
//            String name = "UserFullName2";
//            when(repo.findByuserFullName(name)).thenReturn(users.stream().filter(userProfile -> userProfile.getUserFullName() == name).findFirst().get());
//            assertEquals(name, service.getByUserName(name).getUserFullName());
//        }
//
////        @Test
////        @Order(5)
////        @DisplayName("getByUsername2")
////        void getByusername2() throws UserNotFoundException{
////            String name = "UserFullName5"; //intentionally provided wrong input
////            when(repo.findByuserFullName(name)).thenReturn(users.stream().filter(userProfile -> userProfile.getUserFullName() == name).findFirst().get());
////            assertEquals(name, service.getByUserName(name).getUserFullName());
////        }
//
////        @Test
////        @Order(6)
////        @DisplayName("getByMobile")
////        void getBymobile() throws MobileNoNotFoundException {
////            long mobile = 123456569l; //intentionally provided wrong input
////            try{
////                when(repo.findByuserMobileNo(mobile)).thenReturn(users.stream().filter(userProfile -> userProfile.getUserMobileNo() == mobile).findFirst().get());
////            }
////            catch (Exception e)
////            {
////                throw new MobileNoNotFoundException("Mobile No not found");
////            }
////            assertEquals(mobile, service.findByMobileNo(mobile).getUserMobileNo());
////        }
//
//    }
//
//
//    @Nested
//    @Order(3)
//    class UpdateAndDelete {
//        @Test
//        @Order(1)
//        @DisplayName("updateProfile")
//        void update() {
//            UserProfile updateCustomer =  new UserProfile("id_4",
//                    "UserFullNameUpdated",
//                    "",
//                    "user@email.com",
//                    123456789L,
//                    "aboutUser4",
//                    null,
//                    "Male",
//                    "CUSTOMER",
//                    "password4",
//                    new ArrayList<Address>()
//            );
//
//            service.updateProfile(updateCustomer);
//            verify(repo,times(1)).save(updateCustomer);
//        }
//
//        @Test
//        @Order(2)
//        @DisplayName("deleteProfile")
//        void delete() {
//            String userID = "id_4";
//
//            service.deleteProfile(userID);
//            verify(repo,times(1)).deleteById(userID);
//        }
//    }
//
//
//
//
//
//

}
