package com.foodFinder.service.restaurant;

import com.foodFinder.model.restaurant.Restaurant;
import com.foodFinder.repository.RestaurantRepository;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class RestaurantServiceImpl implements RestaurantService {


    private final RestaurantRepository repository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Restaurant restaurant) {
        repository.save(restaurant);
    }

    @Override
    public void update(Restaurant restaurant) {
    }

    @Override
    public void delete(Restaurant restaurant) {
        repository.delete(restaurant);
    }

    @Override
    public Set<Restaurant> findAll() {
        Iterable<Restaurant> all = repository.findAll();
        Set<Restaurant> set = new HashSet<>();
        all.iterator().forEachRemaining(set::add);
        return set;
    }

    @Override
    public Optional<Restaurant> findById(Long id) {
        return repository.findById(id);
    }
}
