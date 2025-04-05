package com.bank.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.DTO.AccountDTO;
import com.bank.Mapper.AccountMapper;
import com.bank.entity.Account;
import com.bank.entity.Transaction;
import com.bank.repository.AccountRepository;
import com.bank.repository.TransactionRepository;

import jakarta.persistence.OptimisticLockException;
import jakarta.transaction.Transactional;


@Service
public class AccountServiceImpl implements AccountService  {
	
    @Autowired
	private AccountRepository accountRepositary;
    
    @Autowired
    private TransactionRepository transactionrepository;

	@Override
	public AccountDTO CreateAccount(AccountDTO accountDto) {
		
		Account account = AccountMapper.mapToAccount(accountDto);
		Account savedAccount =  accountRepositary.save(account);
		
		return AccountMapper.MapToAccountDto(savedAccount);
	}

	@Override
	public AccountDTO getAccountById(Long id) {
		
		Account account = accountRepositary.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		return AccountMapper.MapToAccountDto(account);
	}
	

	@Override
	@Transactional
	public AccountDTO deposite(Long id,double amount) {
		int maxentries = 3;
		int attempt = 0;
		
		while(attempt < maxentries) {
			
		try {
		
		//fetch the account
		Account account = accountRepositary.findById(id).orElseThrow(()-> new RuntimeException("Account Does not exist"));
		
		//update the balance
		 double updatedBalance = account.getBalance() + amount;
		 account.setBalance(updatedBalance);
		 
		 //save the account
		 Account savedAccount = accountRepositary.save(account);
		 
		 //create and save transaction record
		 Transaction transaction = new Transaction(
			        id,
			        "DEPOSIT",
			        amount,
			        LocalDateTime.now(),
			        "SUCCESS"
			    );
		 transactionrepository.save(transaction);
		 
		 return AccountMapper.MapToAccountDto(savedAccount);
		}
		catch (OptimisticLockException e) {
            attempt++; // Retry on conflict
            if (attempt >= maxentries) {
                throw new RuntimeException("Transaction failed due to concurrent updates. Please try again.");
            }
		}
		
	}
		
		// Unexpected case (will rarely happen)
	    throw new RuntimeException("Unexpected error during deposit.");
}
		
	

	@Override
	@Transactional
	public AccountDTO withdraw(Long id,double amount) {
		int maxentries = 3;
		int attempt = 0;
		
		while(attempt < maxentries) {
			
		try {
		
		//fetch the account
		Account account = accountRepositary.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		
		//check for sufficient funds
		if(account.getBalance() < amount) {
			//create a failed transaction record
			Transaction failedTransaction = new Transaction(
					id,
					"WITHDRAW",
					amount,
					LocalDateTime.now(),
					"FAILED"
					);
			transactionrepository.save(failedTransaction);
			
			throw new RuntimeException("Insufficient Balance");
		}
		
		// Update balance
	    double updatedBalance = account.getBalance() - amount;
	    account.setBalance(updatedBalance);
	    
	 // Save the account
	    Account savedAccount = accountRepositary.save(account);
	    
	 // Create and save a successful transaction record
	    Transaction transaction = new Transaction(
	        id,
	        "WITHDRAW",
	        amount,
	        LocalDateTime.now(),
	        "SUCCESS"
	    );
	    
	    transactionrepository.save(transaction);
	    
	    return AccountMapper.MapToAccountDto(savedAccount);
	    }
		catch (OptimisticLockException e) {
            attempt++; // Retry on conflict
            if (attempt >= maxentries) {
                throw new RuntimeException("Transaction failed due to concurrent updates. Please try again.");
            }
		}
	}
		
		 throw new RuntimeException("Unexpected error during withdrawal.");
	}
	
	

	@Override
	public List<AccountDTO> getAllAccounts() {
		
		return accountRepositary.findAll().stream().map((account) -> AccountMapper.MapToAccountDto(account)).
		collect(Collectors.toList());
		
	
	}

	@Override
	public void deleteAccount(Long id) {
		
		Account account = accountRepositary.findById(id).orElseThrow(() -> new RuntimeException("Account does not exist"));
		
		accountRepositary.delete(account);
		
		
		
	}

	@Override
	public List<Transaction> getTransactionHistory(Long accountId) {
		
		return transactionrepository.findAccountById(accountId);
	}

	

}
