package com.bank.account.model;

import java.util.Date;
import java.util.List;

public class AccountDto {
	
	private Long id;
	private Long accountNo;
	private String accountName;
	private String accountType;
	private Float balance;
	private Date balanceDate;
	private List<AccountTransactionDto> accountTransactionDto;
	
	
	public AccountDto() {
		super();
	}

	public AccountDto(Long id, Long accountNo, String accountName, String accountType, Float balance, Date balanceDate,
			List<AccountTransactionDto> accountTransactionDto) {
		super();
		this.id = id;
		this.accountNo = accountNo;
		this.accountName = accountName;
		this.accountType = accountType;
		this.balance = balance;
		this.balanceDate = balanceDate;
		this.accountTransactionDto = accountTransactionDto;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(Long accountNo) {
		this.accountNo = accountNo;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	public Date getBalanceDate() {
		return balanceDate;
	}
	public void setBalanceDate(Date balanceDate) {
		this.balanceDate = balanceDate;
	}
	public List<AccountTransactionDto> getAccountTransactionDto() {
		return accountTransactionDto;
	}
	public void setAccountTransactionDto(List<AccountTransactionDto> accountTransactionDto) {
		this.accountTransactionDto = accountTransactionDto;
	}
	
}
