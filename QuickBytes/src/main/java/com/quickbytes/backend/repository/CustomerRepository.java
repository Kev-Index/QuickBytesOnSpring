package com.quickbytes.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quickbytes.backend.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	@Query("select c from Customer c where c.firstName=?1")
	List<Customer> getListCustomerWithFirstName(String firstName);
	@Query("select c from Customer c where c.lastName=?1")
	List<Customer> getListCustomerWithLastName(String lastName);
	@Query("select c from Customer c where c.username=?1")
	Customer getCustomerByUsername(String username);
	@Query("select c from Customer c where c.employeeId=?1")
	Customer getCustomerByEmployeeId(int eid);
	@Query("select c from Customer c where c.balance>=?1")
	List<Customer> getListCustomerWithBalanceGreaterThanOrEqual(Float balance);
	@Query("select c from Customer c where c.balance<=?1")
	List<Customer> getListCustomerWithBalanceLessThanOrEqual(Float balance);

}
