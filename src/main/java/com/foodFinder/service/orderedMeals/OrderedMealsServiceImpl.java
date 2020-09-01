package com.foodFinder.service.orderedMeals;

import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.order.Order;
import com.foodFinder.model.orderedMeals.OrderedMeal;
import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.repository.MealRepository;
import com.foodFinder.repository.OrderRepository;
import com.foodFinder.repository.OrderedMealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class OrderedMealsServiceImpl implements OrderedMealsService {

    private OrderedMealsRepository repository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    public OrderedMealsServiceImpl(OrderedMealsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<Meal> findByOrderId(Long id) {
        return repository.findByOrderId(id);
    }

    @Override
    public void save(int quantity, Long mealId, Long orderId) {
        Order order = orderRepository.findById(orderId).get();
        Meal meal = mealRepository.findById(mealId).get();
        OrderedMeal orderedMeal = new OrderedMeal(meal, order, quantity);
        repository.save(orderedMeal);

    }

}
