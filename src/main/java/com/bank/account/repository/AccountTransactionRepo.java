package com.bank.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.account.entity.AccountTransaction;

@Repository
public interface AccountTransactionRepo extends JpaRepository<AccountTransaction, String>{
	
	
}
