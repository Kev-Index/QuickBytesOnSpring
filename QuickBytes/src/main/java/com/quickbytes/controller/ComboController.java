package com.quickbytes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quickbytes.model.Combo;
import com.quickbytes.repository.ComboRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class ComboController {
	@Autowired
	ComboRepository comboRepository;
	
	@PostMapping("/combo")
	public void postCombo(@RequestBody Combo v) {
		//use JpaRepository Interface
		//has lot of precreated methods for db interaction
		comboRepository.save(v);
	}
}
