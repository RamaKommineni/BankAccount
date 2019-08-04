package com.bank.account.service;

import com.bank.account.model.ResponseMsg;

public interface AccountService {
	public ResponseMsg getAccountsListByUserId(String userId);
	public ResponseMsg getAccountByAccountNumber(Long accountNumber);
}
