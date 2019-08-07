package com.bank.account.service;

import com.bank.account.exception.AccountException;
import com.bank.account.model.ResponseMsg;

public interface AccountService {
	public ResponseMsg getAccountsListByUserId(String userId) throws AccountException;
	public ResponseMsg getAccountByAccountNumber(Long accountNumber);
}
