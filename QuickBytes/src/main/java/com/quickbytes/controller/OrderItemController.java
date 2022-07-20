package com.quickbytes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.quickbytes.model.Order;
import com.quickbytes.model.OrderItem;
import com.quickbytes.repository.OrderItemRepository;
import com.quickbytes.repository.OrderRepository;

@RestController
public class OrderItemController {

	@Autowired
	OrderItemRepository orderItemRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ItemRepository itemRepository;

	/* GET ALL ORDER ITEMS */
	@GetMapping("/orderitems")
	public List<OrderItem> getAllOrderItems() {
		return orderItemRepository.findAll();
	}
	
	/* GET ORDER ITEMS BY ID */
	@GetMapping("/orderitem/{id}")
	public OrderItem getOrderItem(@PathVariable("id") Long id) {
		Optional<OrderItem> orderItem = orderItemRepository.findById(id);
		if (orderItem.isPresent()) {
			return orderItem.get();
		}
		throw new RuntimeException("ID is invalid");
	}
	
	/* GET ORDER ITEMS BY ORDER ID */
	@GetMapping("/order/oid/{oid}")
	public OrderItem getOrderItemsByOrderId(@PathVariable("oid") Long oid) {
		return orderItemRepository.getOrderItemsByOrderId(oid);
	}
	
	/* GET ORDER ITEMS BY ITEM ID */
	@GetMapping("/order/iid/{iid}")
	public OrderItem getOrderItemsByItemId(@PathVariable("iid") Long iid) {
		return orderItemRepository.getOrderItemsByItemId(iid);
	}
	
	/* POST ORDER ITEM */
	
	/* UPDATE ORDER ITEM */
	
	/* DELETE ORDER ITEM BY ID */
	
	/* DELETE ALL ORDER ITEMS BY ORDER ID */
	
	/* DELETE ORDER ITEMS BY ITEM ID */
	
	/* DELETE ALL ORDER ITEMS BY ITEM ID */
	
	/* DELETE ALL ORDER ITEMS */
}
