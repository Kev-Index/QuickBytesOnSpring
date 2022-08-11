package com.quickbytes.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quickbytes.model.Item;

public interface ItemRepository extends JpaRepository<Item,Long> {
	
	@Query("select i from Item i where i.vendor.vendorId = ?1")
	Page<Item> findByVendorId(Pageable p, Long vid);
}
