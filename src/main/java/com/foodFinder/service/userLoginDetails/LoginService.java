package com.foodFinder.service.userLoginDetails;

import com.foodFinder.model.userLoginDetails.UserLoginDetailsDTO;

import java.text.ParseException;

public interface LoginService {

    void save(UserLoginDetailsDTO loginDetailsDTO) throws ParseException;
}
