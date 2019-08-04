package com.bank.account.model;

import java.util.Date;
import java.util.List;

public class AccountDto {
	
	private Long accountNo;
	private String accountName;
	private String accountType;
	private Float balance;
	private Date balanceDate;
	private List<AccountTransactionDto> accountTransactionDto;
	
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
