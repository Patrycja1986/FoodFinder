package com.foodFinder.service.userLoginDetails;

import com.foodFinder.model.userLoginDetails.UserLoginDetails;
import com.foodFinder.model.userLoginDetails.UserDetailsImpl;
import com.foodFinder.repository.UserLoginDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserLoginDetailsRepository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserLoginDetails> byUserName = repository.findByUserName(s);
        byUserName.orElseThrow(() -> new UsernameNotFoundException("User: " + s + " not found."));
        return byUserName.map(UserDetailsImpl::new).get();
    }
}
