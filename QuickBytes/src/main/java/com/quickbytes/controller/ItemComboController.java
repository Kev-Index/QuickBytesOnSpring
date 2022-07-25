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

import com.quickbytes.model.Combo;
import com.quickbytes.model.Item;
import com.quickbytes.model.ItemCombo;
import com.quickbytes.repository.ComboRepository;
import com.quickbytes.repository.ItemComboRepository;
import com.quickbytes.repository.ItemRepository;


@RestController
public class ItemComboController{

	@Autowired
	ItemComboRepository itemComboRepository;
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	ComboRepository comboRepository;

	/* GET ORDER ITEMS BY ID */
	@GetMapping("/itemcombo/{id}")
	public ItemCombo getItemCombo(@PathVariable("id") Long id) {
		Optional<ItemCombo> itemCombo = itemComboRepository.findById(id);
		if (itemCombo.isPresent()) {
			return itemCombo.get();
		}
		throw new RuntimeException("ID is invalid");
	}
	
	/* GET ORDER ITEMS BY ORDER ID */
	@GetMapping("/item/iid/{iid}")
	public List<ItemCombo> getAllItemCombosByItemId(@PathVariable("iid") Long iid) {
		return itemComboRepository.getAllItemCombosByItemId(iid);
	}
	
	/* GET ORDER ITEMS BY ITEM ID */
	@GetMapping("/item/sid/{sid}")
	public List<ItemCombo> getAllItemCombosByComboId(@PathVariable("sid") Long sid) {
		return itemComboRepository.getAllItemCombosByComboId(sid);
	}
	
	/* GET ALL ORDER ITEMS */
	@GetMapping("/itemcombos")
	public List<ItemCombo> getAllItemCombos() {
		return itemComboRepository.findAll();
	}
	
	/* POST ORDER ITEM */
	@PostMapping("/itemcombo/{iid}/{sid}")
	public ItemCombo postItemCombo(@RequestBody ItemCombo itemCombo, @PathVariable("iid") Long iid, @PathVariable("sid") Long sid) {
		//get item
		Optional<Item> optionalItem = itemRepository.findById(iid);
		if (!optionalItem.isPresent()) {
			throw new RuntimeException("Item ID is invalid");
		}
		Item item = optionalItem.get();
		
		//get combo
		Optional<Combo> optionalCombo = comboRepository.findById(sid);
		if (!optionalCombo.isPresent()) {
			throw new RuntimeException("Combo ID is invalid");
		}
		Combo combo = optionalCombo.get();
		
		itemCombo.setItem(item);
		itemCombo.setCombo(combo);
		return itemComboRepository.save(itemCombo);	
	}
	
	/* UPDATE ORDER ITEM */
	@PutMapping("/itemcombo/{id}/{iid}/{sid}")
	public ItemCombo putItemCombo(@PathVariable("id") Long id, 
							@PathVariable("iid") Long iid, @PathVariable("sid") Long sid) {
		//get item
		ItemCombo itemCombo = getItemCombo(id);
		
		//get item
		Optional<Item> optionalItem = itemRepository.findById(iid);
		if (!optionalItem.isPresent()) {
			throw new RuntimeException("Item ID is invalid");
		}
		Item item = optionalItem.get();
		
		//get combo
		Optional<Combo> optionalCombo = comboRepository.findById(sid);
		if (!optionalCombo.isPresent()) {
			throw new RuntimeException("Combo ID is invalid");
		}
		Combo combo = optionalCombo.get();
		
		//update item
		itemCombo.setItem(item);
		itemCombo.setCombo(combo);
		return itemComboRepository.save(itemCombo);	
	}
	
	/* DELETE ORDER ITEM BY ID */
	@DeleteMapping("/itemcombo/{id}")
	public void deleteItemCombo(@PathVariable("id") Long id) {
		itemComboRepository.deleteById(id);
	}
	
	/* DELETE ALL ORDER ITEMS BY ORDER ID */
	@DeleteMapping("/itemcombo/iid/{iid}")
	public Item deleteAllItemCombosByItemId(@PathVariable("iid") Long iid) {
		return itemComboRepository.deleteAllItemCombosByItemId(iid);
	}
	
//	/* DELETE SOME ORDER ITEMS BY ITEM ID */
//	@DeleteMapping("/itemcombo/sid/{sid}")
//	public Item deleteItemCombosByComboId(@PathVariable("sid") Long sid) {
//		return itemComboRepository.deleteItemCombosByComboId(sid);
//	}
	
	/* DELETE ALL ORDER ITEMS BY ITEM ID */
	@DeleteMapping("/itemcombo/sid/{sid}")
	public Item deleteAllItemCombosByComboId(@PathVariable("sid") Long sid) {
		return itemComboRepository.deleteAllItemCombosByComboId(sid);
	}
	
	/* DELETE ALL ORDER ITEMS */
	@DeleteMapping("/itemcombos")
	public void deleteAllItemCombos() {
		itemComboRepository.deleteAll();
	}
}
