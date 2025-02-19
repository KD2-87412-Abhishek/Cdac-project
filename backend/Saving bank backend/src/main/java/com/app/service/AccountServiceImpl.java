package com.app.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.Account.dto.AccountPostDTO;
import com.app.Account.dto.AccountsGetDto;
import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dto.ApiResponse;
import com.app.entities.Accounts;
import com.app.entities.UserEntity;
import com.app.repository.AccountsRepository;
import com.app.repository.UserEntityRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountsService {
	@Autowired
	AccountsRepository accountsRepository;
	  @Autowired
	    private ModelMapper modelMapper;
	  @Autowired
	  private UserEntityRepository userEntityRepository;


private AccountPostDTO accountDTO;
	

public AccountsGetDto getAccountByEmail(String email) {
    Optional<Accounts> account = accountsRepository.findByUser_Email(email); // Fetch account by User's email

    if (account.isEmpty()) {
        throw new ResourceNotFoundException("User does not exist");
    }

    // Convert to DTO
    AccountsGetDto accountDTO = modelMapper.map(account.get(), AccountsGetDto.class);

    // Manually set userEmail from the related User entity
    accountDTO.setUserEmail(account.get().getUser().getEmail());

    return accountDTO;
}




	 // ✅ Add Account (Auto-Generating Account Number)
    @Override
    public ResponseEntity<?> addAccount(AccountPostDTO accountPostDTO) {
        UserEntity user = userEntityRepository.findById(accountPostDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + accountPostDTO.getUserId()));

        // Map DTO to Entity
        Accounts account = modelMapper.map(accountPostDTO, Accounts.class);
        account.setUser(user);

        // ✅ Auto-generate Account Number
        account.setAccountNumber(null); // This will trigger @PrePersist method in `Accounts`

        // Save to DB
        Accounts savedAccount = accountsRepository.save(account);

        // Convert Entity to DTO for response
        AccountPostDTO responseDTO = modelMapper.map(savedAccount, AccountPostDTO.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }




	@Override
	public void deactivateAccount(Long accountId) {
	
		 Accounts account = accountsRepository.findById(accountId)
		            .orElseThrow(() -> new ResourceNotFoundException("Account not found"));

		    account.setActive(false); // Soft delete
		    accountsRepository.save(account);
		    
		}




	@Override
	public void reactivateAccount(Long accountId) {
		Accounts account = accountsRepository.findById(accountId)
	            .orElseThrow(() -> new ResourceNotFoundException("Account not found"));

	    account.setActive(true); // Reactivate
	    accountsRepository.save(account);

		
	}




	
	 @Override
	    public ResponseEntity<?> getAccountById(Long id) {
	        Accounts account = accountsRepository.findById(id)
	                .orElseThrow(() -> new RuntimeException("Account not found with ID: " + id));

	        // Convert Entity to DTO
	        AccountsGetDto accountDTO = modelMapper.map(account, AccountsGetDto.class);
	        accountDTO.setUserEmail(account.getUser().getEmail()); // Manually set email

	        return ResponseEntity.ok(accountDTO);
	    }





	
		  @Override
		    public ResponseEntity<?> getAccountByUserId(Long userId) {
		        // Fetch account using userId
		        Accounts account = accountsRepository.findByUser_Id(userId)
		                .orElseThrow(() -> new RuntimeException("Account not found for user ID: " + userId));

		        // Convert Entity to DTO
		        AccountsGetDto accountDTO = modelMapper.map(account, AccountsGetDto.class);
		        accountDTO.setUserEmail(account.getUser().getEmail()); // Manually set email

		        return ResponseEntity.ok(accountDTO);
	
	}
	}




	
	 

	

	
	

	

