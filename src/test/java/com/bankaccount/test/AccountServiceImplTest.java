package com.bankaccount.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;

import com.bank.account.entity.Account;
import com.bank.account.repository.AccountRepo;
import com.bank.account.service.AccountService;
import com.bank.account.service.AccountServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceImplTest {
	
	@TestConfiguration
    static class AccountServiceImplTestContextConfiguration {
  
        @Bean
        public AccountService accountService() {
            return new AccountServiceImpl();
        }
    }
	
    @Autowired
    private AccountService accountService;
 
    @MockBean
    private AccountRepo accountRepository;
    
    @Before
    public void setUp() {
        Account account = new Account(new Long(1), new Long(527689), "SavingsAccount", null,
    			null, new Float(500.26), null, null, null, null);
     
        Mockito.when(accountRepository.findByAccountName(account.getAccountName())).thenReturn(account);
    }
    
    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String accountName = "SavingsAccount";
        Account found = accountService.getAccountByName(accountName);
      
         assertThat(found.getAccountName())
          .isEqualTo(accountName);
     }

}
