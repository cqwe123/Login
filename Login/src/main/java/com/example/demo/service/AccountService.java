package com.example.demo.service;

import com.example.demo.pojo.Account;
import com.example.demo.utils.Result;

public interface AccountService {
    public Result<Account> findAccountByAccount(String account);
    public Result<String> login(String account,String password);
}
