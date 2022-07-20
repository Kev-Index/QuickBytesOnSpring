package com.quickbytes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickbytes.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	@Query("select oi from OrderItem oi where oi.order.orderId=?1")
	OrderItem getOrderItemsByOrderId(Long oid);

	@Query("select oi from OrderItem oi where oi.item.itemId=?1")
	OrderItem getOrderItemsByItemId(Long iid);

}
