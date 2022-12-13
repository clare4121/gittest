package com.bee.sample.chl.util;

import java.io.*;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName StreamClass.java
 * @Description TODO
 * @createTime 2022年10月21日 14:59:00
 */
public class StreamClass {

    public static void main(String[] args) {

        File f =new File("D:\\var","test.txt");
        try {
            FileInputStream fis= new FileInputStream(f);
            byte[] b=new byte[(int)f.length()];
            fis.read(b);

            //创建输出文件 让后流写入
            File fi = File.createTempFile("CopyTest",".txt",new File("D:\\var"));
            FileOutputStream fos =new FileOutputStream(fi);
            fos.write(b);
            fos.close();
            fis.close();



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
