package com.foodFinder.model.restaurant;

public class RestaurantDTO {
    private Long id;
    private Long version;
    private String restaurantName;
    private String restaurantStreetName;
    private String restaurantStreetNumber;
    private String restaurantPostCode;
    private String restaurantCity;

    public RestaurantDTO(){}

    public Long getVersion() {
        return version;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantStreetName() {
        return restaurantStreetName;
    }

    public void setRestaurantStreetName(String restaurantStreetName) {
        this.restaurantStreetName = restaurantStreetName;
    }

    public String getRestaurantStreetNumber() {
        return restaurantStreetNumber;
    }

    public void setRestaurantStreetNumber(String restaurantStreetNumber) {
        this.restaurantStreetNumber = restaurantStreetNumber;
    }

    public String getRestaurantPostCode() {
        return restaurantPostCode;
    }

    public void setRestaurantPostCode(String restaurantPostCode) {
        this.restaurantPostCode = restaurantPostCode;
    }

    public String getRestaurantCity() {
        return restaurantCity;
    }

    public void setRestaurantCity(String restaurantCity) {
        this.restaurantCity = restaurantCity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
