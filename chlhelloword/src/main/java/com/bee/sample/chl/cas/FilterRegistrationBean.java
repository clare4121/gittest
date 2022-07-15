//package com.bee.sample.chl.cas;
//
//import org.jasig.cas.client.authentication.AuthenticationFilter;
//import org.springframework.context.annotation.Bean;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author cyp
// * @version 1.0.0
// * @ClassName FilterRegistrationBean.java
// * @Description TODO
// * @createTime 2022年07月08日 17:03:00
// */
//public class FilterRegistrationBean {
//    @Bean
//    public FilterRegistrationBean filterAuthenticationRegistration() {
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(new AuthenticationFilter());
//        registration.addUrlPatterns("/*");
//        Map<String, String> initParameters = new HashMap<String, String>(3);
//        initParameters.put("casServerLoginUrl", casProperties.getCasServerUrl());
//        initParameters.put("serverName", casProperties.getClientHostUrl());
//        // 自定义重定向策略
//        initParameters.put("authenticationRedirectStrategyClass", "package.CustomAuthenticationRedirectStrategy");
//        initParameters.put("ignorePattern", casProperties.getIgnoreUrl());
//        registration.setInitParameters(initParameters);
//        registration.setOrder(1);
//        return registration;
//    }
//}
