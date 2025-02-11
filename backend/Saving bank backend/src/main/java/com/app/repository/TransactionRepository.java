package com.app.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Transaction;
import com.app.entities.UserEntity;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
//	 List<Transaction> findByUserId(Long userId);
}
