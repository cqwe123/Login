package com.example.demo.service.Impl;

import com.example.demo.mapper.AccountMapper;
import com.example.demo.pojo.Account;
import com.example.demo.service.AccountService;
import com.example.demo.utils.JwtUtil;
import com.example.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;
    @Override
    public Result<Account> findAccountByAccount(String account) {
        Account account1 = accountMapper.findAccountByaccount(account);
        if(account1 == null){
            return Result.error("账号错误");
        }else {
            account1.setPassword("*******");
            return Result.success(account1);
        }
    }

    @Override
    public Result<String> login(String account,String password) {
        Account account1 = accountMapper.findAccountByaccount(account);
        Map<String,Object> claims = new HashMap<>();
        claims.put("account",account1.getAccount());
        claims.put("name",account1.getName());
        claims.put("Perms",account1.getPerms());
        if(password.equals(account1.getPassword())){
           return Result.success(JwtUtil.genToken(claims));
        }else {
            return Result.error("密码错误");
        }
    }
}
