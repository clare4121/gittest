package com.cyp.gitnewmodulewhole.casLogin;

import org.jasig.cas.client.authentication.DefaultGatewayResolverImpl;
import org.jasig.cas.client.authentication.GatewayResolver;
import org.jasig.cas.client.util.AbstractCasFilter;
import org.jasig.cas.client.util.CommonUtils;
import org.jasig.cas.client.validation.Assertion;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import javax.servlet.*;

public class AuthenticationFilter extends AbstractCasFilter {

    private String  OAserverLoginUrl;
    public static long lastAccessTime = 0L;
    public static long sessionCreateTime = 0L;
    private String casServerLoginUrl;
    private boolean renew = false;
    private boolean gateway = false;
    private GatewayResolver gatewayStorage = new DefaultGatewayResolverImpl();


    protected void initInternal(FilterConfig filterConfig) throws ServletException {
        if (!this.isIgnoreInitConfiguration()) {
            super.initInternal(filterConfig);
            this.setCasServerLoginUrl(this.getPropertyFromInitParams(filterConfig, "casServerLoginUrl", (String)null));
            this.log.trace("Loaded CasServerLoginUrl parameter: " + this.casServerLoginUrl);
            this.setOAserverLoginUrl(this.getPropertyFromInitParams(filterConfig, "OAserverLoginUrl", (String)null));
            this.log.trace("Loaded OAserverLoginUrl parameter: " + this.OAserverLoginUrl);


            this.setRenew(this.parseBoolean(this.getPropertyFromInitParams(filterConfig, "renew", "false")));
            this.log.trace("Loaded renew parameter: " + this.renew);
            this.setGateway(this.parseBoolean(this.getPropertyFromInitParams(filterConfig, "gateway", "false")));
            this.log.trace("Loaded gateway parameter: " + this.gateway);
            String gatewayStorageClass = this.getPropertyFromInitParams(filterConfig, "gatewayStorageClass", (String)null);

            if (gatewayStorageClass != null) {
                try {
                    this.gatewayStorage = (GatewayResolver)Class.forName(gatewayStorageClass).newInstance();
                } catch (Exception var4) {
                    this.log.error(var4, var4);
                    throw new ServletException(var4);
                }
            }
        }

    }

    public void init() {
        super.init();
        CommonUtils.assertNotNull(this.casServerLoginUrl, "casServerLoginUrl cannot be null.");
    }

    public final void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession(false);
        Assertion assertion = session != null ? (Assertion)session.getAttribute("_const_cas_assertion_") : null;
        if (assertion != null) {
            filterChain.doFilter(request, response);
        } else {
            String serviceUrl = this.constructServiceUrl(request, response);
            String ticket = CommonUtils.safeGetParameter(request, this.getArtifactParameterName());
            boolean wasGatewayed = this.gatewayStorage.hasGatewayedAlready(request, serviceUrl);
            System.out.println("ticket:"+ticket+"---wasGatewayed:"+wasGatewayed);
            System.out.println("重新执行了ticket校验:" + serviceUrl);
            if (!CommonUtils.isNotBlank(ticket)&&!wasGatewayed) {
                this.log.debug("no ticket and no assertion found");
                String modifiedServiceUrl;
                if (this.gateway) {
                    this.log.debug("setting gateway attribute in session");
                    modifiedServiceUrl = this.gatewayStorage.storeGatewayInformation(request, serviceUrl);
                } else {
                    modifiedServiceUrl = serviceUrl;
                }

                if (this.log.isDebugEnabled()) {
                    this.log.debug("Constructed service url: " + modifiedServiceUrl);
                }
                String host = getHost(request);
                System.out.println("host=" + host);
                String hostip = host.split("\\.")[0];
                System.out.println("hostip:"+hostip);
                System.out.println("获取配置oa域名"+OAserverLoginUrl);
                String refererUrl = request.getHeader("referer");
                System.out.println("refererUrl---"+refererUrl);
                String hostUrlSub="";
                if(refererUrl!=null&&!refererUrl.equals("")&&refererUrl.contains("/")&&refererUrl.contains(".")){
                    //校验referer地址 获取host路径 拼接cas
                    int subInt = refererUrl.indexOf("/",refererUrl.indexOf("."));
                    hostUrlSub = refererUrl.substring(0,subInt);
                    System.out.println("refererUrl域名："+hostUrlSub);
                    casServerLoginUrl=hostUrlSub+"/cas/login";
                }else if("10".equals(hostip)){
                    //10网段地址重定向  解析host为10都会指向该地址
                    System.out.println("10网段地址重定向");
//                        hostUrlSub = "http://unifiedprotal.10010sh.cn";
                    casServerLoginUrl = OAserverLoginUrl+"/cas/login";
                }

                System.out.println("casServerLoginUrl"+casServerLoginUrl);
                String urlToRedirectTo = CommonUtils.constructRedirectUrl(this.casServerLoginUrl, this.getServiceParameterName(), modifiedServiceUrl, this.renew, this.gateway);

                if (this.log.isDebugEnabled()) {
                    this.log.debug("redirecting to \"" + urlToRedirectTo + "\"");
                }
                //if(RequestUtil.isAjaxReq(request)){//如果是ajax请求
                //    response.setStatus(9009);
                //}else{//不是ajax请求
                //    response.sendRedirect(urlToRedirectTo);
                //}

                if (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").equals("XMLHttpRequest")) {
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().print("{'success':false,'message':'没有登录或登录超时,请重新登录.','loginUrl':" + urlToRedirectTo + "}");
                } else {
                    System.out.println("urlToRedirectTo重定向到------"+urlToRedirectTo);
                    response.sendRedirect(urlToRedirectTo);
                }

            } else {
                filterChain.doFilter(request, response);
            }
        }
    }
    public static  String getHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public final void setRenew(boolean renew) {
        this.renew = renew;
    }

    public final void setGateway(boolean gateway) {
        this.gateway = gateway;
    }

    public final void setCasServerLoginUrl(String casServerLoginUrl) {
        this.casServerLoginUrl = casServerLoginUrl;
    }

    public final void setGatewayStorage(GatewayResolver gatewayStorage) {
        this.gatewayStorage = gatewayStorage;
    }
    public String getOAserverLoginUrl() {
        return OAserverLoginUrl;
    }

    public void setOAserverLoginUrl(String OAserverLoginUrl) {
        this.OAserverLoginUrl = OAserverLoginUrl;
    }
}
