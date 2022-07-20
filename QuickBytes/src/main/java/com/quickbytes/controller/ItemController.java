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

import com.quickbytes.model.Item;
import com.quickbytes.model.Vendor;
import com.quickbytes.repository.ItemRepository;
import com.quickbytes.repository.VendorRepository;

@RestController
public class ItemController {
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	VendorRepository vendorRepository;
	
	@PostMapping("/item/{vid}")
	public void postItem(@RequestBody Item i,@PathVariable("vid") Long vid) {
		//use JpaRepository Interface
		//has lot of precreated methods for db interaction
		Optional<Vendor> optionalVendor = vendorRepository.findById(vid);
		if(!optionalVendor.isPresent()) {
			throw new RuntimeException("invalid vendor id");
		}
		i.setVendor(optionalVendor.get());
		itemRepository.save(i);
	}
	
	@GetMapping("/items")
	public List<Item> getAllItems() {
		List<Item> list= itemRepository.findAll();
		return list;
	}
	
	@GetMapping("/item/{id}")
	public Item getSingleItemById(@PathVariable("id") Long id) {
		Optional<Item>optional =itemRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new RuntimeException("ID is invalid");
		}
	}
	
	@PutMapping("/item/{id}")
	public Item updateItem(@PathVariable("id") Long id,@RequestBody Item newItem ) {
		Optional<Item> optional = itemRepository.findById(id);
		if(optional.isPresent()) {
			Item ei = optional.get();
			ei.setName(newItem.getName());
			ei.setPrice(newItem.getPrice());
			ei.setQuantity(newItem.getQuantity());
			return itemRepository.save(ei);
		}
		else {
			throw new RuntimeException("ID is invalid");
		}
	}
	@GetMapping("/item/vendor/{vid}")
	public List<Item> getProductsByVendorId(@PathVariable("vid") Long vid) {
		return itemRepository.findByVendorId(vid);
	}
}
