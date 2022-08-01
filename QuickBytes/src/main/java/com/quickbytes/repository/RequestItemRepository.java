package com.quickbytes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.quickbytes.model.RequestItem;

public interface RequestItemRepository extends JpaRepository<RequestItem, Long>{

	@Query("select ri from RequestItem ri where ri.request.requestId=?1")
	List<RequestItem> getAllRequestItemsByRequestId(Long rid);

	@Query("select ri from RequestItem ri where ri.item.itemId=?1")
	List<RequestItem> getAllRequestItemsByItemId(Long iid);

	@Modifying
	@Query("delete RequestItem ri where ri.request.requestId=?1")
	long deleteAllRequestItemsByRequestId(Long rid);

//	@Modifying
//	@Query("delete RequestItem ri where ri.item.itemId=?1 limit ?2")
//	long deleteRequestItemsByItemId(Long iid, Integer amount);

	@Modifying
	@Query("delete RequestItem ri where ri.item.itemId=?1")
	long deleteAllRequestItemsByItemId(Long iid);

	@Modifying
	@Query("delete RequestItem ri where ri.request.requestId=?1 and ri.item.itemId=?2")
	void deleteAllRequestItemsByRequestAndItemId(Long rid, Long iid);
}
