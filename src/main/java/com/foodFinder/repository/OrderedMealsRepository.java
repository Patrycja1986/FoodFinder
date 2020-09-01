package com.foodFinder.repository;

import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.orderedMeals.OrderedMeal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderedMealsRepository extends CrudRepository<OrderedMeal,Long> {
    Set<Meal> findByOrderId(Long id);
}
