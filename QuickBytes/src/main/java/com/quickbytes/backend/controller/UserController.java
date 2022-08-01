package com.quickbytes.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickbytes.backend.model.Admin;
import com.quickbytes.backend.model.Customer;
import com.quickbytes.backend.model.UserInfo;
import com.quickbytes.backend.repository.AdminRepository;
import com.quickbytes.backend.repository.CustomerRepository;
import com.quickbytes.backend.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/user")
	public List<UserInfo> getUser(){
		return userRepository.findAll();
	}
	@PostMapping("/user")
	public void postUser(@RequestBody UserInfo user){
		UserInfo info = userRepository.getByUsername(user.getUsername());
		if (info != null)
			throw new RuntimeException("Credentials Invalid");
		String password = user.getPassword();
		password = passwordEncoder.encode(password);
		user.setPassword(password);
		user.setRole(user.getRole().toLowerCase());
		userRepository.save(user);
		
		if(user.getRole().equalsIgnoreCase("Admin")) {
			Admin a = new Admin();
			a.setFirstName((String)user.getUsername() + " Please Change name");
			a.setLastName((String)user.getUsername() + " Please Change name");
			a.setUserId(user);
			adminRepository.save(a);
		}
		if(user.getRole().equalsIgnoreCase("Customer")) {
			Customer c = new Customer();
			c.setFirstName((String)user.getUsername() + " Please Change Name");
			c.setLastName((String)user.getUsername() + " Please Change Name");
			c.setBalance((float)0);
			c.setUserId(user);
			customerRepository.save(c);
		}
	}
	
	/*ISSUE:
	 * Deleting an entry in the User table doesn't delete
	 * from tables where foreign keys are derived from
	 * */
	@DeleteMapping("/user/{uid}")
	public void deleteUser(@PathVariable("uid") Long id) {
		userRepository.deleteById(id);
		
	}
}
