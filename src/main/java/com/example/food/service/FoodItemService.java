package com.example.food.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.food.model.FoodItem;
import com.example.food.repository.FoodItemRepository;

@Service
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    public FoodItemService(FoodItemRepository foodItemRepository) {
        this.foodItemRepository = foodItemRepository;
    }

    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    public FoodItem addFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    public FoodItem updateFoodItem(Long id, FoodItem foodItem) {
        FoodItem existingFoodItem = foodItemRepository.findById(id).orElseThrow();

        existingFoodItem.setName(foodItem.getName());
        existingFoodItem.setPrice(foodItem.getPrice());
        existingFoodItem.setRestaurant(foodItem.getRestaurant());

        return foodItemRepository.save(existingFoodItem);
    }

    public void deleteFoodItem(Long id) {
        foodItemRepository.deleteById(id);
    }
}