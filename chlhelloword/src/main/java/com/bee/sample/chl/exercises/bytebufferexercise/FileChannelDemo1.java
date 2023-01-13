package com.bee.sample.chl.exercises.bytebufferexercise;

import cn.hutool.core.io.resource.ClassPathResource;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
//输出乱码
public class FileChannelDemo1 {
    // FileChannel读取数据到buffer中
    public static void main(String[] args) throws Exception {
        // 创建FileChannel
        ClassPathResource classPathResource =new ClassPathResource("/a.txt");

        RandomAccessFile aFile = new RandomAccessFile(classPathResource.getAbsolutePath(), "rw");
        FileChannel channel = aFile.getChannel();
        // 创建Buffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(21);
        // 读取数据到buffer中
        int bytesRead = channel.read(byteBuffer);
        System.out.print("读取内容");
        while (bytesRead != -1) {
          System.out.print(bytesRead);
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                System.out.print(StandardCharsets.UTF_8.decode(byteBuffer));
            }
            byteBuffer.compact();
            bytesRead = channel.read(byteBuffer);
        }
        aFile.close();
    }
}
