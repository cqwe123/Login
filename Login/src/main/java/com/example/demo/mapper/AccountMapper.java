package com.example.demo.mapper;

import com.example.demo.pojo.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccountMapper{
    @Select("select * from Account where account = #{account}")
    public Account findAccountByaccount(String account);
}
