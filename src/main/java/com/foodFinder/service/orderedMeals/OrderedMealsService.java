package com.foodFinder.service.orderedMeals;

import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.meal.MealDTO;
import com.foodFinder.model.orderedMeals.OrderedMeal;
import com.foodFinder.model.orderedMeals.OrderedMealDTO;

import java.util.Set;

public interface OrderedMealsService {
    Set<OrderedMealDTO> findByOrderId(Long id);

    void save(int quantity,Long mealId, Long orderId);
}
