package com.quickbytes.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.quickbytes.model.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
	// SELECT <Column> from <Table>
	@Query("select u from UserInfo u where u.username=?1")
	UserInfo getByUsername(String user);

}
