package com.foodFinder.repository;

import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.orderedMeals.OrderedMeals;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface OrderedMealsRepository extends CrudRepository<OrderedMeals,Long> {
    Set<Meal> findByOrderId(Long id);
}
