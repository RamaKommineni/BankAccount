package com.bank.account.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.account.entity.Account;
import com.bank.account.exception.AccountException;
import com.bank.account.model.AccountDto;
import com.bank.account.repository.AccountRepo;

@Service
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	AccountTransactionService accountTransactionService;
	
	public List<AccountDto> getAccountsListByUserId(String userId) throws AccountException{
		
		if(userId == null || userId.equals(""))
			throw new AccountException("UserId is mandatory to get Accounts List");

		List<Account> accountsList = accountRepo.findByAccountUserIdLoginName(userId);
		
		return this.convertDtoList(accountsList, false);
	}
	
	public AccountDto getTransactionsByAccountNumber(Long accountNumber) throws AccountException {
		
		if(accountNumber == null)
			throw new AccountException("Account Number is mandatory to get Account details");
		
		Account account = accountRepo.findByAccountNumber(accountNumber);
		
		return this.convertToDto(account, true);
	}
	
	public Account getAccountByName(String accountName) {
		return accountRepo.findByAccountName(accountName);
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
		accountDto.setId(account.getId());
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
