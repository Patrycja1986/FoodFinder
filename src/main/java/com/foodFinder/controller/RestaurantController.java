package com.foodFinder.controller;

import com.foodFinder.exceptions.ObjectNotFoundException;
import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.model.restaurant.RestaurantDTO;
import com.foodFinder.service.restaurant.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public void addRestaurant(@RequestBody RestaurantDTO restaurantDTO) throws ParseException {
        restaurantService.save(restaurantDTO);
    }

    @PutMapping("/{id}")
    public void updateRestaurant(@RequestBody RestaurantDTO restaurantDTO, @PathVariable Long id) {
        restaurantService.updateRestaurant(restaurantDTO,id);
    }

    @GetMapping("/{id}")
    public RestaurantDTO findById(@PathVariable Long id) {
        return restaurantService.findById(id);
    }

    @GetMapping
    public Set<RestaurantDTO> findAll() {
       return restaurantService.findAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
      restaurantService.delete(id);
    }

}
