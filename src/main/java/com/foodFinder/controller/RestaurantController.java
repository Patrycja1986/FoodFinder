package com.foodFinder.controller;

import com.foodFinder.exceptions.restaurant.ObjectNotFoundException;
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

    @Autowired
    private ModelMapper modelMapper;

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public void addRestaurant(@RequestBody RestaurantDTO restaurantDTO) throws ParseException {
        Restaurant restaurant = convertToEntity(restaurantDTO);
        restaurantService.save(restaurant);
    }

    @PutMapping("/restaurant/{id}")
    public void updateRestaurant(@RequestBody RestaurantDTO restaurantDTO, @PathVariable Long id) {

        Optional<Restaurant> byId = restaurantService.findById(id);
        if (byId.isPresent()) {
            Restaurant restaurant = byId.get();
            restaurant.setRestaurantName(restaurantDTO.getRestaurantName());
            restaurant.setRestaurantStreetName(restaurantDTO.getRestaurantStreetName());
            restaurant.setRestaurantStreetNumber(restaurantDTO.getRestaurantStreetNumber());
            restaurant.setRestaurantPostCode(restaurantDTO.getRestaurantPostCode());
            restaurant.setRestaurantCity(restaurantDTO.getRestaurantCity());
            restaurantService.save(restaurant);

        } else {
            throw new ObjectNotFoundException("Restaurant by id= " + id + " not found");
        }


    }

    @GetMapping("/restaurant/{id}")
    public RestaurantDTO findById(@PathVariable Long id) {

        Optional<Restaurant> byId = restaurantService.findById(id);
        if (byId.isPresent()) {
            return byId
                    .map(this::convertToDto)
                    .orElseThrow(RuntimeException::new);
        } else {
            throw new ObjectNotFoundException("Restaurant by id= " + id + " not found");
        }
    }

    @GetMapping
    public Set<RestaurantDTO> findAll() {
        Set<Restaurant> all = restaurantService.findAll();
        return all.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        Restaurant byName = restaurantService.findById(id)
                .orElse(new Restaurant("0", "0",
                        "0", "0", "0"));
        restaurantService.delete(byName);
    }

    private RestaurantDTO convertToDto(Restaurant restaurant) {
        return modelMapper.map(restaurant, RestaurantDTO.class);
    }

    private Restaurant convertToEntity(RestaurantDTO restaurantDTO) throws ParseException {
        return modelMapper.map(restaurantDTO, Restaurant.class);
    }

}
