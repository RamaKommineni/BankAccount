package com.bank.account.service;

import java.util.List;

import com.bank.account.exception.AccountException;
import com.bank.account.model.AccountDto;

public interface AccountService {
	public List<AccountDto> getAccountsListByUserId(String userId) throws AccountException;
	public AccountDto getTransactionsByAccountNumber(Long accountNumber) throws AccountException;
}
