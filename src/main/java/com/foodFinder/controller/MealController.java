package com.foodFinder.controller;

import com.foodFinder.exceptions.restaurant.ObjectNotFoundException;
import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.meal.MealDTO;
import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.service.meal.MealService;
import com.foodFinder.service.restaurant.RestaurantService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
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
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping("/meal/restaurant/{restaurantId}")
    public void addMeal(@RequestBody MealDTO mealDTO, @PathVariable Long restaurantId) throws ParseException {
        Meal meal = convertToEntity(mealDTO);
        mealService.save(meal, restaurantId);
    }

    @PutMapping("/meal/{id}")
    public void updateMeal(@RequestBody MealDTO mealDTO, @PathVariable Long id) {

        Optional<Meal> byId = mealService.findById(id);
        if (byId.isPresent()) {
            Meal meal = byId.get();
            meal.setMealName(mealDTO.getMealName());
            meal.setMealDescription(mealDTO.getMealDescription());
            meal.setMealPrice(mealDTO.getMealPrice());
            mealService.save(meal);

        } else {
            throw new ObjectNotFoundException("Meal by id= " + id + " not found");
        }
    }

    @GetMapping("/meal/{id}")
    public MealDTO findById(@PathVariable Long id) {

        Optional<Meal> byId = mealService.findById(id);
        if (byId.isPresent()) {
            return byId.map(this::convertToDto).orElseThrow(RuntimeException::new);
        } else {
            throw new ObjectNotFoundException("Meal by id= "+id+" not found");
        }
    }

    @GetMapping
    public Set<MealDTO> findAll() {
        Set<Meal> all = mealService.findAll();
        return all.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    @GetMapping("meal/restaurant/{id}")
    public Set<MealDTO> findByRestaurantId(@PathVariable Long id) {

        Set<Meal> byRestaurantId = mealService.findByRestaurantId(id);
        if (byRestaurantId.size() != 0) {
            return byRestaurantId.stream().map(this::convertToDto).collect(Collectors.toSet());
        }else{
            throw new ObjectNotFoundException("Restaurant by id= "+id+" not found.");
        }
    }


    @DeleteMapping("/meal/{id}")
    public void delete(@PathVariable Long id) {
        Meal meal = mealService.findById(id).orElse(new Meal("0", "0", 0L));
        mealService.delete(meal);
    }

    private MealDTO convertToDto(Meal meal) {
        return modelMapper.map(meal, MealDTO.class);
    }

    private Meal convertToEntity(MealDTO mealDTO) throws ParseException {
        Meal meal = modelMapper.map(mealDTO, Meal.class);
        return meal;
    }


}
