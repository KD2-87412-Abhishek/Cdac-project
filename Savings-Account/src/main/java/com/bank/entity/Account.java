package com.bank.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name ="accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountid;
	
	
	@Column(name = "account_holder_name", nullable = false)
	private String account_holder_name;
	
	private double balance;
	
	@Version
	private Integer version;
	
	

	public Account(Long accountid, String account_holder_name, double balance, Integer version) {
		super();
		this.accountid = accountid;
		this.account_holder_name = account_holder_name;
		this.balance = balance;
		this.version = version;
	}
	
	

	public Account(Long accountid, String account_holder_name, double balance) {
		super();
		this.accountid = accountid;
		this.account_holder_name = account_holder_name;
		this.balance = balance;
	}



	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getAccountid() {
		return accountid;
	}

	public void setAccountid(Long accountid) {
		this.accountid = accountid;
	}

	public String getAccount_holder_name() {
		return account_holder_name;
	}

	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	
	
	
	
	
	

}
