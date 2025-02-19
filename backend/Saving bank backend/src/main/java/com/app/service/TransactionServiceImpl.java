package com.app.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Transaction.DTO.TransactionGetDTO;
import com.app.Transaction.DTO.TransactionPostDTO;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.entities.Accounts;
import com.app.entities.Transaction;
import com.app.repository.AccountsRepository;
import com.app.repository.TransactionRepository;
import com.app.repository.UserEntityRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private ModelMapper modelMapper;
	


	@Override
	public TransactionGetDTO createTransaction(TransactionPostDTO transactionPostDTO) {
	    // Validate accounts
	    Accounts sourceAccount = accountsRepository.findById(transactionPostDTO.getSourceAccountId())
	        .orElseThrow(() -> new ResourceNotFoundException("Source account not found"));
	    Accounts destinationAccount = accountsRepository.findById(transactionPostDTO.getDestinationAccountId())
	        .orElseThrow(() -> new ResourceNotFoundException("Destination account not found"));

	    // Check for sufficient funds
	    BigDecimal sourceBalance = sourceAccount.getBalance(); // Assuming this is BigDecimal
	    BigDecimal transactionAmount = transactionPostDTO.getAmount();
 // Convert Double to BigDecimal

	    if (sourceBalance.compareTo(transactionAmount) < 0) { // Use compareTo for comparison
	        throw new RuntimeException("Insufficient funds in source account");
	    }

	    // Perform the transaction
	    sourceAccount.setBalance(sourceBalance.subtract(transactionAmount)); // Update balance
	    destinationAccount.setBalance(destinationAccount.getBalance().add(transactionAmount)); // Update destination balance

	    // Save updated accounts
	    accountsRepository.save(sourceAccount);
	    accountsRepository.save(destinationAccount);

	    // Create and save transaction record
	    Transaction transaction = new Transaction();
	    transaction.setSourceAccountId(transactionPostDTO.getSourceAccountId());
	    transaction.setDestinationAccountId(transactionPostDTO.getDestinationAccountId());
	    transaction.setAmount(transactionAmount);
	    transaction.setTransactionDate(LocalDateTime.now());

	    Transaction savedTransaction = transactionRepository.save(transaction);

	    // Map to DTO and return
	    return modelMapper.map(savedTransaction, TransactionGetDTO.class);
	}
	
//	@Override
//    public List<TransactionGetDTO> getTransactionsByUserId(Long userId) {
//        List<Transaction> transactions = transactionRepository.findByUserId(userId);
//        return transactions.stream()
//                .map(transaction -> modelMapper.map(transaction, TransactionGetDTO.class))
//                .collect(Collectors.toList());
//    }
}
		
	

   

  

