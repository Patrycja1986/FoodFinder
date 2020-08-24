package com.foodFinder.service.restaurant;

import com.foodFinder.model.restaurant.Restaurant;

import java.util.Optional;
import java.util.Set;


public interface RestaurantService {
    void save(Restaurant restaurant);
    void update(Restaurant restaurant);
    void delete(Restaurant restaurant);
    Set<Restaurant> findAll();
    Optional<Restaurant> findById(Long id);
}
