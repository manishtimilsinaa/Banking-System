package com.codingmanish.BankingApp.controller;


import com.codingmanish.BankingApp.dto.AccountDto;
import com.codingmanish.BankingApp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")

public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService=accountService;

    }


    //ADD account Rest API
@PostMapping
    public ResponseEntity<AccountDto>addAccount(@RequestBody AccountDto accountDto){

        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);

    }
    //get account rest api
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountbyId(@PathVariable Long id){
        AccountDto accountDto=accountService.getAccountById(id);

        return ResponseEntity.ok(accountDto);
    }

    @PutMapping("/{id}/deposit")
    //Deposit rest api
    public ResponseEntity<AccountDto>deposit(@PathVariable Long id,
                                             @RequestBody Map<String ,Double>request){
        Double amount=request.get("amount");
        AccountDto accountDto= accountService.deposit(id,amount);
      return  ResponseEntity.ok(accountDto);
    }

//withdraw
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        double amount = request.get("amount");
        AccountDto accountDto = accountService.withdraw(id, amount); // Corrected method call to withdraw
        return ResponseEntity.ok(accountDto);
    }
    //Get ALL ACOOUNT rEsT api
    @GetMapping
    public  ResponseEntity<List<AccountDto>>getAllAccounts(){

        List<AccountDto> accounts=accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @DeleteMapping("/{id}")
    //dlete account rest api
    public  ResponseEntity<String>deleteAccount(Long id){

        accountService.deleteAccount(id);
        return ResponseEntity.ok("account is deleted");

    }

}
