package com.quickbytes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.quickbytes.repository.ComboRepository;

@RestController
public class ComboController {

	@Autowired
	ComboRepository comboRepository;
}
