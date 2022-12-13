package com.bee.sample.chl.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName ReaderAndWriteStreamClass.java
 * @Description TODO
 * @createTime 2022年10月21日 15:49:00
 */
public class ReaderAndWriteStreamClass {
    public static void main(String[] args) {
        int c ;
        InputStreamReader in = new InputStreamReader(System.in);
        OutputStreamWriter out =new OutputStreamWriter(System.out);
        System.out.println("请输入一行字符，并按回车键结束");
        try {
        while((c=in.read())!='\n') {
            out.write(c);
        }
            out.close();
            in.close();

        } catch (IOException e) {
            System.out.println("输入流有误");
        }
    }

}
