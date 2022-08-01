package com.quickbytes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.quickbytes.model.RequestCombo;

public interface RequestComboRepository extends JpaRepository<RequestCombo,Long>{
	
	@Query("select rc from RequestCombo rc where rc.request.requestId=?1")
	List<RequestCombo> getAllRequestCombosByRequestId(Long rid);

	@Query("select rc from RequestCombo rc where rc.combo.comboId=?1")
	List<RequestCombo> getAllRequestCombosByComboId(Long cid);

	@Modifying
	@Query("delete RequestCombo rc where rc.request.requestId=?1")
	long deleteAllRequestCombosByRequestId(Long rid);

//	@Modifying
//	@Query("delete RequestCombo rc where rc.combo.comboId=?1 limit ?2")
//	long deleteRequestCombosByComboId(Long sid, Integer amount);

	@Modifying
	@Query("delete RequestCombo rc where rc.combo.comboId=?1")
	long deleteAllRequestCombosByComboId(Long cid);
	
	@Modifying
	@Query("delete RequestCombo rc where rc.request.requestId=?1 and rc.combo.comboId=?2")
	void deleteAllRequestCombosByRequestAndComboId(Long rid, Long cid);
}
