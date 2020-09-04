package com.foodFinder.service.restaurant;

import com.foodFinder.exceptions.ObjectNotFoundException;
import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.model.restaurant.RestaurantDTO;
import com.foodFinder.repository.RestaurantRepository;
import com.google.common.collect.Sets;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService {


    private final RestaurantRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(RestaurantDTO restaurantDTO) throws ParseException {
        Restaurant restaurant = convertToEntity(restaurantDTO);
        repository.save(restaurant);
    }

    @Override
    public void delete(Long id) {
        Restaurant byId = repository.findById(id)
                .orElse(new Restaurant("0", "0",
                        "0", "0", "0"));
        repository.delete(byId);
    }

    @Override
    public Set<RestaurantDTO> findAll() {
        Set<Restaurant> set = new HashSet<>();
        repository.findAll().iterator().forEachRemaining(set::add);
        return set.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    @Override
    public RestaurantDTO findById(Long id) {
        Optional<Restaurant> byId = repository.findById(id);
        if (byId.isPresent()) {
            return byId
                    .map(this::convertToDto)
                    .orElseThrow(RuntimeException::new);
        } else {
            throw new ObjectNotFoundException("Restaurant by id= " + id + " not found");
        }
    }

    @Override
    public void updateRestaurant(RestaurantDTO restaurantDTO, Long id) {
        Optional<Restaurant> byId = repository.findById(id);
        if (byId.isPresent()) {
            Restaurant restaurant = byId.get();
            restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
            restaurant.setRestaurantStreetName(restaurantDTO.getRestaurantStreetName());
            restaurant.setRestaurantStreetNumber(restaurantDTO.getRestaurantStreetNumber());
            restaurant.setRestaurantPostCode(restaurantDTO.getRestaurantPostCode());
            restaurant.setRestaurantCity(restaurantDTO.getRestaurantCity());
            repository.save(restaurant);

        } else {
            throw new ObjectNotFoundException("Restaurant by id= " + id + " not found");
        }

    }

    private RestaurantDTO convertToDto(Restaurant restaurant) {
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }

    private Restaurant convertToEntity(RestaurantDTO restaurantDTO) throws ParseException {
        return modelMapper.map(restaurantDTO, Restaurant.class);
    }}
