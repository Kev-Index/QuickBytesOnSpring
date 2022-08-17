package com.quickbytes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.quickbytes.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor,Long> {
	@Query("select v from Vendor v where v.name=?1")
	Optional<Vendor> findByName(String name);

	@Query("select v from Vendor v where v.user.id=?1")
	Optional<Vendor> findByUserId(Long uid);
	


	@Query("select v from Vendor v where v.user.id=?1")
    Optional<Vendor> getByUserId(Long uid);

	@Transactional
	@Modifying
	@Query("update Vendor v SET v.name=?1, v.businessId=?2 where v.id=?3")
	void updateVendor(String name, Long businessId, Long id);

	/*@Query("select v from Vendor v where v.username=?1")
	Optional<Vendor> getByUsername(String name);
  */
}
