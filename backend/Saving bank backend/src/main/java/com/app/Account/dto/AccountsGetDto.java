package com.app.Account.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.app.dto.BaseDTO;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AccountsGetDto  extends BaseDTO{
	
    private String accountNumber;
    private String accountType;
    private BigDecimal balance;
    @JsonProperty
    private boolean isActive;
    private LocalDateTime createdAt;
    private String userEmail;

}
