package com.foodFinder.model.orderedMeals;

import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.order.Order;

import javax.persistence.*;

@Entity
public class OrderedMeal {

    @EmbeddedId
    OrderedMealKey id;

    @ManyToOne
            @MapsId("meal_id")
            @JoinColumn(name="meal_id")
    Meal meal;

    @ManyToOne
            @MapsId("order_id")
            @JoinColumn(name = "order_id")
    Order order;

    int mealQuantity;

    public OrderedMeal() {
    }
    public OrderedMeal(Meal meal, Order order,int mealQuantity){
        this.meal=meal;
        this.order=order;
        this.mealQuantity=mealQuantity;
    }

    public OrderedMealKey getId() {
        return id;
    }

    public void setId(OrderedMealKey id) {
        this.id = id;
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
