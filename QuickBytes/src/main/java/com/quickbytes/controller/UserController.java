package com.quickbytes.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Base64;
import java.util.List;

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

import com.quickbytes.dto.UserEditDto;
import com.quickbytes.dto.UserInfoDto;
import com.quickbytes.model.Admin;
import com.quickbytes.model.Customer;
import com.quickbytes.model.UserInfo;
import com.quickbytes.model.Vendor;
import com.quickbytes.repository.AdminRepository;
import com.quickbytes.repository.CustomerRepository;
import com.quickbytes.repository.UserRepository;
import com.quickbytes.repository.VendorRepository;

@RestController
//@CrossOrigin(origins = {"http://localhost:52265"})
public class UserController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private VendorRepository vendorRepository;
	
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
		if (user.getRole().equalsIgnoreCase("Vendor")) {
			Vendor v=new Vendor();
			v.setName((String)user.getUsername()+ "Please Change Name");
			v.setBusinessId((long) 0);
			v.setUser(user);
			vendorRepository.save(v);
			
		}
	}
	
	@GetMapping("/login") //username/password
	public UserInfoDto login(Principal principal) {
		String username = principal.getName();
		UserInfo info = userRepository.getByUsername(username);
		UserInfoDto dto = new UserInfoDto();
		dto.setId(info.getId());
		dto.setUsername(info.getUsername());
		dto.setRole(info.getRole());
		return dto; 
	}
	
	/*ISSUE:
	 * Deleting an entry in the User table doesn't delete
	 * from tables where foreign keys are derived from
	 * */
	@DeleteMapping("/user/{uid}")
	public void deleteUser(@PathVariable("uid") Long id) {
		userRepository.deleteById(id);
		
	}
	
	@GetMapping("/user/username")
	public UserEditDto getUserByUsername(Principal principal) {
		UserInfo info = userRepository.getByUsername(principal.getName());
		UserEditDto dto = new UserEditDto(info.getId(), info.getUsername(), 
				info.getSecurityAnswer(), info.getSecurityQuestion());
		return dto; 
	}
	
	@GetMapping("/user/single/{username}")
	public UserInfo getUser(@PathVariable("username") String username) {
		UserInfo info = userRepository.getByUsername(username);
		return info; 
	}
	
	
	@GetMapping("/user/security/info/{username}")
	public UserEditDto getUserInfo(@PathVariable("username") String username) {
		UserInfo info =userRepository.getByUsername(username);
		UserEditDto dto = new UserEditDto(info.getId(), info.getUsername(), 
				"", info.getSecurityQuestion());
		return dto; 
	}
	
	@GetMapping("/validate-security-answer/{encodedText}")
	public boolean verifySecurityAnswer(@PathVariable("encodedText") String encodedText) {
		boolean status=false;
		String str = new String(Base64.getDecoder().decode(encodedText)); 
		//username + '--'+answer
		String[] sarr =str.split("--");
		String username = sarr[0]; 
		String answer=sarr[1];
		UserInfo info =userRepository.getByUsername(username);
		if(info.getSecurityAnswer().equalsIgnoreCase(answer)) {
			status=true; 
		}
		return status; 
	}
	
	@PutMapping("/user/reset-password/{encodedText}")
	public void resetPassword(@PathVariable("encodedText") String encodedText) {
		boolean status=false;
		String str = new String(Base64.getDecoder().decode(encodedText)); 
		//username + '--'+answer
		String[] sarr =str.split("--");
		String username = sarr[0]; 
		String password=sarr[1];
		
		String encodedPassword = this.passwordEncoder.encode(password);
		userRepository.resetPassword(username,encodedPassword,LocalDate.now());
		
	}
}
