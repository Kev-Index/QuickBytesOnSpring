package com.quickbytes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickbytes.enums.Order_Status;
import com.quickbytes.model.Order;
import com.quickbytes.repository.OrderRepository;

@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	private CustomerRepository customerRepository;
	private VendorRepository vendorRepository;
	
	/* GET ALL ORDERS */
	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}
	
	/* GET ORDER BY ID */
	@GetMapping("/order/{id}")
	public Order getOrder(@PathVariable("id") Long id) {
		Optional<Order> order = orderRepository.findById(id);
		if (order.isPresent()) {
			return order.get();
		}
		throw new RuntimeException("ID is invalid");
	}
	
	/* GET ORDERS BY CUSTOMER ID */
	@GetMapping("/order/cid/{cid}")
	public Order getOrdersByCustomerId(@PathVariable("cid") Long cid) {
		return orderRepository.getOrdersByCustomerId(cid);
	}
	
	/* GET ORDERS BY VENDOR ID */
	@GetMapping("/order/vid/{vid}")
	public Order getOrdersByVendorId(@PathVariable("vid") Long vid) {
		return orderRepository.getOrdersByVendorId(vid);
	}
	
	/* POST NEW ORDER */
	@PostMapping("/order/{cid}/{vid}")
	public Order postOrder(@RequestBody Order order, @PathVariable("cid") Long cid, @PathVariable("vid") Long vid) {
		//get customer
		Optional<Customer> optionalCustomer = customerRepository.findById(cid);
		if (!optionalCustomer.isPresent()) {
			throw new RuntimeException("Customer ID is invalid");
		}
		Customer customer = optionalCustomer.get();
		
		//get vendor
		Optional<Vendor> optionalVendor = vendorRepository.findById(cid);
		if (!optionalVendor.isPresent()) {
			throw new RuntimeException("Vendor ID is invalid");
		}
		Vendor vendor = optionalVendor.get();
		
		order.setCustomer(customer);
		order.setVendor(vendor);
		return orderRepository.save(order);	
	}
	
	/* UPDATE EXISTING ORDER */
	@PutMapping("/order/{id}/{cid}/{vid}")
	public Order putOrder(@RequestBody Order newOrder, @PathVariable("id") Long id, @PathVariable("cid") Long cid, @PathVariable("vid") Long vid) {
		//get order
		Order order = getOrder(id);
		
		//get customer
		Optional<Customer> optionalCustomer = customerRepository.findById(cid);
		if (!optionalCustomer.isPresent()) {
			throw new RuntimeException("Customer ID is invalid");
		}
		Customer customer = optionalCustomer.get();
		
		//get vendor
		Optional<Vendor> optionalVendor = vendorRepository.findById(cid);
		if (!optionalVendor.isPresent()) {
			throw new RuntimeException("Vendor ID is invalid");
		}
		Vendor vendor = optionalVendor.get();
		
		//update order
		order.setTotalPrice(newOrder.getTotalPrice());
		order.setStatus(newOrder.getStatus());
		order.setOrderTime(newOrder.getOrderTime());
		order.setEndTime(newOrder.getEndTime());
		order.setCustomer(customer);
		order.setVendor(vendor);
		return orderRepository.save(order);	
	}
	
	/* UPDATE EXISTING ORDER'S TOTAL PRICE */
	@PutMapping("/order/price/{id}/{price}")
	public Order putOrderPrice(@PathVariable("id") Long id, @PathVariable("price") Float price) {
		//get order
		Order order = getOrder(id);
		
		//update order
		order.setTotalPrice(price);
		return orderRepository.save(order);	
	}
	
	/* PEND ORDER TO VENDOR */
	@PutMapping("/order/send/{id}")
	public Order pendOrder(@PathVariable("id") Long id) {
		//get order
				Order order = getOrder(id);
				
				//update order
				order.setStatus(Order_Status.PENDING);
				return orderRepository.save(order);	
	}
	
	/* APPROVE ORDER */
	@PutMapping("/order/approve/{id}")
	public Order approveOrder(@PathVariable("id") Long id) {
		//get order
		Order order = getOrder(id);
		
		//update order
		order.setStatus(Order_Status.APPROVED);
		return orderRepository.save(order);	
	}
	
	/* DENY ORDER */
	@PutMapping("/order/deny/{id}")
	public Order denyOrder(@PathVariable("id") Long id) {
		//get order
		Order order = getOrder(id);
		
		//update order
		order.setStatus(Order_Status.DENIED);
		return orderRepository.save(order);	
	}
	
	/* UPDATE EXISTING ORDER'S ORDER TIME */
	@PutMapping("/order/ordertime/{id}/{ordertime}")
	public Order putOrderOrderTime(@PathVariable("id") Long id, @PathVariable("ordertime") String ordertime) {
		//get order
		Order order = getOrder(id);
		
		//update order
		order.setEndTime(ordertime);
		return orderRepository.save(order);	
	}
	
	/* UPDATE EXISTING ORDER'S END TIME */
	@PutMapping("/order/endtime/{id}/{endtime}")
	public Order putOrderEndTime(@PathVariable("id") Long id, @PathVariable("endtime") String endtime) {
		//get order
		Order order = getOrder(id);
		
		//update order
		order.setEndTime(endtime);
		return orderRepository.save(order);	
	}
	
	/* DELETE EXISTING ORDER */
	@DeleteMapping("/order/{id}")
	public void deleteOrder(@PathVariable("id") Long id) {
		orderRepository.deleteById(id);
	}
	
	/* DELETE ALL ORDERS */
	@DeleteMapping("/orders")
	public void deleteOrders() {
		orderRepository.deleteAll();
	}
	
}
