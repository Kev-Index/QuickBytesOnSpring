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

import com.quickbytes.model.Admin;
import com.quickbytes.repository.AdminRepository;

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
	
	// Get Admin by User ID \\
	@GetMapping("/admin/single/user/{uid}")
    public Admin getAdminByUserId(@PathVariable("uid") Long uid) {
        Optional<Admin> optional=adminRepository.getByUserId(uid);
        if (optional.isPresent())
            return optional.get();
        else
            throw new RuntimeException("ID is invalid");
    }
	
	// Put (Update) Admin By ID \\
	@PutMapping("/admin/{aid}")
	public void updateAdminById(@PathVariable("aid")Long id,
			@RequestBody Admin updatedAdmin) {
		Optional<Admin> optional = adminRepository.findById(id);
		if(!optional.isPresent())
			throw new RuntimeException ("Admin ID Doesn't Exist");
		Admin existingAdmin = optional.get();
		existingAdmin.setFirstName(updatedAdmin.getFirstName());
		existingAdmin.setUserId(updatedAdmin.getUserId());
		existingAdmin.setLastName(updatedAdmin.getLastName());
		existingAdmin.setId(id);
		adminRepository.save(existingAdmin);
	}
	// Delete Admin \\
	@DeleteMapping("/admin/{aid}")
	public void deleteAdminById(@PathVariable("aid")Long id) {
		adminRepository.deleteById(id);
	}
}
