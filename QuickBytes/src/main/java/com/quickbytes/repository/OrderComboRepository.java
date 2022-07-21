package com.quickbytes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quickbytes.model.OrderCombo;

public interface OrderComboRepository extends JpaRepository<OrderCombo,Long>{
	
	@Query("select oc from OrderCombo oc where oc.order.orderId=?1")
	OrderCombo getAllOrderCombosByOrderId(Long oid);

	@Query("select oc from OrderCombo oc where oc.combo.comboId=?1")
	OrderCombo getAllOrderCombosByComboId(Long oid);

	@Query("delete oc from OrderCombo oc where oc.order.orderId=?1")
	long deleteAllOrderCombosByOrderId(Long oid);

	@Query("delete oc from OrderCombo oc where oc.combo.comboId=?1 limit ?2")
	long deleteOrderCombosByComboId(Long sid, Integer amount);

	@Query("delete oc from OrderCombo oc where oc.combo.comboId=?1")
	long deleteAllOrderCombosByComboId(Long cid);
	

}
