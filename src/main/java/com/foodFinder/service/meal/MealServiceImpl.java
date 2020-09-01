package com.foodFinder.service.meal;

import com.foodFinder.exceptions.restaurant.ObjectNotFoundException;
import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.repository.MealRepository;
import com.foodFinder.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class MealServiceImpl implements MealService {

    private MealRepository mealRepository;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    public MealServiceImpl(MealRepository mealRepository) {

        this.mealRepository = mealRepository;
    }

    @Override
    public void save(Meal meal, Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if(restaurant.isPresent()){

            meal.setRestaurant(restaurant.get());
            mealRepository.save(meal);
        }else{
            throw new ObjectNotFoundException("Unable to create meal. Restaurant by id= "+id+" not found");
        }
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


}
