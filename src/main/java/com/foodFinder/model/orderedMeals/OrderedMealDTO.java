package com.foodFinder.model.orderedMeals;

import com.foodFinder.model.meal.MealDTO;
import com.foodFinder.model.order.OrderDTO;


public class OrderedMealDTO {
    private String mealName;
    private Long mealPrice;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public Long getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(Long mealPrice) {
        this.mealPrice = mealPrice;
    }
}
