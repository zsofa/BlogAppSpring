package com.example.BlogAppSpring.controller;

import com.example.BlogAppSpring.returnModel.ReturnModel;
import com.example.BlogAppSpring.services.UserService;
import com.example.BlogAppSpring.userModels.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/users/{id}")
    public ReturnModel<UserData> getUserById(@PathVariable Long id) {
        ReturnModel<UserData> returnModel =
                new ReturnModel<>(true, HttpStatus.OK,userService.getUserById(id));

        return returnModel;
    }

    @GetMapping("/user")
    public ReturnModel<UserData> getLoggedInUSer() {

        ReturnModel<UserData> returnModel =
                new ReturnModel<>(true, HttpStatus.OK,userService.getLoggedInUser());

        return returnModel;
    }

   @PostMapping("/register")
    public ReturnModel<UserData> registerUser(@RequestBody UserData userData) {
      ;

      ReturnModel<UserData> toReturn =
              new ReturnModel<>(true,HttpStatus.OK,userService.registerNewUser(userData));
      toReturn.setObject(userData);

      return toReturn;
    }





}
