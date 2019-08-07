package com.bank.account.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.exception.AccountException;
import com.bank.account.model.AccountDto;
import com.bank.account.model.ResponseMsg;
import com.bank.account.service.AccountService;

@RestController
@RequestMapping(value="account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/{userId}", method= RequestMethod.GET)
	public ResponseEntity<ResponseMsg> getAccountsListByUserId(HttpServletRequest request, @PathVariable String userId) {
		try {
			List<AccountDto> accountList = accountService.getAccountsListByUserId(userId);
			ResponseMsg responseMsg = new ResponseMsg(1, "SUCCESS", accountList,"");
			
			return new ResponseEntity<ResponseMsg>(responseMsg, HttpStatus.OK);
		}catch(AccountException e) {
			ResponseMsg responseMsg = new ResponseMsg(-1, "ERROR", null, e.getMessage());
			return new ResponseEntity<ResponseMsg>(responseMsg, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/{accountNumber}/transactions", method= RequestMethod.GET)
	public ResponseEntity<ResponseMsg> getAccountByAccountNumber(HttpServletRequest request, @PathVariable Long accountNumber) {
		try {
			AccountDto accountDto = accountService.getTransactionsByAccountNumber(accountNumber);
			ResponseMsg responseMsg = new ResponseMsg(1, "SUCCESS", accountDto, null);
			
			return new ResponseEntity<ResponseMsg>(responseMsg, HttpStatus.OK);
		}catch(AccountException e) {
			
			ResponseMsg responseMsg = new ResponseMsg(-1, "ERROR", null, e.getMessage());
			return new ResponseEntity<ResponseMsg>(responseMsg, HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
}
