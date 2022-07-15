//package com.bee.sample.chl.cas;
//
//import org.jasig.cas.client.Protocol;
//import org.jasig.cas.client.authentication.DefaultGatewayResolverImpl;
//import org.jasig.cas.client.authentication.GatewayResolver;
//import org.jasig.cas.client.util.AbstractCasFilter;
//import org.jasig.cas.client.util.CommonUtils;
//import org.jasig.cas.client.validation.Assertion;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//import java.io.IOException;
//
//
///**
// * @author cyp
// * @version 1.0.0
// * @ClassName AuthenticationFilter.java
// * @Description TODO
// * @createTime 2022年07月06日 10:59:00
// */
//public class AuthenticationFilterTwo extends AbstractCasFilter {
//    private String OAserverLoginUrl ="https://cn.bing.com/";
//    private String casServerLoginUrl ="https://www.baidu.com/";
//    private boolean renew = false;
//    private boolean gateway = false;
//    private GatewayResolver gatewayStorage = new DefaultGatewayResolverImpl();
//
//    protected AuthenticationFilterTwo(Protocol protocol) {
//        super(protocol);
//    }
//
//    public static  String getHost(HttpServletRequest request) {
//        String ip = request.getHeader("x-forwarded-for");
//        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//        return ip;
//    }
//
//
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//
//        HttpServletRequest request = (HttpServletRequest)servletRequest;
//        HttpServletResponse response = (HttpServletResponse)servletResponse;
//        HttpSession session = request.getSession(false);
//        Assertion assertion = session != null ? (Assertion)session.getAttribute("_const_cas_assertion_") : null;
//
//        if (assertion != null) {
//            filterChain.doFilter(request, response);
//        } else {
//            String serviceUrl = this.constructServiceUrl(request, response);
//            String ticket = CommonUtils.safeGetParameter(request, this.getProtocol().getArtifactParameterName());
//
//            boolean wasGatewayed = this.gatewayStorage.hasGatewayedAlready(request, serviceUrl);
//            System.out.println("ticket:"+ticket+"---wasGatewayed:"+wasGatewayed);
//            System.out.println("重新执行了ticket校验:" + serviceUrl);
//            if (!CommonUtils.isNotBlank(ticket)&&!wasGatewayed) {
//                String modifiedServiceUrl;
//                if (this.gateway) {
//
//                    modifiedServiceUrl = this.gatewayStorage.storeGatewayInformation(request, serviceUrl);
//                } else {
//                    modifiedServiceUrl = serviceUrl;
//                }
//
//                String host = getHost(request);
//                System.out.println("host=" + host);
//                String hostip = host.split("\\.")[0];
//                System.out.println("hostip:"+hostip);
//                System.out.println("获取配置oa域名"+OAserverLoginUrl);
//                String refererUrl = request.getHeader("referer");
//                System.out.println("refererUrl---"+refererUrl);
//                String hostUrlSub="";
//                if(refererUrl!=null&&!refererUrl.equals("")&&refererUrl.contains("/")&&refererUrl.contains(".")){
//                    //校验referer地址 获取host路径 拼接cas
//                    int subInt = refererUrl.indexOf("/",refererUrl.indexOf("."));
//                    hostUrlSub = refererUrl.substring(0,subInt);
//                    System.out.println("refererUrl域名："+hostUrlSub);
//                    casServerLoginUrl=hostUrlSub+"/cas/login";
//                }else if("10".equals(hostip)){
//                    //10网段地址重定向  解析host为10都会指向该地址
//                    System.out.println("10网段地址重定向");
////                        hostUrlSub = "http://unifiedprotal.10010sh.cn";
//                    casServerLoginUrl = OAserverLoginUrl+"/cas/login";
//                }
//
//                System.out.println("casServerLoginUrl"+casServerLoginUrl);
//                String urlToRedirectTo = CommonUtils.constructRedirectUrl(this.casServerLoginUrl, this.getProtocol().getArtifactParameterName(), modifiedServiceUrl, this.renew, this.gateway);
//
//
//
//                if (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").equals("XMLHttpRequest")) {
//                    response.setContentType("application/json;charset=UTF-8");
//                    response.getWriter().print("{'success':false,'message':'没有登录或登录超时,请重新登录.','loginUrl':" + urlToRedirectTo + "}");
//                } else {
//                    System.out.println("urlToRedirectTo重定向到------"+urlToRedirectTo);
//                    response.sendRedirect(urlToRedirectTo);
//                }
//
//            } else {
//                filterChain.doFilter(request, response);
//            }
//        }
//
//    }
//}
