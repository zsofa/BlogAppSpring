package com.example.BlogAppSpring.controller;

import com.example.BlogAppSpring.returnModel.ReturnModel;
import com.example.BlogAppSpring.services.UserService;
import com.example.BlogAppSpring.userModels.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        List<UserData> users= userService.listAllUsers();

        if (users != null) {
            return new ReturnModel<>(true, HttpStatus.OK,users);
        } else {
            return new ReturnModel<>(false,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/{id}")
    public ReturnModel<UserData> getUserById(@PathVariable Long id) {
        UserData user = userService.getUserById(id);

        if (user !=  null) {
            return new ReturnModel<>(true, HttpStatus.OK,user);
        } else {
            return new ReturnModel<>(false, HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/user")
    public ReturnModel<UserData> getLoggedInUSer() {

        UserData user = userService.getLoggedInUser();

        if (user != null) {
            return new ReturnModel<>(true, HttpStatus.OK,userService.getLoggedInUser());
        } else {
            return new ReturnModel<>(false,HttpStatus.NOT_FOUND);
        }
    }

   @PostMapping("/register")
    public ReturnModel<UserData> registerUser(@RequestBody UserData userData) {

      ReturnModel<UserData> toReturn =
              new ReturnModel<>(true,HttpStatus.OK,userService.registerNewUser(userData));
      toReturn.setObject(userData);

      return toReturn;
    }





}
