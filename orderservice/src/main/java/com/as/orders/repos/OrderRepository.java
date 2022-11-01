package com.as.orders.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.as.orders.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
