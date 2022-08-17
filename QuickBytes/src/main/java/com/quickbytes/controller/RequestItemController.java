package com.quickbytes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quickbytes.model.Request;
import com.quickbytes.model.Item;
import com.quickbytes.model.RequestItem;
import com.quickbytes.repository.ItemRepository;
import com.quickbytes.repository.RequestItemRepository;
import com.quickbytes.repository.RequestRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class RequestItemController {

	@Autowired
	RequestItemRepository requestItemRepository;
	
	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	ItemRepository itemRepository;

	/* POST ORDER ITEM */
	@PostMapping("/requestitem/{rid}/{iid}")
	public RequestItem postRequestItem(@RequestBody RequestItem requestItem, @PathVariable("rid") Long rid, @PathVariable("iid") Long iid) {
		//get request
		Optional<Request> optionalRequest = requestRepository.findById(rid);
		if (!optionalRequest.isPresent()) {
			throw new RuntimeException("Order ID is invalid");
		}
		Request request = optionalRequest.get();
		
		//get item
		Optional<Item> optionalItem = itemRepository.findById(iid);
		if (!optionalItem.isPresent()) {
			throw new RuntimeException("Item ID is invalid");
		}
		Item item = optionalItem.get();
		
		requestItem.setRequest(request);
		requestItem.setItem(item);
		return requestItemRepository.save(requestItem);	
	}
	
	/* GET REQUEST ITEMS BY ID 
	 * NEEDS DTO CONVERSION */
	@GetMapping("/requestitem/{id}")
	public RequestItem getRequestItem(@PathVariable("id") Long id) {
		Optional<RequestItem> requestItem = requestItemRepository.findById(id);
		if (requestItem.isPresent()) {
			return requestItem.get();
		}
		throw new RuntimeException("ID is invalid");
	}
	
	/* GET REQUEST ITEMS BY REQUEST ID 
	 * NEEDS DTO CONVERSION */
	@GetMapping("/requestitem/rid/{rid}")
	public List<RequestItem> getAllRequestItemsByRequestId(@PathVariable("rid") Long rid) {
		return requestItemRepository.getAllRequestItemsByRequestId(rid);
	}
	
	/* GET REQUEST ITEMS BY ITEM ID 
	 * NEEDS DTO CONVERSION */
	@GetMapping("/requestitem/iid/{iid}")
	public List<RequestItem> getAllRequestItemsByItemId(@PathVariable("iid") Long iid) {
		return requestItemRepository.getAllRequestItemsByItemId(iid);
	}

	/* GET ALL REQUEST ITEMS 
	 * NEEDS DTO CONVERSION */
	@GetMapping("/requestitems")
	public List<RequestItem> getAllRequestItems(@RequestParam(name="page",required=false,defaultValue="0") Integer page, 
			@RequestParam(name="size",required=false,defaultValue="10000") Integer size) {
		Pageable pageable = PageRequest.of(page, size);	
		return requestItemRepository.findAll(pageable).getContent();
	}
	
	/* UPDATE ORDER ITEM */
	@PutMapping("/requestitem/{id}/{rid}/{iid}")
	public RequestItem putRequestItem(@PathVariable("id") Long id, 
							@PathVariable("rid") Long rid, @PathVariable("iid") Long iid) {
		//get request item
		RequestItem requestItem = getRequestItem(id);
		
		//get request
		Optional<Request> optionalRequest = requestRepository.findById(rid);
		if (!optionalRequest.isPresent()) {
			throw new RuntimeException("Order ID is invalid");
		}
		Request request = optionalRequest.get();
		
		//get item
		Optional<Item> optionalItem = itemRepository.findById(iid);
		if (!optionalItem.isPresent()) {
			throw new RuntimeException("Item ID is invalid");
		}
		Item item = optionalItem.get();
		
		//update request item
		requestItem.setRequest(request);
		requestItem.setItem(item);
		return requestItemRepository.save(requestItem);	
	}
	
	/* DELETE REQUEST ITEM BY ID */
	@DeleteMapping("/requestitem/{id}")
	public void deleteRequestItem(@PathVariable("id") Long id) {
		requestItemRepository.deleteById(id);
	}
	
	/* DELETE ALL REQUEST ITEMS BY REQUEST ID */
	@DeleteMapping("/requestitem/rid/{rid}")
	public void deleteAllRequestItemsByRequestId(@PathVariable("rid") Long rid) {
		requestItemRepository.deleteAllRequestItemsByRequestId(rid);
	}
	
//	/* DELETE SOME REQUEST ITEMS BY ITEM ID */
//	@DeleteMapping("/requestitem/iid/{iid}/{amount}")
//	public void deleteRequestItemsByItemId(@PathVariable("iid") Long iid, @PathVariable("amount") Integer amount) {
//		requestItemRepository.deleteRequestItemsByItemId(iid,amount);
//	}
	
	/* DELETE ALL REQUEST ITEMS BY ITEM ID */
	@DeleteMapping("/requestitem/iid/{iid}")
	public void deleteAllRequestItemsByItemId(@PathVariable("iid") Long iid) {
		requestItemRepository.deleteAllRequestItemsByItemId(iid);
	}
	
	/* DELETE ALL REQUEST ITEMS BY REQUEST & ITEM ID */
	@DeleteMapping("/requestitem/rid/iid/{rid}/{iid}")
	public void deleteAllRequestItemsByRequestAndItemId(@PathVariable("rid") Long rid,@PathVariable("iid") Long iid) {
		requestItemRepository.deleteAllRequestItemsByRequestAndItemId(rid,iid);
	}
	
	/* DELETE ALL REQUEST ITEMS */
	@DeleteMapping("/requestitems")
	public void deleteAllRequestItems() {
		requestItemRepository.deleteAll();
	}
}
