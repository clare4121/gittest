//package com.cyp.gitnewmodulewhole.util.util.util;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import lombok.Builder;
//import lombok.ToString;
//import lombok.experimental.UtilityClass;
//import lombok.extern.slf4j.Slf4j;
//import okhttp3.*;
//import org.apache.commons.collections4.MapUtils;
//import org.apache.commons.lang.ArrayUtils;
//import org.apache.http.ParseException;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.ContentType;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.util.EntityUtils;
//import org.springframework.util.StringUtils;
//
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.concurrent.TimeUnit;
//import java.util.stream.Collectors;
//
///**
// * @author zhaoxuan
// * @description OkHttp工具类
// * @createTime 2020/5/14 6:32 下午
// */
//@Slf4j
//@UtilityClass
//public class OkHttpUtiltest {
//
//    public final String GET = "GET";
//
//    public final String POST = "POST";
//
//    public final String PUT = "PUT";
//
//    public final String DELETE = "DELETE";
//
//    public final String PATCH = "PATCH";
//
//    private final String UTF8 = "UTF-8";
//
//    private final String GBK = "GBK";
//
//    private final String DEFAULT_CHARSET = UTF8;
//
//    private final String DEFAULT_METHOD = GET;
//
//    private final String DEFAULT_MEDIA_TYPE = "application/json";
//
//    private final boolean DEFAULT_LOG = false;
//
//    private final OkHttpClient client = new OkHttpClient.Builder().connectionPool(
//            new ConnectionPool(20, 5, TimeUnit.MINUTES)).readTimeout(100, TimeUnit.SECONDS).connectTimeout(
//            100, TimeUnit.SECONDS).build();
//
//
//    //测试一波
//    public void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("k", "v");
//        try {
//            String s = execute(OkHttp.builder().url("http://www.baidu.com").method(GET).requestLog(
//                    true).responseLog(true).build());
//            System.out.println(s);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * GET请求
//     *
//     * @param url URL地址
//     * @return
//     */
//    public String get(String url)
//            throws Exception {
//        return execute(OkHttp.builder().url(url).build());
//    }
//
//    /**
//     * GET请求
//     *
//     * @param url URL地址
//     * @return
//     */
//    public String get(String url, String charset)
//            throws Exception {
//        return execute(OkHttp.builder().url(url).responseCharset(charset).build());
//    }
//
//    /**
//     * 带查询参数的GET查询
//     *
//     * @param url      URL地址
//     * @param queryMap 查询参数
//     * @return
//     */
//    public String get(String url, Map<String, String> queryMap)
//            throws Exception {
//        return execute(OkHttp.builder().url(url).queryMap(queryMap).build());
//    }
//
//    /**
//     * 带查询参数的GET查询
//     *
//     * @param url      URL地址
//     * @param queryMap 查询参数
//     * @return
//     */
//    public String get(String url, Map<String, String> queryMap, String charset)
//            throws Exception {
//        return execute(OkHttp.builder().url(url).queryMap(queryMap).responseCharset(charset).build());
//    }
//
//    /**
//     * POST application/json
//     *
//     * @param url
//     * @param obj
//     * @return
//     */
//    public String postJson(String url, Object obj)
//            throws Exception {
//        Map map =new HashMap();
//        map.put("Content-Type","application/json");
//        map.put("Accept","application/json");
//        map.put("Accept-Encoding","gzip");
//       //  map.put("Content-Length","<calculated when request is sent>");
////        return execute(OkHttp.builder().url(url).method(POST).data(JSON.toJSONString(obj)).headerMap(map).build());
//        return execute(OkHttp.builder().url(url).method(POST).data(JSON.toJSONString(obj)).mediaType(
//                "application/json").headerMap(map).build());
//    }
//
//    /**
//     * POST application/x-www-form-urlencoded
//     *
//     * @param url
//     * @param formMap
//     * @return
//     */
//    public String postForm(String url, Map<String, String> formMap)
//            throws Exception {
//        String data = "";
//        if (MapUtils.isNotEmpty(formMap)) {
//            data = formMap.entrySet().stream().map(
//                    entry -> String.format("%s=%s", entry.getKey(), entry.getValue())).collect(
//                    Collectors.joining("&"));
//        }
//        return execute(OkHttp.builder().url(url).method(POST).data(data).mediaType(
//                "application/x-www-form-urlencoded").build());
//    }
//
//    private String post(String url, String data, String mediaType, String charset)
//            throws Exception {
//        return execute(OkHttp.builder().url(url).method(POST).data(data).mediaType(mediaType).responseCharset(
//                charset).build());
//    }
//
//    /**
//     * 通用执行方法
//     */
//    private String execute(OkHttp okHttp)
//            throws Exception {
//        if (StringUtils.isEmpty(okHttp.requestCharset)) {
//            okHttp.requestCharset = DEFAULT_CHARSET;
//        }
//        if (StringUtils.isEmpty(okHttp.responseCharset)) {
//            okHttp.responseCharset = DEFAULT_CHARSET;
//        }
//        if (StringUtils.isEmpty(okHttp.method)) {
//            okHttp.method = DEFAULT_METHOD;
//        }
//        if (StringUtils.isEmpty(okHttp.mediaType)) {
//            okHttp.mediaType = DEFAULT_MEDIA_TYPE;
//        }
//        if (okHttp.requestLog) {// 记录请求日志
//            log.info(okHttp.toString());
//        }
//
//        // 获取请求URL
//        String url = okHttp.url;
//        // 创建请求
//        Request.Builder builder = new Request.Builder();
//
//        if (MapUtils.isNotEmpty(okHttp.queryMap)) {
//            String queryParams = okHttp.queryMap.entrySet().stream().map(
//                    entry -> String.format("%s=%s", entry.getKey(), entry.getValue())).collect(
//                    Collectors.joining("&"));
//            url = String.format("%s%s%s", url, url.contains("?") ? "&" : "?", queryParams);
//        }
//        builder.url(url);
//
//        // 设置请求头
//        if (MapUtils.isNotEmpty(okHttp.headerMap)) {
//            okHttp.headerMap.forEach(builder::addHeader);
//        }
//
//        // 设置请求类型
//        String method = okHttp.method.toUpperCase();
//        String mediaType = String.format("%s;charset=%s", okHttp.mediaType, okHttp.requestCharset);
//
//        if (method.equals(GET)) {
//            builder.get();
//        } else if (ArrayUtils.contains(new String[]{POST, PUT, DELETE, PATCH}, method)) {
//            RequestBody requestBody = RequestBody.create(MediaType.parse(mediaType), okHttp.data);
//            builder.method(method, requestBody);
//        } else {
//            throw new RuntimeException("未设置请求method");
//        }
//
//        // 返回值
//        String result = "";
//            Response response = client.newCall(builder.build()).execute();
//            byte[] bytes = response.body().bytes();
//            result = new String(bytes, okHttp.responseCharset);
//            if (okHttp.responseLog) {// 记录返回日志
//                log.info(result);
//            }
//        return result;
//    }
//
//    /**
//     * 一个内部类
//     *
//     * @author gogym
//     * @version 2018年7月30日
//     * @see OkHttp
//     * @since
//     */
//
//    @Builder
//    @ToString(exclude = {"requestCharset", "responseCharset", "requestLog", "responseLog"})
//    class OkHttp {
//        private String url;
//
//        private String method = DEFAULT_METHOD;
//
//        private String data;
//
//        private String mediaType = DEFAULT_MEDIA_TYPE;
//
//        private Map<String, String> queryMap;
//
//        private Map<String, String> headerMap;
//
//        private String requestCharset = DEFAULT_CHARSET;
//
//        private boolean requestLog = DEFAULT_LOG;
//
//        private String responseCharset = DEFAULT_CHARSET;
//
//        private boolean responseLog = DEFAULT_LOG;
//    }
//
//
//    public ReturnInfo  getProductResult(JSONObject jsonStr,  String url)  {
//        System.out.println("getProductResult方法的url============"+url);
//        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
//        // 字符数据最好encoding以下;这样一来，某些特殊字符才能传过去(如:某人的名字就是“&”,不encoding的话,传不过去)
//        // 创建Get请求
//        long a=System.currentTimeMillis();
//        HttpPost httpPost = null;
//        httpPost = new HttpPost(url);
//        long b=System.currentTimeMillis();
//        httpPost.setHeader("Content-Type","application/json; charset=UTF-8");
//        httpPost.setHeader("Accept","application/json");
//        httpPost.setHeader("Accept-Encoding","");
//        System.out.println("接口调用时长"+(b-a));
//        StringEntity entity = new StringEntity(jsonStr.toString(), ContentType.APPLICATION_JSON);
//        httpPost.setEntity(entity);
//
//        CloseableHttpResponse response = null;
//        try {
//            // 配置信息
//            RequestConfig requestConfig = RequestConfig.custom()
//                    // 设置连接超时时间(单位毫秒)
//                    .setConnectTimeout(60000)
//                    // 设置请求超时时间(单位毫秒)
//                    .setConnectionRequestTimeout(60000)
//                    // socket读写超时时间(单位毫秒)
//                    .setSocketTimeout(60000)
////                    设置是否允许重定向(默认为true)
//                    .setRedirectsEnabled(true).build();
//            // 将上面的配置信息 运用到这个Get请求里
//            httpPost.setConfig(requestConfig);
//            // 由客户端执行(发送)Get请求
//            response = httpClient.execute(httpPost);
//            Integer status = response.getStatusLine().getStatusCode();
//            System.out.println("响应状态为:" + status);
//            ReturnInfo hr = new ReturnInfo();
//            hr.setStatus(status);
//            if (status == 200) {
//                String hawkData = EntityUtils.toString(response.getEntity(), "UTF-8");
//                hr.setMessage(hawkData);
//                return hr;
//            }else{
//                String hawkData = EntityUtils.toString(response.getEntity(), "UTF-8");
//                hr.setMessage(hawkData);
//                System.out.println("-------："+hawkData);
//                return hr;
//            }
//        } catch (ClientProtocolException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                // 释放资源
//                if (httpClient != null) {
//                    httpClient.close();
//                }
//                if (response != null) {
//                    response.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("---------------------------调用getApiResult接口结束------------------");
//        return null;
//    }
//}
