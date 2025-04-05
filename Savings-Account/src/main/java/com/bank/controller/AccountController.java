package com.bank.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.bank.DTO.AccountDTO;
import com.bank.entity.Transaction;
import com.bank.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    // Create Account
    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        AccountDTO savedAccount = accountService.CreateAccount(accountDTO);
        return ResponseEntity.ok(savedAccount);
    }

    // Get Account Details
    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id) {
        AccountDTO accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    // Deposit Account Money
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDTO> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        if (!request.containsKey("amount")) {
            return ResponseEntity.badRequest().build(); // Handle missing amount gracefully
        }
        AccountDTO accountDto = accountService.deposite(id, request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    // Withdraw Money
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDTO> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        if (!request.containsKey("amount")) {
            return ResponseEntity.badRequest().build(); // Handle missing amount gracefully
        }
        AccountDTO accountDto = accountService.withdraw(id, request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    // Get All Accounts
    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAllAccounts() {
        List<AccountDTO> accountDtos = accountService.getAllAccounts();
        return ResponseEntity.ok(accountDtos);
    }

    // Delete Account
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account Deleted Successfully");
    }

    // Transaction History
    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<Transaction>> getTransactionHistory(@PathVariable Long id) {
        List<Transaction> transactions = accountService.getTransactionHistory(id);
        return ResponseEntity.ok(transactions);
    }
}
