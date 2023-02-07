package com.bee.sample.chl.controller;



import com.bee.sample.chl.util.BinUtil;
import com.bee.sample.chl.util.RedisUtil;
import lombok.SneakyThrows;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;


/**
 * @author cyp
 * @version 1.0.0
 * @ClassName RedisController.java
 * @Description TODO
 * @createTime 2023年02月01日 14:33:00
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @SneakyThrows
    @GetMapping(value = "/demo")
    public int getCreditLevel(String key ,String value){
//        String key =map.get("key").toString();
//        String value =map.get("value").toString();
        //创建一个redis对象
        Jedis jedis = RedisUtil.getJedisConn();

        ClassPathResource classPathResource = new ClassPathResource("hashmap.jpg");
        File file =classPathResource.getFile();

        byte[] fileBytes =BinUtil.getFileToByte(file);
        jedis.set("picture_two".getBytes(),fileBytes);




        int a=Integer.valueOf(value);
        jedis.set(key,a+"--","NX");
        //用完关闭
        RedisUtil.closeJedisConn(jedis);
        return a;
    }

    @SneakyThrows
    @GetMapping(value = "/demo2")
    public void getCreditLevel2(){
        ClassPathResource classPathResource = new ClassPathResource("hashmap.jpg");
        InputStream inputStream = classPathResource.getInputStream();
        Jedis jedis = RedisUtil.getJedisConn();
        jedis.set("picture".getBytes(),   readInputStream(inputStream));


        //用完关闭
        RedisUtil.closeJedisConn(jedis);
    }


    @SneakyThrows
    @GetMapping(value = "/getdemo2")
    public void getCreditLevelget2(){
        Jedis jedis = RedisUtil.getJedisConn();

        BinUtil.binToFile(jedis.get("picture_two"),"hashmap222","D:\\vartem\\");



        byte[] bytes1  =jedis.get("picture".getBytes());
        InputStream bais = new ByteArrayInputStream(bytes1);
        BufferedImage bi1 =ImageIO.read(bais);

        //可以是jpg,png格式
        File w2 = new File("D:\\vartem\\hashmap2.jpg");
        if (!w2.exists()) {
            //文件不存在则创建文件，先创建目录
            File dir = new File(w2.getParent());
            dir.mkdirs();
            // 创建新文件
            w2.createNewFile();
        }
        //不管输出什么格式图片，此处不需改动
        ImageIO.write(bi1, "jpg", w2);
        //用完关闭
        RedisUtil.closeJedisConn(jedis);
    }
















    private static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        //转换为二进制
        byte[] buffer = new byte[1024];

        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        return outStream.toByteArray();

    }



}
