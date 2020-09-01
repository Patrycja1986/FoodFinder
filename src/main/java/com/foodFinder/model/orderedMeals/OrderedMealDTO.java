package com.foodFinder.model.orderedMeals;

import com.foodFinder.model.meal.MealDTO;
import com.foodFinder.model.order.OrderDTO;


public class OrderedMealDTO {
    private MealDTO meal;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public MealDTO getMeal() {
        return meal;
    }

    public void setMeal(MealDTO meal) {
        this.meal = meal;
    }
}
