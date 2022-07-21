package com.quickbytes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quickbytes.model.Item;

public interface ItemRepository extends JpaRepository<Item,Long>{

}
