package com.example.BlogAppSpring.controller;

import com.example.BlogAppSpring.returnModel.ReturnModel;
import com.example.BlogAppSpring.services.UserService;
import com.example.BlogAppSpring.userModels.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ReturnModel<UserData> getAllUsers() {
        ReturnModel<UserData> returnModel =
                new ReturnModel<>(true, HttpStatus.OK,userService.listAllUsers());

        return returnModel;

    }

    @GetMapping("/user/{id}")
    public ReturnModel<UserData> getUserById(@PathVariable Long id) {
        ReturnModel<UserData> returnModel =
                new ReturnModel<>(true, HttpStatus.OK,userService.getUserById(id));

        return returnModel;
    }

   /*@PostMapping("/register")
    public ReturnModel<UserData> registerUser(@RequestBody UserData userData) {

    }*/





}
