package com.quickbytes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quickbytes.dto.ItemDto;
import com.quickbytes.model.Item;
import com.quickbytes.model.Vendor;
import com.quickbytes.repository.ItemRepository;
import com.quickbytes.repository.VendorRepository;


@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class ItemController {
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	VendorRepository vendorRepository;
	
	@PostMapping("/item/{vid}")
	public Item postItem(@RequestBody ItemDto itemDto) {
		//use JpaRepository Interface
		//has lot of precreated methods for db interaction
		
		Item item = new Item();
		item.setName(itemDto.getName());
		item.setPrice(itemDto.getPrice());
		item.setQuantity(itemDto.getQuantity());
		Optional<Vendor> optionalVendor = vendorRepository.findById(itemDto.getVendorId());
		if(!optionalVendor.isPresent()) {
			throw new RuntimeException("invalid vendor id");
		}
		item.setVendor(optionalVendor.get());
		return itemRepository.save(item);
	}
	
	@GetMapping("/items")
	public List<Item> getAllItems() {
		List<Item> list= itemRepository.findAll();
		return list;
	}
	
	@GetMapping("/item/{id}")
	public ItemDto getSingleItemById(@PathVariable("id") Long id) {
		ItemDto dto = new ItemDto();
		Optional<Item>optional =itemRepository.findById(id);
		if(optional.isPresent()) {
			Item i = optional.get();
			dto.setItemId(id);
			dto.setName(i.getName());
			dto.setQuantity(i.getQuantity());
			dto.setPrice(i.getPrice());
			dto.setVendorId(i.getVendor().getVendorId());
			return dto;
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
	public List<Item> getItemsByVendorId(@PathVariable("vid") Long vid){
		return this.itemRepository.findByVendorId(vid);
	}
}
