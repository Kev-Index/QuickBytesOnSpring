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

import com.quickbytes.enums.RequestStatus;
import com.quickbytes.model.Customer;
import com.quickbytes.model.Request;
import com.quickbytes.model.Vendor;
import com.quickbytes.repository.CustomerRepository;
import com.quickbytes.repository.RequestRepository;
import com.quickbytes.repository.VendorRepository;

@RestController
public class RequestController {
	
	@Autowired
	private RequestRepository requestRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private VendorRepository vendorRepository;
	
	/* POST NEW REQUEST */
	@PostMapping("/request/{cid}/{vid}")
	public Request postRequest(@RequestBody Request request, @PathVariable("cid") Long cid, @PathVariable("vid") Long vid) {
		//get customer
		Optional<Customer> optionalCustomer = customerRepository.findById(cid);
		if (!optionalCustomer.isPresent()) {
			throw new RuntimeException("Customer ID is invalid");
		}
		Customer customer = optionalCustomer.get();
		
		//get vendor
		Optional<Vendor> optionalVendor = vendorRepository.findById(cid);
		if (!optionalVendor.isPresent()) {
			throw new RuntimeException("Vendor ID is invalid");
		}
		Vendor vendor = optionalVendor.get();
		
		request.setCustomer(customer);
		request.setVendor(vendor);
		return requestRepository.save(request);	
	}
	
	/* GET ALL REQUESTS */
	@GetMapping("/requests")
	public List<Request> getAllRequests() {
		return requestRepository.findAll();
	}
	
	/* GET REQUEST BY ID */
	@GetMapping("/request/{id}")
	public Request getRequest(@PathVariable("id") Long id) {
		Optional<Request> request = requestRepository.findById(id);
		if (request.isPresent()) {
			return request.get();
		}
		throw new RuntimeException("ID is invalid");
	}
	
	/* GET ALL REQUESTS BY CUSTOMER ID */
	@GetMapping("/request/cid/{cid}")
	public List<Request> getAllRequestsByCustomerId(@PathVariable("cid") Long cid) {
		return requestRepository.getAllRequestsByCustomerId(cid);
	}
	
	/* GET ALL REQUESTS BY VENDOR ID */
	@GetMapping("/request/vid/{vid}")
	public List<Request> getAllRequestsByVendorId(@PathVariable("vid") Long vid) {
		return requestRepository.getAllRequestsByVendorId(vid);
	}
	
	/* UPDATE EXISTING REQUEST */
	@PutMapping("/request/{id}/{cid}/{vid}")
	public Request putRequest(@RequestBody Request newRequest, @PathVariable("id") Long id, @PathVariable("cid") Long cid, @PathVariable("vid") Long vid) {
		//get request
		Request request = getRequest(id);
		
		//get customer
		Optional<Customer> optionalCustomer = customerRepository.findById(cid);
		if (!optionalCustomer.isPresent()) {
			throw new RuntimeException("Customer ID is invalid");
		}
		Customer customer = optionalCustomer.get();
		
		//get vendor
		Optional<Vendor> optionalVendor = vendorRepository.findById(cid);
		if (!optionalVendor.isPresent()) {
			throw new RuntimeException("Vendor ID is invalid");
		}
		Vendor vendor = optionalVendor.get();
		
		//update request
		request.setTotalPrice(newRequest.getTotalPrice());
		request.setStatus(newRequest.getStatus());
		request.setOrderTime(newRequest.getOrderTime());
		request.setEndTime(newRequest.getEndTime());
		request.setCustomer(customer);
		request.setVendor(vendor);
		return requestRepository.save(request);	
	}
	
	/* UPDATE EXISTING REQUEST'S TOTAL PRICE */
	@PutMapping("/request/price/{id}/{price}")
	public Request putRequestPrice(@PathVariable("id") Long id, @PathVariable("price") Float price) {
		//get request
		Request request = getRequest(id);
		
		//update request
		request.setTotalPrice(price);
		return requestRepository.save(request);	
	}
	
	/* PEND REQUEST */
	@PutMapping("/request/send/{id}")
	public Request pendRequest(@PathVariable("id") Long id) {
		//get request
				Request request = getRequest(id);
				
				//update request
				request.setStatus(RequestStatus.PENDING);
				return requestRepository.save(request);	
	}
	
	/* APPROVE REQUEST */
	@PutMapping("/request/approve/{id}")
	public Request approveRequest(@PathVariable("id") Long id) {
		//get request
		Request request = getRequest(id);
		
		//update request
		request.setStatus(RequestStatus.APPROVED);
		return requestRepository.save(request);	
	}
	
	/* DENY REQUEST */
	@PutMapping("/request/deny/{id}")
	public Request denyRequest(@PathVariable("id") Long id) {
		//get request
		Request request = getRequest(id);
		
		//update request
		request.setStatus(RequestStatus.DENIED);
		return requestRepository.save(request);	
	}
	
	/* UPDATE EXISTING REQUEST'S ORDER TIME */
	@PutMapping("/request/ordertime/{id}/{ordertime}")
	public Request putRequestRequestTime(@PathVariable("id") Long id, @PathVariable("ordertime") String ordertime) {
		//get request
		Request request = getRequest(id);
		
		//update request
		request.setEndTime(ordertime);
		return requestRepository.save(request);	
	}
	
	/* UPDATE EXISTING REQUEST'S END TIME */
	@PutMapping("/request/endtime/{id}/{endtime}")
	public Request putRequestEndTime(@PathVariable("id") Long id, @PathVariable("endtime") String endtime) {
		//get request
		Request request = getRequest(id);
		
		//update request
		request.setEndTime(endtime);
		return requestRepository.save(request);	
	}
	
	/* DELETE EXISTING REQUEST */
	@DeleteMapping("/request/{id}")
	public void deleteRequest(@PathVariable("id") Long id) {
		requestRepository.deleteById(id);
	}
	
	/* DELETE ALL REQUESTS BY CUSTOMER ID */
	@DeleteMapping("/request/cid/{cid}")
	public void deleteAllRequestsByCustomerId(@PathVariable("cid") Long cid) {
		requestRepository.deleteAllRequestsByCustomerId(cid);
	}
	
	/* DELETE ALL REQUESTS BY VENDOR ID */
	@DeleteMapping("/request/vid/{vid}")
	public void deleteAllRequestsByVendorId(@PathVariable("vid") Long vid) {
		requestRepository.deleteAllRequestsByVendorId(vid);
	}
	
	/* DELETE ALL REQUESTS */
	@DeleteMapping("/requests")
	public void deleteAllRequests() {
		requestRepository.deleteAll();
	}
	
}
