package com.example.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.food.model.FoodItem;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long> {
}