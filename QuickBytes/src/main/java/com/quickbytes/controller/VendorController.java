package com.quickbytes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickbytes.model.Vendor;
import com.quickbytes.repository.VendorRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class VendorController {
	@Autowired
	VendorRepository vendorRepository;
	
	//give 
	@PostMapping("/vendor")
	public void postVendor(@RequestBody Vendor v) {
		//use JpaRepository Interface
		//has lot of precreated methods for db interaction
		vendorRepository.save(v);
	}
	
	@GetMapping("/vendors")
	public List<Vendor> getVendors() {
		List<Vendor> lv= vendorRepository.findAll();
		return lv;
	}
}
