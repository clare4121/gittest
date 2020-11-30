//package com.cyp.gitnewmodulewhole.casLogin;
//
//
//import net.unicon.cas.client.configuration.CasClientConfigurationProperties;
//import net.unicon.cas.client.configuration.CasClientConfigurer;
//import org.jasig.cas.client.session.SingleSignOutHttpSessionListener;
//import org.jasig.cas.client.util.AssertionThreadLocalFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.CollectionUtils;
//
//import javax.servlet.Filter;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * Configuration class providing default CAS client infrastructure filters.
// * This configuration facility is typically imported into Spring's Application Context via
// * {@link net.unicon.cas.client.configuration.EnableCasClient EnableCasClient} meta annotation.
// *
// * @author Dmitriy Kopylenko
// * @see net.unicon.cas.client.configuration.EnableCasClient
// * @since 1.0.0
// */
//@Configuration
//@EnableConfigurationProperties(CasClientConfigurationProperties.class)
//public class CasClientConfiguration {
//
//    @Autowired
//    CasClientConfigurationProperties configProps;
//
//    @Value("${logoutUrl}")
//    private String serverLogoutUrl;
//
//    @Value("${skipUrls}")
//    private String serverSkipUrls;
//    @Value("${OAserverLoginUrl}")
//    private String OAserverLoginUrl;
//
//    private CasClientConfigurer casClientConfigurer;
//
//    @Bean
//    public FilterRegistrationBean ssoRegistrationBean() {
//        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
//        registrationBean.setFilter(new com.bonc.sso.client.SSOFilter());
//        registrationBean.setName("frameSsoFilter");
//        registrationBean.addInitParameter("serverName", this.configProps.getClientHostUrl());
//        registrationBean.addInitParameter("casServerUrlPrefix", this.configProps.getServerUrlPrefix());
//        registrationBean.addInitParameter("casServerLoginUrl", this.configProps.getServerLoginUrl());
//        registrationBean.addInitParameter("singleSignOut", "true");
//        registrationBean.addInitParameter("skipUrls", serverSkipUrls);
//        registrationBean.addInitParameter("OAserverLoginUrl", OAserverLoginUrl);
//        //registrationBean.addInitParameter("loginUserHandle", "com.bonc.security.sso.SSOAuthHandle");
//        registrationBean.addInitParameter("characterEncoding", "UTF-8");
//        registrationBean.addInitParameter("encoding", "UTF-8");
//        registrationBean.setOrder(1);
//        registrationBean.addUrlPatterns("/*");
//        return registrationBean;
//    }
//
//    @Bean
//    public ServletListenerRegistrationBean<SingleSignOutHttpSessionListener> httpSessionEventPublisher() {
//        return new ServletListenerRegistrationBean<org.jasig.cas.client.session.SingleSignOutHttpSessionListener>(new org.jasig.cas.client.session.SingleSignOutHttpSessionListener());
//    }
//
//    @Bean
//    public FilterRegistrationBean casAssertionThreadLocalFilter() {
//        final FilterRegistrationBean assertionTLFilter = new FilterRegistrationBean();
//        assertionTLFilter.setFilter(new AssertionThreadLocalFilter());
//        if (this.configProps.getAssertionThreadLocalUrlPatterns().size() > 0) {
//            assertionTLFilter.setUrlPatterns(this.configProps.getAssertionThreadLocalUrlPatterns());
//        }
//        assertionTLFilter.setOrder(4);
//
//        if (this.casClientConfigurer != null) {
//            this.casClientConfigurer.configureAssertionThreadLocalFilter(assertionTLFilter);
//        }
//        return assertionTLFilter;
//    }
//
//    @Autowired(required = false)
//    void setConfigurers(Collection<CasClientConfigurer> configurers) {
//        if (CollectionUtils.isEmpty(configurers)) {
//            return;
//        }
//        if (configurers.size() > 1) {
//            throw new IllegalStateException(configurers.size() + " implementations of " +
//                    "CasClientConfigurer were found when only 1 was expected. " +
//                    "Refactor the configuration such that CasClientConfigurer is " +
//                    "implemented only once or not at all.");
//        }
//        this.casClientConfigurer = configurers.iterator().next();
//    }
//
//    private Map<String, String> constructInitParams(final String casUrlParamName, final String casUrlParamVal, final String clientHostUrlVal) {
//        final Map<String, String> initParams = new HashMap<>(2);
//
//        initParams.put(casUrlParamName, casUrlParamVal);
//        initParams.put("serverName", clientHostUrlVal);
//
//        return initParams;
//    }
//
//    private void initFilter(final FilterRegistrationBean filterRegistrationBean,
//                            final Filter targetFilter,
//                            int filterOrder,
//                            final Map<String, String> initParams,
//                            List<String> urlPatterns) {
//
//        filterRegistrationBean.setFilter(targetFilter);
//        filterRegistrationBean.setOrder(filterOrder);
//        filterRegistrationBean.setInitParameters(initParams);
//        if (urlPatterns.size() > 0) {
//            filterRegistrationBean.setUrlPatterns(urlPatterns);
//        }
//    }
//}
