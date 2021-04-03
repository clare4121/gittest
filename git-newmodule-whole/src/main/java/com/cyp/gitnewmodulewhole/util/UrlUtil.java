package com.cyp.gitnewmodulewhole.util;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
public class UrlUtil  {
    public String sendPost(String url, JSONObject jsonStr) throws IOException {
        CloseableHttpClient httpClient =HttpClientBuilder.create().build();
        HttpPost httpPost =new HttpPost(url);
        httpPost.setHeader("Content-Type","application/json");
        httpPost.setHeader("Accept","application/json");
        httpPost.setHeader("Accept-Encoding","gzip");
        StringEntity entity = new StringEntity(jsonStr.toString(),ContentType.APPLICATION_JSON);
        httpPost.setEntity(entity);
        RequestConfig requestConfig = RequestConfig.custom()
                // 设置连接超时时间(单位毫秒)
                .setConnectTimeout(60000)
                // 设置请求超时时间(单位毫秒)
                .setConnectionRequestTimeout(60000)
                // socket读写超时时间(单位毫秒)
                .setSocketTimeout(60000)
//                    设置是否允许重定向(默认为true)
                .setRedirectsEnabled(true).build();
        // 将上面的配置信息 运用到这个Get请求里
        httpPost.setConfig(requestConfig);
        // 由客户端执行(发送)Get请求
        CloseableHttpResponse response = httpClient.execute(httpPost);
        Integer status = response.getStatusLine().getStatusCode();
        System.out.println("响应状态为:" + status);
        return EntityUtils.toString(entity,"UTF-8");
    }
    public static void main(String[] args) throws IOException {
//        String url="http://wwww.baidu.com/name=cyp&timestamp=2020-10-11 23:34:00 111&password=1111";
        String url="http://wwww.baidu.com/name=cyp&timestamp=2020-10-11";
        String encodeUrl= URLEncoder.encode(url,"UTF-8");
        String decodeUrl = URLDecoder.decode(encodeUrl,"UTF-8");
        System.out.println(url);
        System.out.println("de====================="+encodeUrl);
        System.out.println("de====================="+decodeUrl);
    }




}
