package com.example.demo.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private static final String KEY = "205612";

    //接收业务数据，生成Token并返回
    public static String genToken(Map<String,Object> claims){
        return JWT.create()
                .withClaim("claims",claims)//添加载荷
                .withExpiresAt(new Date(System.currentTimeMillis()+1000*60*60*3))//添加Token有效时间
                .sign(Algorithm.HMAC256(KEY));
    }

    //接收业务数据，生成Token并返回
    public static Map<String, Object> parseToken(String token){
        return JWT.require(Algorithm.HMAC256(KEY))
                .build()
                .verify(token)
                .getClaim("claims")
                .asMap();
    }
//
//    public static void main(String[] args) {
//        Map<String,Object> map = new HashMap<>();
//        map.put("id",1);
//        map.put("username","csb");
//        String token = JwtUtil.genToken(map);
//        System.out.println(token);
//        Map<String,Object> student = new HashMap<>();
//        student = JwtUtil.parseToken(token);
//        System.out.println(student.get("id")+"   "+student.get("username"));
//    }
}

