package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.Transaction.DTO.TransactionGetDTO;
import com.app.Transaction.DTO.TransactionPostDTO;
import com.app.dto.ApiResponse;
import com.app.entities.Transaction;

public interface TransactionService {
//ResponseEntity<?> addTransaction(TransactionPostDTO transactionPostDTO);
    
    //ApiResponse getTransactionsByEmail(String email);
    TransactionGetDTO createTransaction(TransactionPostDTO transactionPostDTO);
	// List<TransactionGetDTO> getTransactionsByUserId(Long userId);

}
