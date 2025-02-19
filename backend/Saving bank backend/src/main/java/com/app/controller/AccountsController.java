package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Account.dto.AccountPostDTO;
import com.app.Account.dto.AccountsGetDto;
import com.app.dto.UserDTO;
import com.app.dto.UserPostDTO;
import com.app.service.AccountsService;
import com.app.service.UserService;

import jakarta.validation.Valid;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/accounts")

public class AccountsController {
	@Autowired
	AccountsService accountsService;

	 // ✅ Get Account by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(accountsService.getAccountById(id));
    }

    // ✅ Get Account by Email
    @GetMapping("/email/{email}")
    public ResponseEntity<?> getAccountByEmail(@PathVariable String email) {
        return ResponseEntity.ok(accountsService.getAccountByEmail(email));
    }

    //✅ Add Account
    @PostMapping("/add")
    public ResponseEntity<?> addAccount(@RequestBody @Valid AccountPostDTO accountPostDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(accountsService.addAccount(accountPostDTO));
   }
    // 
    @PutMapping("/deactivate/{accountId}")
    public ResponseEntity<?> deactivateAccount(@PathVariable Long accountId) {
        accountsService.deactivateAccount(accountId);
        return ResponseEntity.ok("Account deactivated successfully");
    }
    @PutMapping("/reactivate/{accountId}")
    public ResponseEntity<?> reactivateAccount(@PathVariable Long accountId) {
        accountsService.reactivateAccount(accountId);
        return ResponseEntity.ok("Account reactivated successfully");
    }
    
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getAccountByUserId(@PathVariable Long userId) {
        return accountsService.getAccountByUserId(userId);
    }
    
}
    
