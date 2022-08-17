package com.quickbytes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quickbytes.model.Customer;
import com.quickbytes.repository.CustomerRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	
	// Post Customer \\
	@PostMapping("/customer")
	public void postCustomer(@RequestBody Customer customer){
		customerRepository.save(customer);
	}
	// Get All Customer in a List<Customer>  \\
	@GetMapping("/customer")
	public List<Customer>getAllCustomer(@RequestParam(name="page", required = false, defaultValue = "0") Integer page,
			@RequestParam(name="size",required=false,defaultValue = "100") Integer size){
		if(page < 0)
			page=0;
		
		Pageable pageable=PageRequest.of(page, size);
		 
		Page<Customer> p =  customerRepository.findAll(pageable);
		long total = p.getTotalElements();
		
		return p.getContent();
	}
	// Get Specific Customer by CustomerID in Customer Obj \\
	@GetMapping("/customer/{cid}")
	public Customer getCustomerById(@PathVariable("cid")Long id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if(!optional.isPresent())
			throw new RuntimeException ("Customer ID Doesn't Exist");
		return optional.get();
	}
	
	// Get Specific Customer by UserId \\
	@GetMapping("/customer/single/user/{uid}")
    public Customer getCustomerByUserId(@PathVariable("uid") Long uid) {
        Optional<Customer> optional=customerRepository.getByUserId(uid);
        if (optional.isPresent())
            return optional.get();
        else
            throw new RuntimeException("ID is invalid");
    }
	
	// Delete Specific Customer by CustomerID \\
	@DeleteMapping("/customer/{cid}")
	public void deleteCustomerById(@PathVariable("cid")Long id) {
		customerRepository.deleteById(id);
	}
	
	/*	ISSUE:
	 * Instead of updating, creates new record incrementing
	 * customer id.
	 * 
	 * FIXED: 08/01 - Jerry
	 * */
	
	// Update (Put) Customer By CustomerID\\
	@PutMapping("/customer/{cid}")
	public void updateCustomerById(@PathVariable("cid")Long cid,
			@RequestBody Customer updatedCustomer) {
		Optional<Customer> optional = customerRepository.findById(cid);
		if(!optional.isPresent())
			throw new RuntimeException ("Customer ID Doesn't Exist");
		Customer existingCustomer = optional.get();
		existingCustomer.setEmployeeId(updatedCustomer.getEmployeeId());
		existingCustomer.setFirstName(updatedCustomer.getFirstName());
		existingCustomer.setLastName(updatedCustomer.getLastName());
		existingCustomer.setBalance(updatedCustomer.getBalance());
		existingCustomer.setUserId(existingCustomer.getUserId());
		
		existingCustomer.setMiddleName(updatedCustomer.getMiddleName());
		existingCustomer.setEmail(updatedCustomer.getEmail());
		existingCustomer.setPhoneNumber(updatedCustomer.getPhoneNumber());
		existingCustomer.setBirthday(updatedCustomer.getBirthday());
		existingCustomer.setPreferedName(updatedCustomer.getPreferedName());
		existingCustomer.setAddressLine1(updatedCustomer.getAddressLine1());
		existingCustomer.setAddressLine2(updatedCustomer.getAddressLine2());
		existingCustomer.setSuite(updatedCustomer.getSuite());
		existingCustomer.setCountry(updatedCustomer.getCountry());
		existingCustomer.setState(updatedCustomer.getState());
		existingCustomer.setCity(updatedCustomer.getCity());
		existingCustomer.setPostalCode(updatedCustomer.getPostalCode());
		
		existingCustomer.setTermsAccepted(existingCustomer.isTermsAccepted());
		existingCustomer.setEmailVerified(existingCustomer.isEmailVerified());
		existingCustomer.setTwoFactorAuth(existingCustomer.isTwoFactorAuth());
		existingCustomer.setPhoneVerified(existingCustomer.isPhoneVerified());
		customerRepository.save(existingCustomer);
	}
	
	/* Extra Functionality*/
	
	/*ISSUE:
	 * Employee IDs are default 0 so this won't work as aspected.
	 * Generate random ID or force Admin to provide employee ID for Customers
	 * */
	
	// Get Specific Customer by Employee ID \\
	@GetMapping("/customer/employee/{eid}")
	public Customer getCustomerByEmployeeId(@PathVariable("eid") int eid){
		Customer user = customerRepository.getCustomerByEmployeeId(eid);
		return user;
	}
	
	/* REMOVED:
	 * Customers derive username from parent User
	 * */
	
	// Get Specific Customer by user name \\
	//@GetMapping("/customer/user/{username}")
	//public Customer getCustomerByUsername(@PathVariable("username") String username){
		//Customer user = customerRepository.getCustomerByUsername(username);
		//return user;
	//}
	
	// Get List <Customer> by First Name \\
	@GetMapping("/customer/fname/{firstName}")
	List<Customer> getListCustomerWithFirstName(@PathVariable("firstName") String firstName){
		List<Customer> list = customerRepository.getListCustomerWithFirstName(firstName);
		return list;
	}
	// Get List <Customer> by Last Name \\
	@GetMapping("/customer/lname/{lastName}")
	List<Customer> getListCustomerWithLastName(@PathVariable("lastName") String lastName){
		List<Customer> list = customerRepository.getListCustomerWithLastName(lastName);
		return list;
	}
	// Get List <Customer> by Balance greater than or equal to \\
	@GetMapping("/customer/balancegte/{balance}")
	List<Customer> getListCustomerWithBalanceGreaterThanOrEqual(@PathVariable("balance") Float balance){
		List<Customer> list = customerRepository.getListCustomerWithBalanceGreaterThanOrEqual(balance);
		return list;
	}
	// Get List <Customer> by Balance less than or equal to \\
	@GetMapping("/customer/balancelte/{balance}")
	List<Customer> getListCustomerWithBalanceLessThanOrEqual(@PathVariable("balance") Float balance){
		List<Customer> list = customerRepository.getListCustomerWithBalanceLessThanOrEqual(balance);
		return list;
	}
}
