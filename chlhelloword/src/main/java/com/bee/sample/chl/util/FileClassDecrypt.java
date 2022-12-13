package com.bee.sample.chl.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName FileClassDecrypt.java
 * @Description TODO
 * @createTime 2022年10月21日 14:44:00
 */
public class FileClassDecrypt {
    public static void main(String[] args) {
        File file = new File("D:\\临时存放文件夹\\file.txt");
        byte[] bf =new byte[(int)file.length()];
        try {
            RandomAccessFile rf =new RandomAccessFile(file,"rw");


            rf.read(bf);

            for (int i = 0; i <bf.length ; i++) {
                bf[i] =(byte)(bf[i]-12);
            }
            //清除原来的文件内容
            rf.setLength(0);
            rf.write(bf);
            rf.seek(1);

            System.out.println((char)rf.read());




        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
