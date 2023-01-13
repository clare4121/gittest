package com.bee.sample.chl.exercises.JavaInternet;


/*
* 在以上代码中定义了名为MyServer的服务端实现类，在该类中定义了serverSocketChannel用于ServerSocketChannel的建立和端口的绑定；
* byteBuffer用于不同Channel之间的数据交互；selector用于监听服务器各个Channel上数据的变化并做出响应。
* 同时，在类构造函数中调用了初始化ServerSocketChannel的操作，定义了listener方法来监听Channel上的数据变化，解析客户端的数据并对客户端的请求做出响应。
*
* */
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public  class  MyServer  {
    private  int  size  =  1024;
    private ServerSocketChannel serverSocketChannel;
    private ByteBuffer byteBuffer;
    private Selector selector;
    private  int  remoteClientNum  =  0;
    public  MyServer(int  port)  {
      try  {
          //在构造函数中初始化Channel监听
          initChannel(port);
      }  catch  (IOException e)  {
          e.printStackTrace();
          System.exit(-1);
      }
    }
    //Channel的初始化
    public  void  initChannel(int  port)  throws  IOException  {
      //打开Channel
      serverSocketChannel  =  ServerSocketChannel.open();
      //设置为非阻塞模式
      serverSocketChannel.configureBlocking(false);

      //绑定端口
      serverSocketChannel.bind(new InetSocketAddress(port));
      System.out.println("listener  on  port:  "  +  port);
      //选择器的创建
      selector  =  Selector.open();
      //向选择器注册通道
      serverSocketChannel.register(selector,  SelectionKey.OP_ACCEPT);
      //分配缓冲区的大小
      byteBuffer  =  ByteBuffer.allocate(size);
    }
    //监听器，用于监听Channel上的数据变化
    private  void  listener()  throws  Exception  {
      while  (true)  {
          //返回的int值表示有多少个Channel处于就绪状态
          int  n  =  selector.select();
          if  (n  ==  0)  {
              continue;
          }
          //每个selector对应多个SelectionKey，每个SelectionKey对应一个Channel
          Iterator<SelectionKey> iterator  =
                                    selector.selectedKeys().iterator();
          while  (iterator.hasNext())  {
              SelectionKey  key  =  iterator.next();
              //如果SelectionKey处于连接就绪状态，则开始接收客户端的连接
              if  (key.isAcceptable())  {
                //获取Channel
            ServerSocketChannel  server =  (ServerSocketChannel) key.channel();
                //Channel接收连接
                SocketChannel channel  =  server.accept();
                //Channel注册
                registerChannel(selector,  channel,  SelectionKey.OP_READ);
                //远程客户端的连接数
                remoteClientNum++;
                System.out.println("online  client  num="+remoteClientNum);
                write(channel, "hello  client".getBytes("UTF-8"));
              }
              //如果通道已经处于读就绪状态
              if  (key.isReadable())  {
                read(key);
              }
              iterator.remove();
          }
      }
    }
    private  void  read(SelectionKey  key)  throws  IOException  {
      SocketChannel  socketChannel  =  (SocketChannel)  key.channel();
      int  count;
      byteBuffer.clear();
      //从通道中读数据到缓冲区
        System.out.println("--------发送内容-----");
      while  ((count  =  socketChannel.read(byteBuffer))  >  0)  {
          //byteBuffer写模式变为读模式
          //翻转这个缓冲区。 该限制设置为当前位置，然后将该位置设置为零。 如果标记被定义，则它被丢弃。
          byteBuffer.flip();

        // 告诉当前位置和极限之间是否存在任何元素。  true如果，并且只有在此缓冲区中至少有一个元素

          while  (byteBuffer.hasRemaining())  {
              System.out.print((char)byteBuffer.get());
          }
          byteBuffer.clear();
      }
      if  (count  <  0)  {
          socketChannel.close();
      }
    }
    private  void  write(SocketChannel  channel, byte[]  writeData)  throws IOException  {
      byteBuffer.clear();
      byteBuffer.put(writeData);
      //byteBuffer从写模式变成读模式
      byteBuffer.flip();
      //将缓冲区的数据写入通道中
      channel.write(byteBuffer);
    }
    private  void  registerChannel(Selector  selector,  SocketChannel  channel, int  opRead)  throws  IOException  {
      if  (channel  ==  null)  {
          return;
      }
        //设置为非阻塞模式
      channel.configureBlocking(false);
      channel.register(selector,  opRead);
    }
    public  static  void  main(String[]  args)  {
      try  {
          MyServer  myServer  =  new  MyServer(9999);
          myServer.listener();
      }  catch  (Exception  e)  {
          e.printStackTrace();
      }
    }


}