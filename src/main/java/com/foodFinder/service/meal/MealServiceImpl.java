package com.foodFinder.service.meal;

import com.foodFinder.exceptions.ObjectNotFoundException;
import com.foodFinder.model.meal.Meal;
import com.foodFinder.model.meal.MealDTO;
import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.repository.MealRepository;
import com.foodFinder.repository.RestaurantRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MealServiceImpl implements MealService {

    private MealRepository mealRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    public MealServiceImpl(MealRepository mealRepository) {

        this.mealRepository = mealRepository;
    }

    @Override
    public void save(MealDTO mealDTO, Long id) throws ParseException {
        Meal meal = convertToEntity(mealDTO);

        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
        if(restaurant.isPresent()){
            meal.setRestaurant(restaurant.get());
            mealRepository.save(meal);
        }else{
            throw new ObjectNotFoundException("Unable to create meal. Restaurant by id= "+id+" not found");
        }
    }

    @Override
    public void save(Meal meal) {
        mealRepository.save(meal);
    }

    @Override
    public void updateMeal(MealDTO mealDTO, Long id) {
        Optional<Meal> byId = mealRepository.findById(id);
        if (byId.isPresent()) {
            Meal meal = byId.get();
            meal.setMealName(mealDTO.getMealName());
            meal.setMealDescription(mealDTO.getMealDescription());
            meal.setMealPrice(mealDTO.getMealPrice());
            mealRepository.save(meal);

        } else {
            throw new ObjectNotFoundException("Meal by id= " + id + " not found");
        }
    }

    @Override
    public MealDTO findById(Long id) {
        Optional<Meal> byId = mealRepository.findById(id);
        if (byId.isPresent()) {
            return byId.map(this::convertToDto).orElseThrow(RuntimeException::new);
        } else {
            throw new ObjectNotFoundException("Meal by id= "+id+" not found");
        }
    }

    @Override
    public Set<MealDTO> findAll() {
        Set<Meal> set = new HashSet<>();
        mealRepository.findAll().iterator().forEachRemaining(set::add);
        return set.stream().map(this::convertToDto).collect(Collectors.toSet());
    }

    @Override
    public Set<MealDTO> findByRestaurantId(Long id) {
        Set<Meal> byRestaurantId = mealRepository.findByRestaurantId(id);
        if (byRestaurantId.size() != 0) {
            return byRestaurantId.stream().map(this::convertToDto).collect(Collectors.toSet());
        } else {
            throw new ObjectNotFoundException("No meals found for Restaurant by id= " + id + ". Check if Restaurant exists.");
        }
    }

    @Override
    public void delete(Long id) {
        Meal meal = mealRepository.findById(id).orElse(new Meal("0", "0", 0L,0L));
        mealRepository.delete(meal);
    }

    private MealDTO convertToDto(Meal meal) {
        return modelMapper.map(meal, MealDTO.class);
    }

    private Meal convertToEntity(MealDTO mealDTO) throws ParseException {
        Meal meal = modelMapper.map(mealDTO, Meal.class);
        return meal;
    }
}
