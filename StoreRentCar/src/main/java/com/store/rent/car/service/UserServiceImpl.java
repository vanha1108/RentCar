package com.store.rent.car.service;

import com.store.rent.car.dao.UserDAO;
import com.store.rent.car.enity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired UserDAO userDAO;

    @Override
    public Account findByUsernameAndPassword(String username, String password) {
        return userDAO.findByUsernameAndPassword(username, password);
    }
}
