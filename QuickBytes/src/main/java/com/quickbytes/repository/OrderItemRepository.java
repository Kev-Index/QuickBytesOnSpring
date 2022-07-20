package com.quickbytes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickbytes.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
