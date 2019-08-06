package com.bankaccount.test;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.bank.account.controller.AccountController;
import com.bank.account.entity.Account;
import com.bank.account.model.ResponseMsg;
import com.bank.account.service.AccountService;

public class AccountControllerUnitTest {
    
	private MockMvc mockMvc;

    @Mock
    private AccountService accountService;
    
    @InjectMocks
    private AccountController accountController;
    
    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(accountController)
               // .addFilters(new CORSFilter())
                .build();
    }
    
    
    @Test
    public void test_get_accounts_by_userid_success() throws Exception {
        List<Account> accountsResponse = Arrays.asList(
                new Account(new Long(1), new Long(527689), "SavingsAccount", null,
            			"USD", new Float(500.26), "Testing Account1",
            			null, null,null),
                
                new Account(new Long(2), new Long(8783565), "CurrentAccount", null,
            			"USD", new Float(500.26), "Testing Account2",
            			null, null,null));

        when(accountService.getAccountsListByUserId("rama921@gmail.com")).thenReturn((ResponseMsg) accountsResponse);

        mockMvc.perform(get("/account/{userId}", "rama921@gmail.com"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].username", is("Daenerys Targaryen")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].username", is("John Snow")));

        verify(accountService, times(1)).getAccountsListByUserId("rama921@gmail.com");
        verifyNoMoreInteractions(accountService);
        
    }
    
}
