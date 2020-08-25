package com.foodFinder.service.meal;

import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MealServiceImpl implements MealService {

    private MealRepository mealRepository;

    @Autowired
    public MealServiceImpl(MealRepository mealRepository){
        this.mealRepository=mealRepository;
    }

    @Override
    public void save(Meal meal) {
        mealRepository.save(meal);
    }

    @Override
    public Optional<Meal> findById(Long id) {
        return mealRepository.findById(id);
    }

    @Override
    public Set<Meal> findAll() {
        Iterable<Meal> all = mealRepository.findAll();
        Set<Meal> set = new HashSet<>();
        all.iterator().forEachRemaining(set::add);
        return set;
    }

    @Override
    public Set<Meal> findByRestaurantId(Long id) {
        return mealRepository.findByRestaurantId(id);
    }

    @Override
    public void delete(Meal meal) {
        mealRepository.delete(meal);
    }

    @Override
    public Set<Meal> findByOrderId(Long id) {
        return mealRepository.findByOrderId(id);
    }
}
