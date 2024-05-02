package com.codingmanish.BankingApp.service;

import com.codingmanish.BankingApp.dto.AccountDto;

import java.util.List;
//import com.codingmanish.BankingApp.entity.Account;

public interface AccountService {


    AccountDto createAccount(AccountDto accountDto);
AccountDto getAccountById(Long id);

AccountDto deposit(Long id, double amount);

AccountDto withdraw(Long id,double amount);

List<AccountDto>getAllAccounts();
void deleteAccount(Long id);

}
