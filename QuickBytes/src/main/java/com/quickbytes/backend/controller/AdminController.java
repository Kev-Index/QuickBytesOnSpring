package com.quickbytes.backend.controller;

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

import com.quickbytes.backend.model.Admin;
import com.quickbytes.backend.repository.AdminRepository;

@RestController
public class AdminController {
	@Autowired
	private AdminRepository adminRepository;
	
	// Post Admin \\
	@PostMapping("/admin")
	public void postAdmin(@RequestBody Admin admin){
		adminRepository.save(admin);
	}
	// Get All Admins \\
	@GetMapping("/admin")
	public List<Admin>getAllAdmin(){
		return adminRepository.findAll();
	}
	// Get Admin by ID \\
	@GetMapping("/admin/{aid}")
	public Admin getAdminById(@PathVariable("aid")Long id) {
		Optional<Admin> optional = adminRepository.findById(id);
		if(!optional.isPresent())
			throw new RuntimeException ("Admin ID Doesn't Exist");
		return optional.get();
	}
	// Put (Update) Admin By ID \\
	@PutMapping("/admin/{aid}")
	public void updateAdminById(@PathVariable("aid")Long id,
			@RequestBody Admin updatedAdmin) {
		Optional<Admin> optional = adminRepository.findById(id);
		if(!optional.isPresent())
			throw new RuntimeException ("Admin ID Doesn't Exist");
		Admin existingAdmin = optional.get();
		updatedAdmin.setFirstName(existingAdmin.getFirstName());
		updatedAdmin.setUserId(existingAdmin.getUserId());
		updatedAdmin.setLastName(existingAdmin.getLastName());
		adminRepository.save(updatedAdmin);
	}
	// Delete Admin \\
	@DeleteMapping("/admin/{aid}")
	public void deleteAdminById(@PathVariable("aid")Long id) {
		adminRepository.deleteById(id);
	}
}
