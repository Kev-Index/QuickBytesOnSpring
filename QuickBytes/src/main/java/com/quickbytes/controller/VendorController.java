package com.quickbytes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickbytes.model.Vendor;
import com.quickbytes.repository.UserRepository;
import com.quickbytes.repository.VendorRepository;

@RestController
public class VendorController {

		@Autowired
		private VendorRepository vendorRepository;
		
		
		@Autowired
		private PasswordEncoder passwordEncoder; 
		
		@PostMapping("/vendor")
		public void postVendor(@RequestBody Vendor vendor) {
			vendorRepository.save(vendor);
		}
		
		@GetMapping("/vendors")
		public List<Vendor> getAllVendors(){
			return vendorRepository.findAll();
		}
		
		@GetMapping("/vendor/single/{vid}")
		public Vendor getVendorById(@PathVariable("vid") Long vid) {
			Optional<Vendor> optional=vendorRepository.findById(vid);
			if (optional.isPresent())
				return optional.get();
			else
				throw new RuntimeException("ID is invalid");
		}

		@GetMapping("/vendor/single/user/{uid}")
		public Vendor getVendorByUserId(@PathVariable("uid") Long uid) {
			Optional<Vendor> optional=vendorRepository.findByUserId(uid);
			if (optional.isPresent())
				return optional.get();
			else
				throw new RuntimeException("ID is invalid");
		}
		
		@DeleteMapping("/vendor/{vid}")
		public void deleteVendor(@PathVariable("vid") Long vid) {
			vendorRepository.deleteById(vid);
		}
		
		@PutMapping("/vendor/{vid}")
		public Vendor updateVendor(@PathVariable("vid") Long vid, @RequestBody Vendor newVendor) {
			Optional<Vendor> optional=vendorRepository.findById(vid);
			if (optional.isPresent()) {
				Vendor existingVendor=optional.get();
				existingVendor.setName(newVendor.getName());
				existingVendor.setBusinessId(newVendor.getBusinessId());
				return vendorRepository.save(existingVendor);
			}
			else
				throw new RuntimeException("ID is invalid");	
			}
		
		@GetMapping("/vendor/{name}")
		public Long getVendorIdByName(@PathVariable("name") String name) {
			Optional<Vendor> optional=vendorRepository.findByName(name);
			if(optional.isPresent())
				return optional.get().getVendorId();
			throw new RuntimeException("Name is invalid");
		}
}

