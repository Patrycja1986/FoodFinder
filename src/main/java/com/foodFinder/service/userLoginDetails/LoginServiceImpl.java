package com.foodFinder.service.userLoginDetails;

import com.foodFinder.model.userLoginDetails.UserLoginDetails;
import com.foodFinder.model.userLoginDetails.UserLoginDetailsDTO;
import com.foodFinder.repository.UserLoginDetailsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    private UserLoginDetailsRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public LoginServiceImpl(UserLoginDetailsRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(UserLoginDetailsDTO loginDetailsDTO) throws ParseException {
        UserLoginDetails loginDetails = convertToEntity(loginDetailsDTO);
        repository.save(loginDetails);
    }

    private UserLoginDetailsDTO convertToDto(UserLoginDetails loginDetails) {
        return modelMapper.map(loginDetails, UserLoginDetailsDTO.class);
    }

    private UserLoginDetails convertToEntity(UserLoginDetailsDTO loginDetailsDTO) throws ParseException {
        return modelMapper.map(loginDetailsDTO, UserLoginDetails.class);
    }
}

