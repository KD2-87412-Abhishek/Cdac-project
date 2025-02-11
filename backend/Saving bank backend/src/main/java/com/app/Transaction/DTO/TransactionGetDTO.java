package com.app.Transaction.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.app.dto.BaseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class TransactionGetDTO  extends BaseDTO{
    
    private Long sourceAccountId;
    private Long destinationAccountId;
    private BigDecimal amount;
    private LocalDateTime transactionDate;

    
}