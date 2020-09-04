package com.foodFinder.controller;

import com.foodFinder.exceptions.ObjectNotFoundException;
import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.meal.MealDTO;
import com.foodFinder.service.meal.MealService;
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
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping("/meal/restaurant/{restaurantId}")
    public void addMeal(@RequestBody MealDTO mealDTO, @PathVariable Long restaurantId) throws ParseException {
        mealService.save(mealDTO, restaurantId);
    }

    @PutMapping("/meal/{id}")
    public void updateMeal(@RequestBody MealDTO mealDTO, @PathVariable Long id) {
        mealService.updateMeal(mealDTO,id);
    }

    @GetMapping("/meal/{id}")
    public MealDTO findById(@PathVariable Long id) {
        return mealService.findById(id);
    }

    @GetMapping
    public Set<MealDTO> findAll() {
       return mealService.findAll();
    }

    @GetMapping("meal/restaurant/{id}")
    public Set<MealDTO> findByRestaurantId(@PathVariable Long id) {
        return mealService.findByRestaurantId(id);
    }


    @DeleteMapping("/meal/{id}")
    public void delete(@PathVariable Long id) {
        mealService.delete(id);
    }




}
