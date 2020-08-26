package com.foodFinder.model.meal;

import com.foodFinder.model.restaurant.RestaurantDTO;

public class MealDTO {

    private String mealNameDTO;
    private String mealDescriptionDTO;
    private Long mealPriceDTO;
    private Long restaurantId;

    public String getMealNameDTO() {
        return mealNameDTO;
    }

    public void setMealNameDTO(String mealNameDTO) {
        this.mealNameDTO = mealNameDTO;
    }

    public String getMealDescriptionDTO() {
        return mealDescriptionDTO;
    }

    public void setMealDescriptionDTO(String mealDescriptionDTO) {
        this.mealDescriptionDTO = mealDescriptionDTO;
    }

    public Long getMealPriceDTO() {
        return mealPriceDTO;
    }

    public void setMealPriceDTO(Long mealPriceDTO) {
        this.mealPriceDTO = mealPriceDTO;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
