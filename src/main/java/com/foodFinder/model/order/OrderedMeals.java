package com.foodFinder.model.order;

import com.foodFinder.model.meal.Meal;

import javax.persistence.*;

@Entity
public class OrderedMeals {

    @EmbeddedId
    OrderedMealsKey id;

    @ManyToOne
            @MapsId("meal_id")
            @JoinColumn(name="meal_id")
    Meal meal;

    @ManyToOne
            @MapsId("order_id")
            @JoinColumn(name = "order_id")
    Order order;

    int mealQuantity;

    public OrderedMeals() {
    }
    public OrderedMeals(Order order,Meal meal,int mealQuantity){
        this.order=order;
        this.meal=meal;
        this.mealQuantity=mealQuantity;
    }

    public OrderedMealsKey getId() {
        return id;
    }

    public void setId(OrderedMealsKey id) {
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
