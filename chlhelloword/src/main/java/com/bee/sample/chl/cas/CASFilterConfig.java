//package com.bee.sample.chl.cas;
//
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.Filter;
//import java.util.HashMap;
//import java.util.Map;
///**
// * @author cyp
// * @version 1.0.0
// * @ClassName CASFilterConfig.java
// * @Description TODO
// * @createTime 2022年09月07日 13:56:00
// */
//@Configuration
//public class CASFilterConfig {
//
//    @Value("${cas.serverName}")
//    String serverName;
//    @Value("${cas.casServerUrlPrefix}")
//    String casServerUrlPrefix;
//    @Value("${cas.casServerLoginUrl}")
//    String casServerLoginUrl;
//
//    @Bean
//    public FilterRegistrationBean casFilterBean(){
//        Map params = new HashMap<String, String>();
//        FilterRegistrationBean registration = new FilterRegistrationBean();
//        registration.setFilter(casFilter());
//        registration.setName("testFilter1");
////        registration.addUrlPatterns("/sso/login");
//        registration.addUrlPatterns("/getAllbeans");
//        params.put("serverName",serverName);
//        params.put("casServerUrlPrefix", casServerUrlPrefix);
//        params.put("casServerLoginUrl",casServerLoginUrl);
//        params.put("loginUserHandle","com.bee.sample.chl.config.XframeAuthHandle");
//        params.put("skipUrls",".*/getToken,.*/getUser,/struts/.*,/resources/*,/style/.*,/images/*,/public/*,/js/*,.*css$,.*js$,.*jpg$,.*jpeg$,.*bmp$,.*png$,.*gif$,.*ico$,.*eot$,.*otf$,.*svg$,.*ttf$,.*vfb$,.*woff$");
//        params.put("singleSignOut","true");
//        registration.setInitParameters(params);
//        registration.setOrder(0);
//        return registration;
//    }
//
//    @Bean
//    Filter casFilter() {
//        return new OASSOFilter();
//    }
//
//
//}
