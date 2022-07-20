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
	ItemRepository ir;
	
	@Autowired
	VendorRepository vr;
	
	@PostMapping("/item/{vid}")
	public void postItem(@RequestBody Item i,@PathVariable("vid") Long vid) {
		//use JpaRepository Interface
		//has lot of precreated methods for db interaction
		Optional<Vendor> ov = vr.findById(vid);
		if(!ov.isPresent()) {
			throw new RuntimeException("invalid category id");
		}
		i.setVendor(ov.get());
		ir.save(i);
	}
	
	@GetMapping("/item")
	public List<Item> getAllItems() {
		List<Item> l= ir.findAll();
		return l;
	}
	
	@GetMapping("/item/single/{id}")
	public Item getSingleItemById(@PathVariable("id") Long id) {
		Optional<Item>o =ir.findById(id);
		if(o.isPresent()) {
			return o.get();
		}
		else {
			throw new RuntimeException("ID is invalid");
		}
	}
	
	@PutMapping("/item/{id}")
	public Item updateitem(@PathVariable("id") Long id,@RequestBody Item newItem ) {
		Optional<Item> o = ir.findById(id);
		if(o.isPresent()) {
			Item ei = o.get();
			ei.setName(newItem.getName());
			ei.setPrice(newItem.getPrice());
			ei.setQuantity(newItem.getQuantity());
			return ir.save(ei);
		}
		else {
			throw new RuntimeException("ID is invalid");
		}
	}
	@GetMapping("/item/vendor/{vid}")
	public List<Item> getProductsByAccountId(@PathVariable("vid") Long vid) {
		return ir.findByAccountId(vid);
	}
}
