package com.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.app.Account.dto.AccountPostDTO;
import com.app.Account.dto.AccountsGetDto;
import com.app.dto.ApiResponse;
import com.app.dto.UserDTO;
import com.app.dto.UserPostDTO;
import com.app.entities.Accounts;
import com.app.entities.Product;

public interface AccountsService {
//sign up
	//UserDTO signupUser(UserDTO user);
	AccountsGetDto getAccountByEmail(String email);
	 ResponseEntity<?> addAccount(AccountPostDTO accountPostDTO);
	 public void deactivateAccount(Long accountId);
	void reactivateAccount(Long accountId);
	ResponseEntity<?> getAccountById(Long id);
	 ResponseEntity<?> getAccountByUserId(Long userId);
	
}
