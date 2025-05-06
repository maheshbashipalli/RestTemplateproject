package com.vcube.Order_service.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcube.Order_service.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
