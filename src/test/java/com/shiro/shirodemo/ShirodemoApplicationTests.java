package com.shiro.shirodemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shiro.shirodemo.dao.AccountMapper;
import com.shiro.shirodemo.vo.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ShirodemoApplicationTests {
   @Autowired
    private AccountMapper accountMapper;

    @Test
    void contextLoads() {
        QueryWrapper<Account> qw  = new QueryWrapper<>();
        qw.eq("username","zs");
        qw.eq("password","123123");
        Account account = accountMapper.selectOne(qw);
        System.out.println(account.toString());
    }

}
