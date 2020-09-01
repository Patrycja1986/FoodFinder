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
    ModelMapper modelMapper;

    @Autowired
    public OrderedMealsController(OrderedMealsService service) {
        this.service = service;
    }

    @PostMapping("/meal/{mealId}/order/{orderId}")
    public void addOrderedMeals(@RequestParam int quantity,@PathVariable Long mealId, @PathVariable Long orderId) throws ParseException {

        service.save(quantity,mealId, orderId);
    }

    @GetMapping("/order/{id}")
    public Set<MealDTO> findByOrderId(@PathVariable Long id){
        Set<Meal> byOrderId = service.findByOrderId(id);
        return byOrderId.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    private MealDTO convertToDto(Meal meal) {
        return modelMapper.map(meal, MealDTO.class);
    }

    private OrderedMealDTO convertToDto(OrderedMeal orderedMeal) {
        return modelMapper.map(orderedMeal, OrderedMealDTO.class);
    }

    private OrderedMeal convertToEntity(OrderedMealDTO orderedMealDTO) throws ParseException {
        return modelMapper.map(orderedMealDTO, OrderedMeal.class);
    }
}
