package com.foodFinder.model.restaurant;

import com.foodFinder.common.BaseEntity;
import com.foodFinder.model.meal.Meal;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Restaurant extends BaseEntity {

     private String restaurantName;
     private String restaurantStreetName;
     private String restaurantStreetNumber;
     private String restaurantPostCode;
     private String restaurantCity;

     @OneToMany( mappedBy = "restaurant")
     private Set<Meal> meals = new HashSet<>();


     public Restaurant() {
     }

     public  Restaurant(String restaurantName,String restaurantStreetName, String restaurantStreetNumber,
                        String restaurantPostCode, String restaurantCity){
          this.restaurantName=restaurantName;
          this.restaurantStreetName=restaurantStreetName;
          this.restaurantStreetNumber=restaurantStreetNumber;
          this.restaurantPostCode=restaurantPostCode;
          this.restaurantCity=restaurantCity;
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

     public Set<Meal> getMeals() {
          return meals;
     }

     public void setMeals(Set<Meal> meals) {
          this.meals = meals;
     }
}
