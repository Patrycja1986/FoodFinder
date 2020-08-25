package com.foodFinder.controller;

import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.meal.MealDTO;
import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.model.restaurant.RestaurantDTO;
import com.foodFinder.service.meal.MealService;
import com.sun.el.stream.Stream;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/meals")
public class MealController {

    private MealService mealService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public MealController( MealService mealService){
        this.mealService=mealService;
    }

    @PostMapping
    public void addMeal(@RequestBody Meal meal){
        mealService.save(meal);
    }

    @GetMapping("/meal/{id}" )
    public MealDTO findById(@PathVariable Long id){
        Optional<Meal> byId = mealService.findById(id);
        return byId.map(this::convertToDto).orElseThrow(RuntimeException::new);

    }

    @GetMapping
    public Set<MealDTO> findAll(){
        Set<Meal> all = mealService.findAll();
        return all.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    @GetMapping("/restaurant/{id}")
    public Set<MealDTO> findByRestaurantId(@PathVariable Long id){
        Set<Meal> byRestaurantId = mealService.findByRestaurantId(id);
        return byRestaurantId.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    @GetMapping("/order/{id}")
    public Set<MealDTO> findByOrderId(@PathVariable Long id){
        Set<Meal> byOrderId = mealService.findByOrderId(id);
        return byOrderId.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    @DeleteMapping("/meal/{id}")
    public void delete(@PathVariable Long id){
        Meal meal = mealService.findById(id).orElse(new Meal("0", "0", 0L));
        mealService.delete(meal);
    }

    private MealDTO convertToDto(Meal meal) {
        return modelMapper.map(meal, MealDTO.class);
    }



}
