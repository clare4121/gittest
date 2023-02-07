package com.bee.sample.chl.util;

import org.springframework.util.FileCopyUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author cyp
 * @version 1.0.0
 * @ClassName BinUtil.java
 * @Description TODO
 * @createTime 2023年02月07日 14:45:00
 */
public class BinUtil {

    /**
     * 文件转为二进制数组
     * 等价于fileToBin
     * @param file
     * @return
     */
    public static byte[] getFileToByte(File file) {
        byte[] by = new byte[(int) file.length()];
        try {
            InputStream is = new FileInputStream(file);
            ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
            byte[] bb = new byte[2048];
            int ch;
            ch = is.read(bb);
            while (ch != -1) {
                bytestream.write(bb, 0, ch);
                ch = is.read(bb);
            }
            by = bytestream.toByteArray();
        } catch (Exception ex) {
            throw new RuntimeException("transform file into bin Array 出错",ex);
        }
        return by;
    }

    /**
     * 二进制字符串转文件
     * @param bin
     * @param fileName
     * @param parentPath
     * @return
     */
    public static File binToFile(String bin,String fileName,String parentPath){
        try {
            File fout = new File(parentPath,fileName);
            fout.createNewFile();
            byte[] bytes1 = bin.getBytes("ISO-8859-1");
            FileCopyUtils.copy(bytes1,fout);

            //FileOutputStream outs = new FileOutputStream(fout);
            //outs.write(bytes1);
            //outs.flush();
            //outs.close();

            return fout;
        }catch (Exception ex){
            throw new RuntimeException("transform bin into File 出错",ex);
        }
    }


}
