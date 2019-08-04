package com.bank.account.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bank.account.model.ResponseMsg;
import com.bank.account.service.AccountService;

@RestController
@RequestMapping(value="account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@RequestMapping(value="/{userId}", method= RequestMethod.GET)
	public ResponseEntity<ResponseMsg> getAccountsListByUserId(HttpServletRequest request, @PathVariable String userId) {
		
		ResponseMsg responseMsg = accountService.getAccountsListByUserId(userId);
		
		return new ResponseEntity<ResponseMsg>(responseMsg, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{accountNumber}/transactions", method= RequestMethod.GET)
	public ResponseEntity<ResponseMsg> getAccountByAccountNumber(HttpServletRequest request, @PathVariable Long accountNumber) {
		
		ResponseMsg responseMsg = accountService.getAccountByAccountNumber(accountNumber);
		
		return new ResponseEntity<ResponseMsg>(responseMsg, HttpStatus.OK);
	}
	
	
}
