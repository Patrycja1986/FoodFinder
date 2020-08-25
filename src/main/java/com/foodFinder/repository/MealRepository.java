package com.foodFinder.repository;

import com.foodFinder.model.meal.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MealRepository extends CrudRepository<Meal,Long> {

    Set<Meal> findByRestaurantId(Long id);

    Set<Meal> findByOrderId(Long id);
}
