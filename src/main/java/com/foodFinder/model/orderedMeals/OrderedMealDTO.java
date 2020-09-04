package com.foodFinder.model.orderedMeals;

import com.foodFinder.model.meal.MealDTO;
import com.foodFinder.model.order.OrderDTO;


public class OrderedMealDTO {
    private MealDTO meal;
    private Integer mealQuantity;

    public int getQuantity() {
        return mealQuantity;
    }

    public void setQuantity(int mealQuantity) {
        this.mealQuantity = mealQuantity;
    }

    public MealDTO getMeal() {
        return meal;
    }

    public Integer getMealQuantity() {
        return mealQuantity;
    }

    public void setMealQuantity(Integer mealQuantity) {
        this.mealQuantity = mealQuantity;
    }

    public void setMeal(MealDTO meal) {
        this.meal = meal;
    }
}
