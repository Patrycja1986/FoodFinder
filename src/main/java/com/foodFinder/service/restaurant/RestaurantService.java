package com.foodFinder.service.restaurant;

import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.model.restaurant.RestaurantDTO;

import java.text.ParseException;
import java.util.Optional;
import java.util.Set;


public interface RestaurantService {
    void save(RestaurantDTO restaurantDTO) throws ParseException;
    void delete(Long id);
    Set<RestaurantDTO> findAll();
    RestaurantDTO findById(Long id);

    void updateRestaurant(RestaurantDTO restaurantDTO, Long id);
}
