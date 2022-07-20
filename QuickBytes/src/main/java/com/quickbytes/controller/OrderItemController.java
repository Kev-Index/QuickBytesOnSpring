package com.quickbytes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

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
	
	/* GET ORDER ITEMS BY ID */
	
	/* GET ORDER ITEMS BY ORDER ID */
	
	/* GET ORDER ITEMS BY ITEM ID */
	
	/* POST ORDER ITEM */
	
	/* UPDATE ORDER ITEM */
	
	/* DELETE ORDER ITEM BY ID */
	
	/* DELETE ALL ORDER ITEMS BY ORDER ID */
	
	/* DELETE ORDER ITEMS BY ITEM ID */
	
	/* DELETE ALL ORDER ITEMS BY ITEM ID */
	
	/* DELETE ALL ORDER ITEMS */
}
