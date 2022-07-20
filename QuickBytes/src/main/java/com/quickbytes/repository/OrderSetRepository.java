package com.quickbytes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quickbytes.model.OrderSet;

public interface OrderSetRepository extends JpaRepository<OrderSet,Long>{

	@Query("delete os from OrderSet os where os.order.orderId=?1")
	long deleteAllOrderSetsByOrderId(Long oid);

	@Query("delete os from OrderSet os where os.set.setId=?1 limit ?2")
	long deleteOrderSetsBySetId(Long sid, Integer amount);

	@Query("delete os from OrderSet os where os.set.setId=?1")
	long deleteAllOrderSetsBySetId(Long sid);
	

}
