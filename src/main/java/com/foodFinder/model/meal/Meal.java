package com.foodFinder.model.meal;

import com.foodFinder.common.BaseEntity;
import com.foodFinder.model.orderedMeals.OrderedMeal;
import com.foodFinder.model.restaurant.Restaurant;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Meal extends BaseEntity {

    private String mealName;
    private String mealDescription;
    private Long mealPrice;

    @ManyToOne
    @JoinColumn(name ="restaurant_id")
    private Restaurant restaurant;

    @OneToMany(mappedBy = "meal")
    private Set<OrderedMeal> orderedMeals;


    public Meal(){
    }

    public Meal(String mealName, String mealDescription, Long mealPrice) {
        this.mealName = mealName;
        this.mealDescription = mealDescription;
        this.mealPrice = mealPrice;
    }
    public Meal(String mealName, String mealDescription, Long mealPrice, Restaurant restaurant) {
        this.mealName = mealName;
        this.mealDescription = mealDescription;
        this.mealPrice = mealPrice;
        this.restaurant=restaurant;
    }


    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getMealDescription() {
        return mealDescription;
    }

    public void setMealDescription(String mealDescription) {
        this.mealDescription = mealDescription;
    }

    public Long getMealPrice() {
        return mealPrice;
    }

    public void setMealPrice(Long mealPrice) {
        this.mealPrice = mealPrice;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<OrderedMeal> getOrderedMeals() {
        return orderedMeals;
    }

    public void setOrderedMeals(Set<OrderedMeal> orderedMeals) {
        this.orderedMeals = orderedMeals;
    }
}
