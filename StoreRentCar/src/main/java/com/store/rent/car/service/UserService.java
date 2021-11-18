package com.store.rent.car.service;

import com.store.rent.car.enity.Account;

public interface UserService {
    Account findByUsernameAndPassword(String username, String password);
}
