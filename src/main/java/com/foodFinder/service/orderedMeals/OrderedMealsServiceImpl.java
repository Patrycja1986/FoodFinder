package com.foodFinder.service.orderedMeals;

import com.foodFinder.exceptions.MealsFromDifferentRestaurantsException;
import com.foodFinder.exceptions.ObjectNotFoundException;
import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.meal.MealDTO;
import com.foodFinder.model.order.Order;
import com.foodFinder.model.orderedMeals.OrderedMeal;
import com.foodFinder.model.orderedMeals.OrderedMealDTO;
import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.repository.MealRepository;
import com.foodFinder.repository.OrderRepository;
import com.foodFinder.repository.OrderedMealsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderedMealsServiceImpl implements OrderedMealsService {

    private OrderedMealsRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    public OrderedMealsServiceImpl(OrderedMealsRepository repository) {
        this.repository = repository;
    }

    @Override
    public Set<OrderedMealDTO> findByOrderId(Long id) {
        Set<OrderedMeal> byOrderId = repository.findByOrderId(id);
        if (byOrderId.size() != 0) {
            return byOrderId.stream().map(this::convertToDto).collect(Collectors.toSet());
        } else {
            throw new ObjectNotFoundException("Nothing found. Check if order id is right");
        }
    }

    @Override
    public void save(int quantity, Long mealId, Long orderId) {
        Set<OrderedMeal> orderedMeals = repository.findByOrderId(orderId);
        Optional<Order> orderById = orderRepository.findById(orderId);
        Optional<Meal> mealbyId = mealRepository.findById(mealId);

            if (orderedMeals.size() != 0) {
                if (!orderById.get().getRestaurant().getId().equals(mealbyId.get().getRestaurant().getId())) {
                    throw new MealsFromDifferentRestaurantsException("Could not add to order!Meals must come from the same Restaurant!");
                }
                OrderedMeal orderedMeal = new OrderedMeal(mealbyId.get(), orderById.get(), quantity);
                orderedMeals.add(orderedMeal);
                repository.save(orderedMeal);
            }
            OrderedMeal orderedMeal = new OrderedMeal(mealbyId.get(), orderById.get(), quantity);
            orderById.get().setRestaurant(mealbyId.get().getRestaurant());
            orderedMeals.add(orderedMeal);
            repository.save(orderedMeal);

    }

    @Override
    public void save(Long mealId,Integer quantity) {
        Optional<Meal> byId = mealRepository.findById(mealId);
        Meal meal = byId.get();
        OrderedMeal orderedMeal= new OrderedMeal(byId.get());
        repository.save(orderedMeal);
    }


    private OrderedMealDTO convertToDto(OrderedMeal orderedMeal) {
        return modelMapper.map(orderedMeal, OrderedMealDTO.class);
    }

    private OrderedMeal convertToEntity(OrderedMealDTO orderedMealDTO) throws ParseException {
        return modelMapper.map(orderedMealDTO, OrderedMeal.class);
    }

}
