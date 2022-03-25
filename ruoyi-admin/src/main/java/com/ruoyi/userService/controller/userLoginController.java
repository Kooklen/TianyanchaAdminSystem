package com.ruoyi.userService.controller;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginBody;
import com.ruoyi.userService.domin.userLogin;
//import com.ruoyi.userService.service.userLoginService;
import com.ruoyi.userService.utils.JwtUtil;
import com.ruoyi.userService.utils.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller

@RequestMapping("userservice")
public class userLoginController {
//    @Autowired
//    private userLoginService service;

    @GetMapping("login")
    public void login(){
        System.out.println("success");
    }


    private final String userid="123123";
    private final String password="122133";
    //用户登录
    @PostMapping("login")
    public userLogin login(userLogin userlogin){
        if(userid.equals(userlogin.getUserid()) && password.equals(userlogin.getPassword())){
            userlogin.setToken(JwtUtil.createJWT(userid)); ;
            userlogin.getToken();
            System.out.println(userlogin.getToken());
            return userlogin;
        }
        return null;
    }
    @GetMapping("/checktoken")
    public Boolean checktoken(HttpServletRequest request){
        String token = request.getHeader("token");
        return JwtUtil.checkToken(token);
    }
}
