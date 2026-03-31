package com.example.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.food.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}