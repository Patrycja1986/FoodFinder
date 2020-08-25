package com.foodFinder.model.restaurant;

public class RestaurantDTO {
    private Long id;
    private String restaurantNameDTO;
    private String restaurantStreetNameDTO;
    private String restaurantStreetNumberDTO;
    private String restaurantPostCodeDTO;
    private String restaurantCityDTO;

    public String getRestaurantNameDTO() {
        return restaurantNameDTO;
    }

    public void setRestaurantNameDTO(String restaurantNameDTO) {
        this.restaurantNameDTO = restaurantNameDTO;
    }

    public String getRestaurantStreetNameDTO() {
        return restaurantStreetNameDTO;
    }

    public void setRestaurantStreetNameDTO(String restaurantStreetNameDTO) {
        this.restaurantStreetNameDTO = restaurantStreetNameDTO;
    }

    public String getRestaurantStreetNumberDTO() {
        return restaurantStreetNumberDTO;
    }

    public void setRestaurantStreetNumberDTO(String restaurantStreetNumberDTO) {
        this.restaurantStreetNumberDTO = restaurantStreetNumberDTO;
    }

    public String getRestaurantPostCodeDTO() {
        return restaurantPostCodeDTO;
    }

    public void setRestaurantPostCodeDTO(String restaurantPostCodeDTO) {
        this.restaurantPostCodeDTO = restaurantPostCodeDTO;
    }

    public String getRestaurantCityDTO() {
        return restaurantCityDTO;
    }

    public void setRestaurantCityDTO(String restaurantCityDTO) {
        this.restaurantCityDTO = restaurantCityDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
