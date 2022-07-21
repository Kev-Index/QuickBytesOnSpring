package com.quickbytes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.quickbytes.repository.VendorRepository;

@RestController
public class VendorController {

	@Autowired
	VendorRepository vendorRepository;
}
