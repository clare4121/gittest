package com.bee.sample.chl.InterceptorConfig;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName AuthenticationInterceptor.java
 * @Description TODO
 * @createTime 2022年10月20日 10:27:00
 */
public class AuthenticationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token =request.getHeader("token");
        System.out.println("获取token值为----------------->"+token);
        boolean b="a".equals(token);
        System.out.println("token校验结果------------>"+b);
        return b;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
