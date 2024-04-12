package com.example.demo.controller;

import com.example.demo.pojo.Account;
import com.example.demo.service.AccountService;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Pattern;

@RestController
@Validated
public class LoginConroller {
    @Autowired
    AccountService accountService;
    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,12}$") String username, @Pattern(regexp = "^\\S{5,12}$") String password){
       return accountService.login(username,password);
    }
    @GetMapping("/findAccount")
    public Result<Account> find(String account){
        return accountService.findAccountByAccount(account);
    }
}
