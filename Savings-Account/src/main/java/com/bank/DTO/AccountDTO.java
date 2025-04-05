package com.bank.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountDTO {

    private Long accountid;
    
    @JsonProperty("accountHolderName") // Map JSON field to this DTO field
    private String account_holder_name;
    
    private double balance;

    public AccountDTO(Long accountid, String account_holder_name, double balance) {
        this.accountid = accountid;
        this.account_holder_name = account_holder_name;
        this.balance = balance;
    }

    public Long getAccountid() {
        return accountid;
    }

    public void setAccountid(Long accountid) {
        this.accountid = accountid;
    }

    public String getAccountholdername() {
        return account_holder_name;
    }

    public void setAccountholdername(String account_holder_name) {
        this.account_holder_name = account_holder_name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountDTO() {
        super();
    }
}
