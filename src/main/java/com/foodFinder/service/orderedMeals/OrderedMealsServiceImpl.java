package com.foodFinder.service.orderedMeals;

import com.foodFinder.model.meal.Meal;
import com.foodFinder.repository.OrderedMealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OrderedMealsServiceImpl implements OrderedMealsService {

    private OrderedMealsRepository repository;

    @Autowired
    public OrderedMealsServiceImpl(OrderedMealsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Meal> findByOrderId(Long id) {
        return repository.findByOrderId(id);
    }
}
