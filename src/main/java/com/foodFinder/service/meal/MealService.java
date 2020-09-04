package com.foodFinder.service.meal;

import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.meal.MealDTO;

import java.text.ParseException;
import java.util.Optional;
import java.util.Set;

public interface MealService {
    
    void save(MealDTO meal, Long id) throws ParseException;

    MealDTO findById(Long id);

    Set<MealDTO> findAll();

    Set<MealDTO> findByRestaurantId(Long id);

    void delete(Long id);


    void save(Meal meal);

    void updateMeal(MealDTO mealDTO, Long id);
}
