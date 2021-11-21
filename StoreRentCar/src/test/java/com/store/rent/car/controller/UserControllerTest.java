package com.store.rent.car.controller;

import com.store.rent.car.dto.LoginRequest;
import com.store.rent.car.enity.Account;
import com.store.rent.car.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @InjectMocks UserController userController;

    @Mock
    UserService userService;

    @Test
    public void testLogin() {
        LoginRequest request = new LoginRequest();
        request.setUsername("username");
        request.setPassword("password");
        Mockito.when(userService.findByUsernameAndPassword(request.getUsername(), request.getPassword())).thenReturn(new Account());
        Assert.assertNotNull(userController.login(request).getBody());
    }

    @Test
    public void testLoginForDataInvalid() {
        Assert.assertEquals("Data invalid", userController.login(null).getBody());
    }

    @Test
    public void testLoginForUserNotFound() {
        LoginRequest request = new LoginRequest();
        request.setUsername("username");
        request.setPassword("password");
        Mockito.when(userService.findByUsernameAndPassword(request.getUsername(), request.getPassword())).thenReturn(null);
        Assert.assertEquals("User not found", userController.login(request).getBody());
    }

}