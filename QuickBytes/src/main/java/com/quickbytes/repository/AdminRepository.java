package com.quickbytes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quickbytes.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

	@Query("select a from Admin a where a.userId.id=?1")
    Optional<Admin> getByUserId(Long uid);

}
