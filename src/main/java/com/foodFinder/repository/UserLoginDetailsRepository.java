package com.foodFinder.repository;

import com.foodFinder.model.userLoginDetails.UserLoginDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserLoginDetailsRepository extends CrudRepository<UserLoginDetails,Long> {
    Optional<UserLoginDetails> findByUserName(String userName);
}
