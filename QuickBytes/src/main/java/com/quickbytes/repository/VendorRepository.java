package com.quickbytes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickbytes.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor,Long> {

}
