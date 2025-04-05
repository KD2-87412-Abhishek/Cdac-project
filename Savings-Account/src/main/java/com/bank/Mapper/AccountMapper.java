package com.bank.Mapper;

import com.bank.DTO.AccountDTO;
import com.bank.entity.Account;

public class AccountMapper {
	
	public static Account mapToAccount(AccountDTO accountDto) {
	    Account account = new Account(
	            accountDto.getAccountid(),
	            accountDto.getAccountholdername(), // Correctly maps account_holder_name
	            accountDto.getBalance()
	    );
	    return account;
	}

	
	
	public static AccountDTO MapToAccountDto (Account account) {
		
		AccountDTO accountDto = new AccountDTO(
				account.getAccountid(),
				account.getAccount_holder_name(),
				account.getBalance()
				
				);
		
		return accountDto;
		
	}

}
