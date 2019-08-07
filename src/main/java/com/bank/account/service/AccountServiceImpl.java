package com.bank.account.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.account.entity.Account;
import com.bank.account.exception.AccountException;
import com.bank.account.model.AccountDto;
import com.bank.account.model.ResponseMsg;
import com.bank.account.repository.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	AccountTransactionService accountTransactionService;
	
	public ResponseMsg getAccountsListByUserId(String userId) throws AccountException{
		
		List<Account> accountsList = accountRepo.findByAccountUserIdLoginName(userId);
		
		if(accountsList == null)
			throw new AccountException("Accounts do not exist with name:"+ userId);
		
		return new ResponseMsg(1, "SUCCESS", convertDtoList(accountsList, false), "","","");
	}
	
	public ResponseMsg getAccountByAccountNumber(Long accountNumber) {
		
		Account account = accountRepo.findByAccountNumber(accountNumber);
		
		return new ResponseMsg(1, "SUCCESS", convertToDto(account, true), "","","");
	}
	
	private List<AccountDto> convertDtoList(List<Account> accountsList, Boolean includeTransactions){
		List<AccountDto> accountDtoList = new ArrayList<AccountDto>();
		
		for(Account account :accountsList) {
			accountDtoList.add(convertToDto(account, includeTransactions));
		}
		
		return accountDtoList;
	}
	
	private AccountDto convertToDto(Account account, Boolean includeTransactions) {
	    //AccountDto accountDto = modelMapper.map(account, AccountDto.class);
		AccountDto accountDto = new AccountDto();
		accountDto.setAccountNo(account.getAccountNumber());
		accountDto.setAccountName(account.getAccountName());
		accountDto.setAccountType(account.getAccountTypeId().getName());
		accountDto.setBalance(account.getBalance());
		accountDto.setBalanceDate(account.getBalanceDate());
		
		if(includeTransactions == false)
			return accountDto;
		
		accountDto.setAccountTransactionDto(accountTransactionService.convertListOfEntityToDto((List)account.getAccountTransactionCollection()));
		
	    return accountDto;
	}
}
