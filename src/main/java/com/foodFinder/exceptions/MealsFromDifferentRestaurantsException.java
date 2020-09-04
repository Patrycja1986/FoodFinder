package com.foodFinder.exceptions;

public class MealsFromDifferentRestaurantsException extends RuntimeException {

    public MealsFromDifferentRestaurantsException() {
    }

    public MealsFromDifferentRestaurantsException(String message) {
        super(message);
    }

    public MealsFromDifferentRestaurantsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MealsFromDifferentRestaurantsException(Throwable cause) {
        super(cause);
    }
}
