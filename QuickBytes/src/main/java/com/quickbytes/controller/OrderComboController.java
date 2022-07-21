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
import com.quickbytes.model.OrderCombo;
import com.quickbytes.repository.OrderRepository;
import com.quickbytes.repository.OrderComboRepository;

@RestController
public class OrderComboController {
	
	@Autowired
	OrderComboRepository orderComboRepository;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	ComboRepository comboRepository;
	
	/* GET ORDER COMBO BY ID */
	@GetMapping("/ordercombo/{id}")
	public OrderCombo getOrderCombo(@PathVariable("id") Long id) {
		Optional<OrderCombo> orderCombo = orderComboRepository.findById(id);
		if (orderCombo.isPresent()) {
			return orderCombo.get();
		}
		throw new RuntimeException("ID is invalid");
	}
	
	/* GET ALL ORDER COMBOS BY ORDER ID */
	@GetMapping("/ordercombo/oid/{oid}")
	public OrderCombo getAllOrderCombosByOrderId(@PathVariable("oid") Long oid) {
		return orderComboRepository.getAllOrderCombosByOrderId(oid);
	}
	
	/* GET ALL ORDER COMBOS BY COMBO ID */
	@GetMapping("/ordercombo/cid/{cid}")
	public OrderCombo getAllOrderCombosByComboId(@PathVariable("oid") Long oid) {
		return orderComboRepository.getAllOrderCombosByComboId(oid);
	}
	
	/* GET ALL ORDER COMBOS */
	@GetMapping("/ordercombos")
	public List<OrderCombo> getAllOrderCombos() {
		return orderComboRepository.findAll();
	}
	
	/* POST NEW ORDER COMBO */
	@PostMapping("/ordercombo/{oid}/{cid}")
	public OrderCombo postOrderCombo(@RequestBody OrderCombo orderCombo, @PathVariable("oid") Long oid, 
									@PathVariable("cid") Long cid) {
		//get order
		Optional<Order> optionalOrder = orderRepository.findById(oid);
		if (!optionalOrder.isPresent()) {
			throw new RuntimeException("Order ID is invalid");
		}
		Order order = optionalOrder.get();
		
		//get combo
		Optional<Combo> optionalCombo = comboRepository.findById(cid);
		if (!optionalCombo.isPresent()) {
			throw new RuntimeException("Combo ID is invalid");
		}
		Combo combo = optionalCombo.get();
		
		orderCombo.setOrder(order);
		orderCombo.setCombo(combo);
		return orderComboRepository.save(orderCombo);	
	}
	
	/* UPDATE EXISTING ORDER COMBO BY ID */
	@PutMapping("/ordercombo/{id}/{oid}/{cid}")
	public OrderCombo putOrderCombo(@PathVariable("id") Long id, 
							@PathVariable("oid") Long oid, @PathVariable("cid") Long cid) {
		//get order combo
		OrderCombo orderCombo = getOrderCombo(id);
		
		//get order
		Optional<Order> optionalOrder = orderRepository.findById(oid);
		if (!optionalOrder.isPresent()) {
			throw new RuntimeException("Order ID is invalid");
		}
		Order order = optionalOrder.get();
		
		//get combo
		Optional<Combo> optionalCombo = comboRepository.findById(cid);
		if (!optionalCombo.isPresent()) {
			throw new RuntimeException("Combo ID is invalid");
		}
		Combo combo = optionalCombo.get();
		
		//update order combo
		orderCombo.setOrder(order);
		orderCombo.setCombo(combo);
		return orderComboRepository.save(orderCombo);
	}
	
	/* DELETE ORDER COMBO BY ID */
	@DeleteMapping("/ordercombo/{id}")
	public void deleteOrderCombo(@PathVariable("id") Long id) {
		orderComboRepository.deleteById(id);
	}
	
	/* DELETE ALL ORDER COMBOS BY ORDER ID */
	@DeleteMapping("/ordercombo/oid/{oid}")
	public void deleteAllOrderCombosByOrderId(@PathVariable("oid") Long oid) {
		orderComboRepository.deleteAllOrderCombosByOrderId(oid);
	}
	
	/* DELETE SOME ORDER COMBOS BY COMBO ID */
	@DeleteMapping("/ordercombo/cid/{cid}/{amount}")
	public void deleteOrderCombosByComboId(@PathVariable("cid") Long cid, @PathVariable("amount") Integer amount) {
		orderComboRepository.deleteOrderCombosByComboId(cid,amount);
	}
	
	/* DELETE ALL ORDER COMBOS BY COMBO ID */
	@DeleteMapping("/ordercombo/cid/{cid}")
	public void deleteAllOrderCombosByComboId(@PathVariable("cid") Long cid) {
		orderComboRepository.deleteAllOrderCombosByComboId(cid);
	}
	
	/* DELETE ALL ORDER COMBOS */
	@DeleteMapping("/ordercombos")
	public void deleteAllOrderCombos() {
		orderComboRepository.deleteAll();
	}
}
