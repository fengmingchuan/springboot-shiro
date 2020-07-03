package com.shiro.shirodemo.service;


import com.shiro.shirodemo.vo.Account;

public interface AccountService {
    public Account findByUsername(String username);
}