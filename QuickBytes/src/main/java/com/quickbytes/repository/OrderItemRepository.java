package com.quickbytes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quickbytes.model.Order;
import com.quickbytes.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

	@Query("select oi from OrderItem oi where oi.order.orderId=?1")
	OrderItem getOrderItemsByOrderId(Long oid);

	@Query("select oi from OrderItem oi where oi.item.itemId=?1")
	OrderItem getOrderItemsByItemId(Long iid);

	@Query("delete oi from OrderItem oi where oi.order.orderId=?1")
	Order deleteOrderItemsByOrderId(Long oid);

	@Query("delete oi from OrderItem oi where oi.item.itemId=?1 limit ?2")
	Order deleteOrderItemsByItemId(Long iid, Integer amount);

	@Query("delete oi from OrderItem oi where oi.item.itemId=?1")
	Order deleteOrderItemsByItemId(Long iid);

}
