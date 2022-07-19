package com.quickbytes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.quickbytes.repository.OrderRepository;

@RestController
public class OrderController {
	
	@Autowired
	private OrderRepository or;
	private CustomerRepository cr;
	private VendorRepository vr;
	
	/* GET ALL ORDERS */
	
	/* GET ORDER BY ID */
	
	/* GET ORDERS BY CUSTOMER ID */
	
	/* GET ORDERS BY VENDOR ID */
	
	/* POST NEW ORDER */
	
	/* PUT EXISTING ORDER */
	
	/* DELETE EXISTING ORDER */
	
	/* DELETE ALL ORDERS */
}
