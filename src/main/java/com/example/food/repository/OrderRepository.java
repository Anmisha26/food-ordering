package com.example.food.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.food.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
