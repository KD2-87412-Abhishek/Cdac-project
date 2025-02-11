package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Accounts;

import com.app.entities.UserEntity;
@Repository
public interface AccountsRepository extends JpaRepository<Accounts, Long> {
//	Optional<Account> findByEmail(String em);
//	 boolean existsByEmail(String email);
//	  boolean existsByPhone(String phone);
	 Optional<Accounts> findByUser_Email(String email);
	   Optional<Accounts> findByUser_Id(Long userId);
}
