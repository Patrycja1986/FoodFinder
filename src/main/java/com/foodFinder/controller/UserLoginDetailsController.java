package com.foodFinder.controller;

import com.foodFinder.model.userLoginDetails.UserLoginDetailsDTO;
import com.foodFinder.service.userLoginDetails.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

@RestController
@RequestMapping(name = "/loginDetails")
public class UserLoginDetailsController {

    private LoginService service;

    @Autowired
    public UserLoginDetailsController(LoginService service) {
        this.service = service;
    }

    @PostMapping
    private void addLoginDetails(@RequestBody UserLoginDetailsDTO loginDetailsDTO) throws ParseException {
        service.save(loginDetailsDTO);
    }
}
