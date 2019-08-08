package com.bank.account.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bank.account.entity.AccountTransaction;
import com.bank.account.model.AccountTransactionDto;

@Service
public class AccountTransactionServiceImpl implements AccountTransactionService {
	
	public AccountTransactionDto convertEntityToDto(AccountTransaction accountTransaction) {
		
		AccountTransactionDto accountTransactionDto = new AccountTransactionDto();
		accountTransactionDto.setId(accountTransaction.getId());
		accountTransactionDto.setTransactionType(accountTransaction.getTransactionTypeId().getName());
		accountTransactionDto.setCreditAmount(accountTransaction.getCreditAmount());
		accountTransactionDto.setDebitAmount(accountTransaction.getDebitAmount());
		accountTransactionDto.setValueDate(accountTransaction.getValueDate());
		accountTransactionDto.setNarrative(accountTransaction.getNarrative());
		
		return accountTransactionDto;
	}
	
	public List<AccountTransactionDto> convertListOfEntityToDto(List<AccountTransaction> accountTransactionList){
		
		List<AccountTransactionDto> accountTransactionDtoList = new ArrayList<AccountTransactionDto>();
		for(AccountTransaction accountTransaction: accountTransactionList) {
			accountTransactionDtoList.add(this.convertEntityToDto(accountTransaction));
		}
		
		return accountTransactionDtoList;
	}
	
}
