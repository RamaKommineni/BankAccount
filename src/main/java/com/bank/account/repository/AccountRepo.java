package com.bank.account.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bank.account.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, String>{
	
	List<Account> findByAccountUserIdLoginName(String userId);
	Account findByAccountNumber(Long accountNumber);
	Account findByAccountName(String accountName);
}
