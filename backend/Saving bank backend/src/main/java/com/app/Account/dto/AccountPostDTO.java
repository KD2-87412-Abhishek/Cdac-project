package com.app.Account.dto;

import java.math.BigDecimal;

import com.app.dto.BaseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountPostDTO extends BaseDTO {
//	 private String accountNumber;
	    
	    private BigDecimal balance;
	    private Long userId; 
	    private boolean isActive;
	    

}
