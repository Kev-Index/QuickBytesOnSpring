package com.quickbytes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.quickbytes.model.Combo;
import com.quickbytes.model.Request;
import com.quickbytes.model.RequestCombo;
import com.quickbytes.repository.ComboRepository;
import com.quickbytes.repository.RequestComboRepository;
import com.quickbytes.repository.RequestRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})public class RequestComboController {
	
	@Autowired
	RequestComboRepository requestComboRepository;
	
	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	ComboRepository comboRepository;
	
	/* POST NEW REQUEST COMBO */
	@PostMapping("/requestcombo/{rid}/{cid}")
	public RequestCombo postRequestCombo(@RequestBody RequestCombo requestCombo, @PathVariable("rid") Long rid, 
									@PathVariable("cid") Long cid) {
		//get request
		Optional<Request> optionalRequest = requestRepository.findById(rid);
		if (!optionalRequest.isPresent()) {
			throw new RuntimeException("Request ID is invalid");
		}
		Request request = optionalRequest.get();
		
		//get combo
		Optional<Combo> optionalCombo = comboRepository.findById(cid);
		if (!optionalCombo.isPresent()) {
			throw new RuntimeException("Combo ID is invalid");
		}
		Combo combo = optionalCombo.get();
		
		requestCombo.setRequest(request);
		requestCombo.setCombo(combo);
		return requestComboRepository.save(requestCombo);	
	}
	
	/* GET REQUEST COMBO BY ID 
	 * NEEDS DTO CONVERSION */
	@GetMapping("/requestcombo/{id}")
	public RequestCombo getRequestCombo(@PathVariable("id") Long id) {
		Optional<RequestCombo> requestCombo = requestComboRepository.findById(id);
		if (requestCombo.isPresent()) {
			return requestCombo.get();
		}
		throw new RuntimeException("ID is invalid");
	}
	
	/* GET ALL REQUEST COMBOS BY REQUEST ID 
	 * NEEDS DTO CONVERSION */
	@GetMapping("/requestcombo/rid/{rid}")
	public List<RequestCombo> getAllRequestCombosByRequestId(@PathVariable("rid") Long rid) {
		return requestComboRepository.getAllRequestCombosByRequestId(rid);
	}
	
	/* GET ALL REQUEST COMBOS BY COMBO ID 
	 * NEEDS DTO CONVERSION */
	@GetMapping("/requestcombo/cid/{cid}")
	public List<RequestCombo> getAllRequestCombosByComboId(@PathVariable("rid") Long rid) {
		return requestComboRepository.getAllRequestCombosByComboId(rid);
	}
	
	/* GET ALL REQUEST COMBOS 
	 * NEEDS DTO CONVERSION */
	@GetMapping("/requestcombos")
	public List<RequestCombo> getAllRequestCombos(@RequestParam(name="page",required=false,defaultValue="0") Integer page, 
			@RequestParam(name="size",required=false,defaultValue="10000") Integer size) {
		Pageable pageable = PageRequest.of(page, size);	
		return requestComboRepository.findAll(pageable).getContent();
	}
	
	/* UPDATE EXISTING REQUEST COMBO BY ID */
	@PutMapping("/requestcombo/{id}/{rid}/{cid}")
	public RequestCombo putRequestCombo(@PathVariable("id") Long id, 
							@PathVariable("rid") Long rid, @PathVariable("cid") Long cid) {
		//get request combo
		RequestCombo requestCombo = getRequestCombo(id);
		
		//get request
		Optional<Request> optionalRequest = requestRepository.findById(rid);
		if (!optionalRequest.isPresent()) {
			throw new RuntimeException("Request ID is invalid");
		}
		Request request = optionalRequest.get();
		
		//get combo
		Optional<Combo> optionalCombo = comboRepository.findById(cid);
		if (!optionalCombo.isPresent()) {
			throw new RuntimeException("Combo ID is invalid");
		}
		Combo combo = optionalCombo.get();
		
		//update request combo
		requestCombo.setRequest(request);
		requestCombo.setCombo(combo);
		return requestComboRepository.save(requestCombo);
	}
	
	/* DELETE REQUEST COMBO BY ID */
	@DeleteMapping("/requestcombo/{id}")
	public void deleteRequestCombo(@PathVariable("id") Long id) {
		requestComboRepository.deleteById(id);
	}
	
	/* DELETE ALL REQUEST COMBOS BY REQUEST ID */
	@DeleteMapping("/requestcombo/rid/{rid}")
	public void deleteAllRequestCombosByRequestId(@PathVariable("rid") Long rid) {
		requestComboRepository.deleteAllRequestCombosByRequestId(rid);
	}
	
//	/* DELETE SOME REQUEST COMBOS BY COMBO ID */
//	@DeleteMapping("/requestcombo/cid/{cid}/{amount}")
//	public void deleteRequestCombosByComboId(@PathVariable("cid") Long cid, @PathVariable("amount") Integer amount) {
//		requestComboRepository.deleteRequestCombosByComboId(cid,amount);
//	}
	
	/* DELETE ALL REQUEST COMBOS BY COMBO ID */
	@DeleteMapping("/requestcombo/cid/{cid}")
	public void deleteAllRequestCombosByComboId(@PathVariable("cid") Long cid) {
		requestComboRepository.deleteAllRequestCombosByComboId(cid);
	}
	
	/* DELETE ALL REQUEST COMBOS BY REQUEST & COMBO ID */
	@DeleteMapping("/requestitem/rid/iid/{rid}/{cid}")
	public void deleteAllRequestCombosByRequestAndComboId(@PathVariable("rid") Long rid,@PathVariable("cid") Long cid) {
		requestComboRepository.deleteAllRequestCombosByRequestAndComboId(rid,cid);
	}
	
	/* DELETE ALL REQUEST COMBOS */
	@DeleteMapping("/requestcombos")
	public void deleteAllRequestCombos() {
		requestComboRepository.deleteAll();
	}
}
