package com.quickbytes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quickbytes.model.Combo;

public interface ComboRepository extends JpaRepository<Combo,Long>{
	@Query("select c from Combo c where c.vendorId=?1")
	List<Combo> getCombosByVendorId(Long vid);
	
	@Query("select c from Combo c where c.name=?1")
	Optional<Combo> findByname(String name);


  
}
