package com.shiro.shirodemo.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shiro.shirodemo.dao.AccountMapper;
import com.shiro.shirodemo.service.AccountService;
import com.shiro.shirodemo.vo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountMapper accountMapper;

    @Override
    public Account findByUsername(String username) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username", username);
        return accountMapper.selectOne(wrapper);
    }
}