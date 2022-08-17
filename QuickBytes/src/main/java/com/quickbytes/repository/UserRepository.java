package com.quickbytes.repository;

import java.time.LocalDate;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.quickbytes.model.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
	// SELECT <Column> from <Table>
	@Query("select u from UserInfo u where u.username=?1")
	UserInfo getByUsername(String username);

	@Transactional
	@Modifying
	@Query("update UserInfo u SET u.password=?2,u.passwordLastReset=?3 where u.username=?1")
	void resetPassword(String username, String password,LocalDate date);
	
	@Transactional
	@Modifying
	@Query("update UserInfo u SET u.username=?1")
	void updateUserInfo(String username);

}
