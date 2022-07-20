package com.quickbytes.controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@GetMapping("/orderitem/oid/{oid}")
	public OrderItem getAllOrderItemsByOrderId(@PathVariable("oid") Long oid) {
		return orderItemRepository.getAllOrderItemsByOrderId(oid);
	}
	
	/* GET ORDER ITEMS BY ITEM ID */
	@GetMapping("/orderitem/iid/{iid}")
	public OrderItem getAllOrderItemsByItemId(@PathVariable("iid") Long iid) {
		return orderItemRepository.getAllOrderItemsByItemId(iid);
	}
	
	/* GET ALL ORDER ITEMS */
	@GetMapping("/orderitems")
	public List<OrderItem> getAllOrderItems() {
		return orderItemRepository.findAll();
	}
	
	/* POST ORDER ITEM */
	@PostMapping("/orderitem/{oid}/{iid}")
	public OrderItem postOrderItem(@RequestBody OrderItem orderItem, @PathVariable("oid") Long oid, @PathVariable("iid") Long iid) {
		//get order
		Optional<Order> optionalOrder = orderRepository.findById(oid);
		if (!optionalOrder.isPresent()) {
			throw new RuntimeException("Order ID is invalid");
		}
		Order order = optionalOrder.get();
		
		//get item
		Optional<Item> optionalItem = itemRepository.findById(iid);
		if (!optionalItem.isPresent()) {
			throw new RuntimeException("Item ID is invalid");
		}
		Item item = optionalItem.get();
		
		orderItem.setOrder(order);
		orderItem.setItem(item);
		return orderItemRepository.save(orderItem);	
	}
	
	/* UPDATE ORDER ITEM */
	@PutMapping("/orderitem/{id}/{oid}/{iid}")
	public OrderItem putOrderItem(@PathVariable("id") Long id, 
							@PathVariable("oid") Long oid, @PathVariable("iid") Long iid) {
		//get order item
		OrderItem orderItem = getOrderItem(id);
		
		//get order
		Optional<Order> optionalOrder = orderRepository.findById(oid);
		if (!optionalOrder.isPresent()) {
			throw new RuntimeException("Order ID is invalid");
		}
		Order order = optionalOrder.get();
		
		//get item
		Optional<Item> optionalItem = itemRepository.findById(iid);
		if (!optionalItem.isPresent()) {
			throw new RuntimeException("Item ID is invalid");
		}
		Item item = optionalItem.get();
		
		//update order
		orderItem.setOrder(order);
		orderItem.setItem(item);
		return orderItemRepository.save(orderItem);	
	}
	
	/* DELETE ORDER ITEM BY ID */
	@DeleteMapping("/orderitem/{id}")
	public void deleteOrderItem(@PathVariable("id") Long id) {
		orderItemRepository.deleteById(id);
	}
	
	/* DELETE ALL ORDER ITEMS BY ORDER ID */
	@DeleteMapping("/orderitem/oid/{oid}")
	public Order deleteAllOrderItemsByOrderId(@PathVariable("oid") Long oid) {
		return orderItemRepository.deleteAllOrderItemsByOrderId(oid);
	}
	
	/* DELETE SOME ORDER ITEMS BY ITEM ID */
	@DeleteMapping("/orderitem/iid/{iid}/{amount}")
	public Order deleteOrderItemsByItemId(@PathVariable("iid") Long iid, @PathVariable("amount") Integer amount) {
		return orderItemRepository.deleteOrderItemsByItemId(iid,amount);
	}
	
	/* DELETE ALL ORDER ITEMS BY ITEM ID */
	@DeleteMapping("/orderitem/iid/{iid}")
	public Order deleteAllOrderItemsByItemId(@PathVariable("iid") Long iid) {
		return orderItemRepository.deleteAllOrderItemsByItemId(iid);
	}
	
	/* DELETE ALL ORDER ITEMS */
	@DeleteMapping("/orderitems")
	public void deleteAllOrderItems() {
		orderItemRepository.deleteAll();
	}
}
