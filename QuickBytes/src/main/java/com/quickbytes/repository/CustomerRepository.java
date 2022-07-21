package com.quickbytes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickbytes.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{

}
