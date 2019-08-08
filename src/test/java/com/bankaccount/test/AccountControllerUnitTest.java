package com.bankaccount.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.bank.account.BankAccountApplication;
import com.bank.account.controller.AccountController;
import com.bank.account.model.AccountDto;
import com.bank.account.service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BankAccountApplication.class)
public class AccountControllerUnitTest {
    
	private MockMvc mockMvc;
	
    @Autowired
    protected WebApplicationContext wac;
	
    @Autowired
    private AccountController accountController;

    @Mock
    private AccountService accountService;
    
    @Before
    public void init(){
    	this.mockMvc = standaloneSetup(this.accountController).build();
    }
    
    @Test
    public void test_get_accounts_by_userid_success() throws Exception {
    	
        List<AccountDto> accountsResponse = Arrays.asList(
                new AccountDto(new Long(1), new Long(527689), "SavingsAccount", null,
            			new Float(500.26), null, null),
                
                new AccountDto(new Long(2), new Long(8783565), "CurrentAccount", null,
            			new Float(500.26), null, null));
              
        when(accountService.getAccountsListByUserId("rama921@gmail.com")).thenReturn(accountsResponse);

        mockMvc.perform(get("/account/{userId}", "rama921@gmail.com").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                //.andExpect(jsonPath("$", hasSize(2)));
                //.andExpect(jsonPath("$[0]responseMs.id", is(1)))
                //.andExpect(jsonPath("$[0].username", is("Daenerys Targaryen")))
                //.andExpect(jsonPath("$[1].id", is(2)))
                //.andExpect(jsonPath("$[1].username", is("John Snow")));

        //verify(accountService, times(1)).getAccountsListByUserId("rama921@gmail.com"); 
        //verifyNoMoreInteractions(accountService);
        
    }
    
}
