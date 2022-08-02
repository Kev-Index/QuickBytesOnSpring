package com.quickbytes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickbytes.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
