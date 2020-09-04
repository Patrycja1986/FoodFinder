package com.foodFinder.controller;

import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.meal.MealDTO;
import com.foodFinder.model.orderedMeals.OrderedMeal;
import com.foodFinder.model.orderedMeals.OrderedMealDTO;
import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.model.restaurant.RestaurantDTO;
import com.foodFinder.service.orderedMeals.OrderedMealsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/orderedMeals")
public class OrderedMealsController {

    private OrderedMealsService service;

    @Autowired
    public OrderedMealsController(OrderedMealsService service) {
        this.service = service;
    }

    @PostMapping("/meal/{mealId}/order/{orderId}/quantity/{quantity}")
    public void addOrderedMeals(@PathVariable Long mealId, @PathVariable Long orderId,@PathVariable Integer quantity) throws ParseException {

        service.save(quantity,mealId, orderId);
    }

    @GetMapping("/order/{id}")
    public Set<OrderedMealDTO> findByOrderId(@PathVariable Long id){
      return service.findByOrderId(id);
    }

}
