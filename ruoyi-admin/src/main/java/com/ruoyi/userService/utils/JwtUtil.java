package com.ruoyi.userService.utils;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    /**
     * 生成jwt
     * 使用Hs256算法, 私匙使用固定JWT_SEC秘钥
     *
     * @param jwtSec    jwt秘钥 此秘钥一定要保留好在服务端, 不能暴露出去, 否则sign就可以被伪造, 如果对接多个客户端建议改造成多个
     * @param ttlMillis jwt过期时间(毫秒)
     * @param userid  用户名 可根据需要传递的信息添加更多, 因为浏览器get传参url限制，不建议放置过多的参数
     * @return
     */
    private static final String jwtToken = "123dianyanchauser456";

    public static String createJWT(String userid) {

        // 创建payload的私有声明（根据特定的业务需要添加）
        Map<String, Object> claims = new HashMap<>();
        claims.put("userid", userid);

        // 指定签名的时候使用的签名算法，也就是header那部分
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        JwtBuilder jwtBuilder = Jwts.builder()
                .signWith(signatureAlgorithm, jwtToken)
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 60 * 1000));
        String token = jwtBuilder.compact();
        return token;
    }

    public static boolean checkToken(String token) {
        if(token==null){
            return false;
        }
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(jwtToken).parseClaimsJws(token);
        }catch (Exception e){
            return false;
        }
        return true;
    }}