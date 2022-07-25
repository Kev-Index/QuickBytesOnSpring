package com.quickbytes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.quickbytes.model.Item;
import com.quickbytes.model.ItemCombo;

public interface ItemComboRepository extends JpaRepository<ItemCombo,Long>{
	
	@Query("select i from ItemCombo i where i.item.itemId=?1")
	List<ItemCombo> getAllItemCombosByItemId(Long iid);

	@Query("select i from ItemCombo i where i.combo.comboId=?1")
	List<ItemCombo> getAllItemCombosByComboId(Long cid);

	@Modifying
	@Query("delete ItemCombo i where i.item.itemId=?1")
	Item deleteAllItemCombosByItemId(Long iid);

//	@Modifying
//	@Query("delete ItemCombo i where i.combo.comboId=?1")
//	Item deleteItemCombosByComboId(Long cid);

	@Modifying
	@Query("delete ItemCombo i where i.combo.comboId=?1")
	Item deleteAllItemCombosByComboId(Long cid);

}

