//package com.ruoyi.userService.service.impl;
//
//import com.alibaba.fastjson.JSON;
//import com.ruoyi.common.core.domain.entity.SysUser;
//import com.ruoyi.common.utils.StringUtils;
//import com.ruoyi.userService.domin.userLogin;
//import com.ruoyi.userService.mapper.userLoginMapper;
//import com.ruoyi.userService.service.userLoginService;
//import com.ruoyi.userService.utils.JwtUtil;
//import com.ruoyi.userService.vo.HttpStatusEnum;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//import com.ruoyi.userService.vo.Result;
//import org.springframework.util.DigestUtils;
//
//import javax.annotation.Resource;
//import java.util.concurrent.TimeUnit;
//
//@Service
//public class userLoginImpl implements userLoginService {
//
//    //植入dao层对象
//    @Resource(name = "userLoginMapper")
//    private userLoginMapper userloginmapper;
//
//
//    @Autowired
//    private userLoginService service;
//
//    @Autowired
//    private RedisTemplate<String,String> redisTemplate;
////    @Override
////    public userLogin login(int userid, String password) {
////        return userloginmapper.login(userid,password);
////    }
//
////    @Override
//    public Result login(userLogin userlogin) {
//        String userid = userlogin.getUserid();
//        String password = userlogin.getPassword();
//        if(StringUtils.isBlank(userid) || StringUtils.isBlank(password)){
//            return Result.fail(HttpStatusEnum.ERROR_IDANDPWD,"参数不合法");
//        }
////        SysUser sysuser = service.findUser(userid,password);
////        password = DigestUtils.md5DigestAsHex()
//
//
//        if(sysuser==null){
//            return Result.fail(HttpStatusEnum.ERROR_IDANDPWDd,"ID或密码错误");
//        }
//        String token = JwtUtil.createJWT(userid);
//        redisTemplate.opsForValue().set("TOKEN_"+token, JSON.toJSONString(sysuser),1, TimeUnit.DAYS);
//        return Result.success(token);
//    }
//
//    private class sysUser {
//    }
//}