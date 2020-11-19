package com.foodFinder.model.orderedMeals;

import com.foodFinder.common.BaseEntity;
import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.order.Order;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderedMeal extends BaseEntity {

    @ManyToOne
            @JoinColumn(name="meal_id")
    Meal meal;

    @ManyToOne
            @JoinColumn(name = "order_id")
    Order order;

    public void setMealQuantity(Integer mealQuantity) {
        this.mealQuantity = mealQuantity;
    }

    Integer mealQuantity;

    public OrderedMeal() {
    }
    public OrderedMeal(Meal  meal){
        this.meal=meal;
    }
    public OrderedMeal(Meal meal, Order order,int mealQuantity){
        this.meal=meal;
        this.order=order;
        this.mealQuantity=mealQuantity;
    }
    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getMealQuantity() {
        return mealQuantity;
    }

    public void setMealQuantity(int mealQuantity) {
        this.mealQuantity = mealQuantity;
    }
}
