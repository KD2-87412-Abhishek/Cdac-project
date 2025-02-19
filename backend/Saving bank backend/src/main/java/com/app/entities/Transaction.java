package com.app.entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter

public class Transaction extends BaseEntity {
    

    private Long sourceAccountId; // ID of the account from which money is withdrawn
    private Long destinationAccountId; // ID of the account to which money is deposited
    private BigDecimal amount;
    @CreationTimestamp
    private LocalDateTime transactionDate;
}