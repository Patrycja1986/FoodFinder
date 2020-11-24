package com.foodFinder.model.orderedMeals;

import com.foodFinder.model.meal.MealDTO;
import com.foodFinder.model.order.OrderDTO;


public class OrderedMealDTO {

    private Long id;
    private Long version;
    private MealDTO meal;
    private OrderDTO order;
    private Integer mealQuantity;


    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

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

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }
}
