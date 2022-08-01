package com.quickbytes.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickbytes.backend.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
