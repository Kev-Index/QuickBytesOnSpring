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
import com.quickbytes.model.OrderSet;
import com.quickbytes.repository.OrderRepository;
import com.quickbytes.repository.OrderSetRepository;

@RestController
public class OrderSetController {
	
	@Autowired
	OrderSetRepository orderSetRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	SetRepository setRepository;
	
	/* GET ORDER SET BY ID */
	@GetMapping("/orderset/{id}")
	public OrderSet getOrderSet(@PathVariable("id") Long id) {
		Optional<OrderSet> orderSet = orderSetRepository.findById(id);
		if (orderSet.isPresent()) {
			return orderSet.get();
		}
		throw new RuntimeException("ID is invalid");
	}
	
	/* GET ALL ORDER SETS BY ORDER ID */
	@GetMapping("/orderset/oid/{oid}")
	public OrderSet getAllOrderSetsByOrderId(@PathVariable("oid") Long oid) {
		return orderSetRepository.getAllOrderSetsByOrderId(oid);
	}
	
	/* GET ALL ORDER SETS BY SET ID */
	@GetMapping("/orderset/sid/{sid}")
	public OrderSet getAllOrderSetsBySetId(@PathVariable("oid") Long oid) {
		return orderSetRepository.getAllOrderSetsBySetId(oid);
	}
	
	/* GET ALL ORDER SETS */
	@GetMapping("/ordersets")
	public List<OrderSet> getAllOrderSets() {
		return orderSetRepository.findAll();
	}
	
	/* POST NEW ORDER SET */
	@PostMapping("/orderset/{oid}/{sid}")
	public OrderSet postOrderSet(@RequestBody OrderSet orderSet, @PathVariable("oid") Long oid, 
									@PathVariable("sid") Long sid) {
		//get order
		Optional<Order> optionalOrder = orderRepository.findById(oid);
		if (!optionalOrder.isPresent()) {
			throw new RuntimeException("Order ID is invalid");
		}
		Order order = optionalOrder.get();
		
		//get set
		Optional<Set> optionalSet = setRepository.findById(sid);
		if (!optionalSet.isPresent()) {
			throw new RuntimeException("Set ID is invalid");
		}
		Set set = optionalSet.get();
		
		orderSet.setOrder(order);
		orderSet.setSet(set);
		return orderSetRepository.save(orderSet);	
	}
	
	/* UPDATE EXISTING ORDER SET BY ID */
	@PutMapping("/orderset/{id}/{oid}/{sid}")
	public OrderSet putOrderSet(@PathVariable("id") Long id, 
							@PathVariable("oid") Long oid, @PathVariable("sid") Long sid) {
		//get order set
		OrderSet orderSet = getOrderSet(id);
		
		//get order
		Optional<Order> optionalOrder = orderRepository.findById(oid);
		if (!optionalOrder.isPresent()) {
			throw new RuntimeException("Order ID is invalid");
		}
		Order order = optionalOrder.get();
		
		//get set
		Optional<Set> optionalSet = setRepository.findById(sid);
		if (!optionalSet.isPresent()) {
			throw new RuntimeException("Set ID is invalid");
		}
		Set set = optionalSet.get();
		
		//update order set
		orderSet.setOrder(order);
		orderSet.setSet(set);
		return orderSetRepository.save(orderSet);
	}
	
	/* DELETE ORDER SET BY ID */
	@DeleteMapping("/orderset/{id}")
	public void deleteOrderSet(@PathVariable("id") Long id) {
		orderSetRepository.deleteById(id);
	}
	
	/* DELETE ALL ORDER SETS BY ORDER ID */
	@DeleteMapping("/orderset/oid/{oid}")
	public void deleteAllOrderSetsByOrderId(@PathVariable("oid") Long oid) {
		orderSetRepository.deleteAllOrderSetsByOrderId(oid);
	}
	
	/* DELETE SOME ORDER SETS BY SET ID */
	@DeleteMapping("/orderset/sid/{sid}/{amount}")
	public void deleteOrderSetsBySetId(@PathVariable("sid") Long sid, @PathVariable("amount") Integer amount) {
		orderSetRepository.deleteOrderSetsBySetId(sid,amount);
	}
	
	/* DELETE ALL ORDER SETS BY SET ID */
	@DeleteMapping("/orderset/sid/{sid}")
	public void deleteAllOrderSetsBySetId(@PathVariable("sid") Long sid) {
		orderSetRepository.deleteAllOrderSetsBySetId(sid);
	}
	
	/* DELETE ALL ORDER SETS */
	@DeleteMapping("/ordersets")
	public void deleteAllOrderSets() {
		orderSetRepository.deleteAll();
	}
}
