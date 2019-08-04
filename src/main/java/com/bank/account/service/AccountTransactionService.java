package com.bank.account.service;

import java.util.List;

import com.bank.account.entity.AccountTransaction;
import com.bank.account.model.AccountTransactionDto;

public interface AccountTransactionService {
	
	public AccountTransactionDto convertEntityToDto(AccountTransaction accountTransaction);
	public List<AccountTransactionDto> convertListOfEntityToDto(List<AccountTransaction> accountTransactionList);

}
