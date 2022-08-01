package com.quickbytes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickbytes.model.Vendor;
import com.quickbytes.repository.VendorRepository;

@RestController
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
}
