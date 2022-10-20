//package com.bee.sample.chl.cas;
//
//import com.bonc.sso.client.SSOFilter;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class OASSOFilter extends SSOFilter {
//
//	@Value("${spring.profiles.active}")
//	String profile;
//
//	private static final Logger log = LoggerFactory.getLogger(OASSOFilter.class);
//	@Override
//	public void doFilter(ServletRequest servletRequest,
//                         ServletResponse servletResponse, FilterChain chain)
//			throws IOException, ServletException {
//		//如果是生产环境做CASdev
//		if("prod".equals(profile)) {
//			HttpServletResponse res = (HttpServletResponse) servletResponse;
//			res.addHeader("Access-Control-Allow-Origin", "*");
//	        res.addHeader("Access-Control-Allow-Methods", "*");
//			log.info("执行doFilter方法...");
//			log.info("doFilter方法放行...");
//			super.doFilter(servletRequest, servletResponse, chain);
//		} else {//如果是测试环境跳过
//			chain.doFilter(servletRequest, servletResponse);
//		}
//	}
//}
