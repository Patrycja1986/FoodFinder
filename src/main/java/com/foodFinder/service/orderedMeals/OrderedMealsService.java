package com.foodFinder.service.orderedMeals;

import com.foodFinder.model.meal.Meal;

import java.util.Set;

public interface OrderedMealsService {
    Set<Meal> findByOrderId(Long id);
}
