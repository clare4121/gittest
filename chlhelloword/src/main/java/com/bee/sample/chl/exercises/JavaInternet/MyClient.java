package com.bee.sample.chl.exercises.JavaInternet;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public  class  MyClient  {
    private  int  size  =  1024;
    private ByteBuffer byteBuffer;
    private SocketChannel socketChannel;
    public  void  connectServer(String str)  throws IOException {
        //打开Channel
      socketChannel  =  SocketChannel.open();
      socketChannel.connect(new InetSocketAddress("127.0.0.1",  9999));
      //设置为非阻塞模式
      socketChannel.configureBlocking(false);

      //分配缓冲区的大小
      byteBuffer  =  ByteBuffer.allocate(size);
      receive(str);
    }
    private  void  receive(String str)  throws  IOException  {
      while  (true)  {
          byteBuffer.clear();
          int  count;
          //如果没有数据可读，则read方法一直阻塞，直到读取到新的数据
          while  ((count  =  socketChannel.read(byteBuffer))  >  0)  {
              byteBuffer.flip();
              while  (byteBuffer.hasRemaining())  {
                  System.out.print((char)byteBuffer.get());
              }
              send2Server(str);
              byteBuffer.clear();
          }
      }
    }
    private  void  send2Server(String str )  throws  IOException  {
        byte[] bytes = str.getBytes();
        byteBuffer.clear();
        byteBuffer.put(bytes);
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
    }
    public  static  void  main(String[]  args)  throws  IOException  {
        String finalStr =null;
        System.out.println("请输入字符串：");
        Scanner scStr = new Scanner(System.in);
        while(scStr.hasNext()){
            finalStr = scStr.next();
            new  MyClient().connectServer(finalStr);
        }

    }
}