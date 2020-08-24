package com.foodFinder.repository;

import com.foodFinder.model.restaurant.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant,Long> {

}
