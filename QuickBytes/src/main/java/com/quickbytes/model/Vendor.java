package com.quickbytes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vendorId;
	
	@OneToMany
	private List<Request> requests;
}
