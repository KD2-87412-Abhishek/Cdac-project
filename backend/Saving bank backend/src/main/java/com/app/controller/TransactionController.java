package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Transaction.DTO.TransactionGetDTO;
import com.app.Transaction.DTO.TransactionPostDTO;
import com.app.dto.ApiResponse;
import com.app.service.TransactionService;

import jakarta.validation.Valid;
@CrossOrigin(origins = "*")

@RestController
@RequestMapping("/transfer")
public class TransactionController {
	 @Autowired
	    private TransactionService transactionService;

	 @PostMapping("transaction")
	    public ResponseEntity<TransactionGetDTO> createTransaction(@RequestBody TransactionPostDTO transactionPostDTO) {
	        TransactionGetDTO transaction = transactionService.createTransaction(transactionPostDTO);
	        return ResponseEntity.ok(transaction);
	    }

//	    @GetMapping("/email/{email}")
//	    public ApiResponse getTransactionsByEmail(@PathVariable String email) {
//	        return transactionService.getTransactionsByEmail(email);
//	    }
	

//	 @GetMapping("/user/{userId}")
//	    public ResponseEntity<List<TransactionGetDTO>> getTransactionsByUserId(@PathVariable Long userId) {
//	        List<TransactionGetDTO> transactions = transactionService.getTransactionsByUserId(userId);
//	        return ResponseEntity.ok(transactions);
//	    }
//	 
	
	}


