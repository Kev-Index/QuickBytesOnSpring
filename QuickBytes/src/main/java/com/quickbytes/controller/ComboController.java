package com.quickbytes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.quickbytes.model.Combo;
import com.quickbytes.repository.ComboRepository;

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
