package com.quickbytes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.quickbytes.model.Request;

public interface RequestRepository extends JpaRepository<Request,Long>{

	@Query("select r from Request r where r.customer.customerId=?1")
	List<Request> getAllRequestsByCustomerId(Long cid);

	@Query("select r from Request r where r.vendor.vendorId=?1")
	List<Request> getAllRequestsByVendorId(Long vid);

	@Modifying
	@Query("delete Request r where r.customer.customerId=?1")
	long deleteAllRequestsByCustomerId(Long cid);

	@Modifying
	@Query("delete Request r where r.vendor.vendorId=?1")
	long deleteAllRequestsByVendorId(Long vid);
	
}
