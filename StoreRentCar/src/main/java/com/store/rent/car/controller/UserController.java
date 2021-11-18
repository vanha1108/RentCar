package com.store.rent.car.controller;

import com.store.rent.car.dto.LoginRequest;
import com.store.rent.car.enity.Account;
import com.store.rent.car.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        if (request == null) {
            return new ResponseEntity<>("Data invalid", HttpStatus.BAD_REQUEST);
        }
        Account account = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
        if (account == null) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
