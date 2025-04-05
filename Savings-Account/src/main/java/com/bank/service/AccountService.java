package com.bank.service;

import java.util.List;

import com.bank.DTO.AccountDTO;
import com.bank.entity.Transaction;


public interface AccountService {
	
	 AccountDTO CreateAccount ( AccountDTO account);
	 
	 AccountDTO getAccountById(Long id);
	 
	 AccountDTO deposite(Long id , double amount);
	 
	 AccountDTO withdraw(Long id, double amount);
	 
	 List<AccountDTO> getAllAccounts();
	 
	 List<Transaction> getTransactionHistory(Long accountId);

	 
	 void deleteAccount(Long id);

}
  