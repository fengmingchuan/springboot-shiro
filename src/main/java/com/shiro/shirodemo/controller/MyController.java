package com.shiro.shirodemo.controller;


import com.shiro.shirodemo.vo.Account;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class MyController {

    @GetMapping("/{url}")
    public String redirect(@PathVariable("url") String url){
        return url;
    }
    @GetMapping("/login")
    public String login(String username, String password, Model model){
        Subject subject = SecurityUtils.getSubject();//进入页面前获取是否登陆账号
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);//根据用户名称获取token
        try {
            subject.login(token);//登陆
            Account account = (Account) subject.getPrincipal();//获取用户信息
            subject.getSession().setAttribute("account",account);//把账户信息放进session
            return "inde"; //
        } catch (UnknownAccountException e) {
            model.addAttribute("msg","用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }

}