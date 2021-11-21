package com.store.rent.car.service;

import com.store.rent.car.dao.UserDAO;
import com.store.rent.car.enity.Account;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    @InjectMocks UserServiceImpl userService;

    @Mock UserDAO userDAO;

    @Test
    public void testFindByUsernameAndPassword() {
        String username = "username";
        String password = "password";
        Mockito.when(userDAO.findByUsernameAndPassword(username, password)).thenReturn(new Account());
        Assert.assertNotNull(userService.findByUsernameAndPassword(username, password));
    }
}