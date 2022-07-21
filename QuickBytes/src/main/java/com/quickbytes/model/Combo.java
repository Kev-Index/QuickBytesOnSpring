package com.quickbytes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Combo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long comboId;
	
	@OneToMany //fk
	private List<RequestCombo> requestCombos;
}
