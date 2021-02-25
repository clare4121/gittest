package com.cyp.gitnewmodulewhole.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class GetPostTest {
    /**
     * 向指定的url发送get请求
     * @param url 发送请求的url
     * @param param 发送请求的参数 应该满足name1=value1&name2=value2的形式
     * @return 远程资源的相应
     * @auhor: cyp
     * @data: 2021/2/23
     */

    public static String sendGet(String url,String param) {
        String result = "";
        String urlName = url + "?" + param;
        try {
            URL realUrl = new URL(urlName);
            //打开和url之间的连接
            URLConnection conn = realUrl.openConnection();
            //设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0; Windows NT 5.1;SV1)");
            //建立实际的连接
            conn.connect();
            //获取所有的响应头字段
            Map<String, List<String>> map = conn.getHeaderFields();

            for (String key : map.keySet()) {
                System.out.println(key + "----->" + map.get(key));
            }
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))
            ) {
                String line;
                while ((line = in.readLine()) != null) {
                    result += "\n" + line;
                }
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 向指定的url发送post请求
     * @param url 发送请求的url
     * @param param 发送请求的参数 应该满足name1=value1&name2=value2的形式
     * @return 远程资源的相应
     * @auhor: cyp
     * @data: 2021/2/23
     */
    public static String sendPost(String url,String param){

        String result="";
        try{
        URL realUrl = new URL(url);
        URLConnection conn = realUrl.openConnection();
        conn.setRequestProperty("accept","*/*");
        conn.setRequestProperty("connection", "Keep-Alive");
        conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible;MSIE 6.0; Windows NT 5.1;SV1)");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        try (
                PrintWriter out =new PrintWriter(conn.getOutputStream())){
            out.print(param);
            out.flush();
        }
        try (
                BufferedReader in =new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"))
                ){
            String line;
            while ((line=in.readLine())!=null){
                result+="\n"+line;

            }
        }
        }catch (Exception e){
            System.out.println("发送post请求出现异常"+e);
            e.printStackTrace();
        }
        return result;
    }

}
