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
	import com.quickbytes.model.Vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.quickbytes.model.Combo;
import com.quickbytes.repository.ComboRepository;
	import com.quickbytes.repository.VendorRepository;

	@RestController
	public class ComboController {

		@Autowired
		private ComboRepository comboRepository;
		
		@Autowired
		private VendorRepository vendorRepository;

		@PostMapping("/combo/{vid}")
		public Combo postCombo(@RequestBody Combo combo, @PathVariable("vid") Long vid) {

			/* go to repo and fetch vendor by vid */
			Optional<Vendor> optionalV = vendorRepository.findById(vid);
			
			if(!optionalV.isPresent())
				throw new RuntimeException("Vendor ID is Invalid!!");
			
			Vendor vendor = optionalV.get();
			
			/* Attach category and vendor to the product */
			combo.setVendor(vendor);
			
			/* Save the product in the DB */
			return comboRepository.save(combo);
		}
		
		@GetMapping("/combos")
		public List<Combo> getAllCombos() {
			List<Combo> list =  comboRepository.findAll();
			return list;
		}
		
		@GetMapping("/combos/vendorId/{vid}")
		public List<Combo> getCombosByVendorId(@PathVariable("vid") Long vid){
			List<Combo> list = comboRepository.getCombosByVendorId(vid);
			return list;
		}
		
		@GetMapping("/combo/{name}")
		public Long getComboIdByName(@PathVariable("name") String name) {
			Optional<Combo> optional=comboRepository.findByname(name);
			if(optional.isPresent())
				return optional.get().getComboId();
			throw new RuntimeException("Name is invalid");
		}
		
		@PutMapping("/combo/{cid}")
		public Combo updateCombo(@PathVariable("cid") Long cid, @RequestBody Combo newCombo) {
			Optional<Combo> optional=comboRepository.findById(cid);
			if (optional.isPresent()) {
				Combo existingCombo=optional.get();
				existingCombo.setName(newCombo.getName());
				existingCombo.setPrice(newCombo.getPrice());
				existingCombo.setVendor(existingCombo.getVendor());
				return comboRepository.save(existingCombo);
			}
			else
				throw new RuntimeException("ID is invalid");	
			}
	
		@DeleteMapping("/combo/{cid}")
		public void deleteCombo(@PathVariable("cid") Long cid) {
			comboRepository.deleteById(cid);
		}
		
	}
