package com.quickbytes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quickbytes.model.Combo;

public interface ComboRepository extends JpaRepository<Combo,Long>{
	
	@Query("select c from Combo c where c.name=?1")
	Optional<Combo> findByname(String name);
	
	@Query("select c from Combo c where c.vendor.vendorId=?1")
	List<Combo> findByVendorId( Long vid);


  
}
