package com.foodFinder.service.orderedMeals;

import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.orderedMeals.OrderedMeal;

import java.util.Set;

public interface OrderedMealsService {
    Set<Meal> findByOrderId(Long id);

    void save(int quantity,Long mealId, Long orderId);
}
