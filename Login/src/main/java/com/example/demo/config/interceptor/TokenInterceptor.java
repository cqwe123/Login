package com.example.demo.config.interceptor;

import com.example.demo.utils.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        try {
            System.out.println("try:   " + token);
            JwtUtil.parseToken(token);
            return true;
        }catch (Exception e){
           response.sendRedirect("http://localhost:8081/#/login");
           return false;
        }
    }
}
