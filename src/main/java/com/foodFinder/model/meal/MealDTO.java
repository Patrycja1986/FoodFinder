package com.foodFinder.model.meal;

import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.model.restaurant.RestaurantDTO;

public class MealDTO {
private Long id;
private Long version;
    private String mealName;
    private String mealDescription;
    private Long mealPrice;
    private Long mealQuantity;

    public MealDTO(String mealName,Long mealPrice, Long mealQuantity) {
        this.mealName = mealName;
    }


    public Long getMealQuantity() {
        return mealQuantity;
    }

    public void setMealQuantity(Long mealQuantity) {
        this.mealQuantity = mealQuantity;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersion() {
        return version;
    }
}
