package com.bee.sample.chl.util;

import java.io.*;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName FileWriterClass.java
 * @Description TODO
 * @createTime 2022年10月21日 17:36:00
 */
public class FileWriterClass {

    public static void main(String[] args) throws IOException {
        System.out.println("请输入留言");
        int  n;
        InputStreamReader in =new InputStreamReader(System.in);


        File f= new File("D:\\var","a.txt");

        FileWriter fw =new FileWriter(f);

        FileReader fr = new FileReader(f);

        while((n=in.read())!='\n'){
            fw.write(n);
        }
        in.close();
        fw.close();
        char ch[] = new char[(int)f.length()];
        fr.read(ch);


        for (int i = 0; i <ch.length ; i++) {
            System.out.println(ch[i]);
        }

    }
}
