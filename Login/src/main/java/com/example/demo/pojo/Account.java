package com.example.demo.pojo;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data
public class Account {
    private String name;
    private String account;
    private String password;
    private String perms;
}
