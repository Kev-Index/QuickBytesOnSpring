package com.quickbytes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quickbytes.model.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{

	@Query("select o from Order o where o.customer.customerId=?1")
	Order getOrdersByCustomerId(Long cid);

	@Query("select o from Order o where o.vendor.vendorId=?1")
	Order getOrdersByVendorId(Long vid);

	@Query("delete o from Order o where o.vendor.vendorId=?1")
	Order deleteOrdersByCustomerId(Long cid);

	@Query("delete o from Order o where o.vendor.vendorId=?1")
	Order deleteOrdersByVendorId(Long vid);
	
}
