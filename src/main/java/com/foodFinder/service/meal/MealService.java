package com.foodFinder.service.meal;

import com.foodFinder.model.meal.Meal;

import java.util.Optional;
import java.util.Set;

public interface MealService {
    
    void save(Meal meal);

    Optional<Meal> findById(Long id);

    Set<Meal> findAll();

    Set<Meal> findByRestaurantId(Long id);

    void delete(Meal meal);

    Set<Meal> findByOrderId(Long id);
}
