package com.profile.resource;

import com.profile.exception.UserNotFoundException;
import com.profile.model.UserProfile;
import com.profile.service.ProfileServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProfileResourceTest {

    @Mock
    ProfileServiceImpl service;

    @InjectMocks
    ProfileResource resource;

    @Test
    void addNewCustomerProfile() {
        UserProfile customer = new UserProfile();
        when(service.addNewCustomerProfile(customer)).thenReturn(customer);
        assertEquals(customer,resource.addNewCustomerProfile(customer));
    }

    @Test
    void addNewMerchantProfile() {
        UserProfile merchant = new UserProfile();
        resource.addNewMerchantProfile(merchant);
        verify(service,times(1)).addNewMerchantProfile(merchant);

    }

    @Test
    void addNewDeliveryProfile() {

        UserProfile delivery = new UserProfile();
        resource.addNewDeliveryProfile(delivery);
        verify(service,times(1)).addNewDeliveryProfile(delivery);

    }

    @Test
    void getAllProfiles() {
        List<UserProfile> users = new ArrayList<>();
        when(service.getAllProfiles()).thenReturn(users);
        assertEquals(users,resource.getAllProfiles());
    }

    @Test
    void getByProfileId() throws UserNotFoundException {
        UserProfile delivery = new UserProfile();
        delivery.setUserId("1");
        when(service.getByProfileId("1")).thenReturn(delivery);
        assertEquals(delivery,resource.getByProfileId("1").getBody());
    }

    @Test
    void getByUserName() throws UserNotFoundException {
        UserProfile delivery = new UserProfile();
        delivery.setUserFullName("Name");
        when(service.getByUserName("Name")).thenReturn(delivery);
        assertEquals(delivery,resource.getByUserName("Name").getBody());

    }

    @Test
    void getByProfileId2() throws UserNotFoundException {
        UserProfile delivery = new UserProfile();
        delivery.setUserId("3");
        when(service.getByProfileId("1")).thenThrow(new UserNotFoundException("error"));
        assertEquals("error",resource.getByProfileId("1").getBody());

    }

    @Test
    void getByUserName2() throws UserNotFoundException {
        UserProfile delivery = new UserProfile();
        delivery.setUserFullName("Name3");
        when(service.getByUserName("Name")).thenThrow(new UserNotFoundException("error"));
        assertEquals("error",resource.getByUserName("Name").getBody());

    }

    @Test
    void updateProfile() {
        UserProfile delivery = new UserProfile();
        resource.updateProfile(delivery);
        verify(service,times(1)).updateProfile(delivery);

    }

    @Test
    void deleteProfile() {
        UserProfile delivery = new UserProfile();
        delivery.setUserId("1");
        resource.deleteProfile("1");
        verify(service,times(1)).deleteProfile("1");

    }


}